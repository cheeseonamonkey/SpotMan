package com.example.spotman.classes.misc.http;

import android.content.Context;

import androidx.annotation.NonNull;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.misc.MyLogger;
import com.example.spotman.classes.models.Settable;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requester
{
    //urlBase of API
    static final String urlBase = "https://api.spotify.com/v1/";

    MyLogger log;

    OkHttpClient client;

    //Executor mainExecutor;
    MainActivity mainActivity;


    //=======================================================================
    //CONSTRUCTOR:
    public Requester(Context mainContext)
    {
        //http client
        client = new OkHttpClient();

        //these constructor args will be our refs the main context:
        //this.mainExecutor = mainExecutor;
        this.mainActivity = mainActivity;


        //log ref
        this.log = MainActivity.log;


    }
    //=======================================================================



    //quick request generator
    Request MakeRequest(String urlPath)
    {
        //creates versatile httpUrl object
        HttpUrl url = HttpUrl.parse(urlBase + urlPath).newBuilder().build();

        //creates request
        Request request = new Request.Builder().url(url).addHeader("Authorization","Bearer " + MainActivity.global.accessToken.access_token).build();

        //logs request created
        MainActivity.log.logRequest(request);

        return request;
    }


    //GET (synchronous):
    public void Get(String urlPath)
    {

        Request request = MakeRequest(urlPath);


        try
        {
            //executes call synchronously:
            Response response = client.newCall(request).execute();

            if(response.isSuccessful())
                MainActivity.log.log(response.body().string(), "http");

        }catch(Exception exc)
        {
            MainActivity.log.logError(exc.toString());
        }



    }


    //=======================================================================
    //GET(async):

    public void getAndSetAsync(String urlPath, Settable outObj)
    {

       //start request
        Request request = MakeRequest(urlPath);

        //enqueue the request and implement callbacks:

        client.newCall(request).enqueue(new Callback()
        {

            //TIMED OUT:
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e)
            {
                MainActivity.log.logError("Time-out or no response received from GET:  " + e.toString() + " " + e.getMessage());
            }


            //RESPONSE:
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
            {

                // if status success:
                if(response.isSuccessful())
                {

                    //  body().string() can only be read once
                //response string in JSON:
                String strJson = response.body().string();



                MainActivity.log.log( "GET async success: " + urlPath, "http");


                //final output object
                // final Fact factOut = new Gson().fromJson(strJson, Fact.class);


                //we cannot assign directly to to the main thread,
                //but we can work with an existing collections/objects:

                //or we can run on the UI thread?



                    //output
                    outObj.setFromJson(strJson);





                }

                else // status code bad
                {
                    log.logError("status success code bad   - " + response.code() + " - " + response.message().toString() + response.toString());
                }






            }//end of overridden onResponse(), and end of this thread

        });





    }//=======================================================================
    //end of GET (async)



}
