package com.example.spotman.classes.ui.splash;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.spotify.sdk.android.auth.AuthorizationClient;
import com.spotify.sdk.android.auth.AuthorizationRequest;
import com.spotify.sdk.android.auth.AuthorizationResponse;

public class AuthActivity extends AppCompatActivity
{
    // Request code will be used to verify if result comes from the login activity. Can be set to any integer
    final int REQUEST_CODE = 4200;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        AuthenticateSpotify();
    }

    public void AuthenticateSpotify()
    {


        AuthorizationRequest.Builder authBuilder = new AuthorizationRequest.Builder(
                MainActivity.global.CLIENT_ID,          //?client_id=
                AuthorizationResponse.Type.TOKEN,       //&type=code
                MainActivity.global.REDIRECT_URI);      //&scope=

        authBuilder.setScopes(MainActivity.global.SCOPES_LIST);

        AuthorizationRequest authRequest = authBuilder.build();

        AuthorizationClient.openLoginActivity(this, REQUEST_CODE, authRequest);
        //      MainActivity.log.log("Current activity: " + getActivity().getPackageName(), "auth");




    }




    //callback for auth
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intentData)
    {
        super.onActivityResult(requestCode, resultCode, intentData);

        if(requestCode == REQUEST_CODE)
        {
            AuthorizationResponse authResponse = AuthorizationClient.getResponse(resultCode, intentData);

            switch (authResponse.getType())
            {
                //success:
                case TOKEN:

                    MainActivity.log.log("Auth success! ", "auth");




                    break;


                    //error:
                case ERROR:
                    MainActivity.log.log("AUTH ERROR: ", "error");

                    break;



                default:
                    MainActivity.log.log("Authorization cacelled?", "error");

                    break;


            }

        }else
            MainActivity.log.log("Request codes don't match", "auth");


    }
}