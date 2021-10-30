package com.example.spotman.classes.misc.http;

import androidx.annotation.NonNull;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.Fact;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Requester
{
    //constant
    static final String urlBase = "https://catfact.ninja/";

    //log reference here?

    OkHttpClient client;


    public Requester()
    {

        client = new OkHttpClient();
    }


    //quick request generator w/ builders
    Request MakeRequest(String urlPath)
    {
        //creates versatile httpUrl object
        HttpUrl url = HttpUrl.parse(urlBase + urlPath).newBuilder().build();


        //creates request
        Request request = new Request.Builder().url(url).build();

        //logs request created
        MainActivity.log.logRequest(request);

        return request;
    }



    //GET :

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




    //GET ASYNC :

    public void GetAsync(String urlPath, Object factOut)
    {

        //start request
        Request request = MakeRequest(urlPath);

        client.newCall(request).enqueue(new Callback()
        {



            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e)
            {
                MainActivity.log.logError("GET async error: " + e.toString() + " " + e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
            {
                //its either impossible or entirely convoluted to return the json string directly...

                //response string in json
                //body().string() can only be got once!!
                String strJson = response.body().string();

                MainActivity.log.log( "GET async success: " + urlPath, "http");

                //init gson (scope this somewhere more efficient?)
                Gson gson = new Gson();

                //into object
                Fact factReturn = gson.fromJson(strJson, Fact.class);

                //now can store it somewhere
                MainActivity.global.factList.add(factReturn);


//=======================================================================
                //you are here
                //pain in the ass.
//=======================================================================

            }
        });





    }


}
