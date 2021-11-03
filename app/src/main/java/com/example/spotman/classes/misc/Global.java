package com.example.spotman.classes.misc;

import android.content.Context;

import com.example.spotman.classes.misc.http.AccessToken;
import com.example.spotman.classes.misc.http.Requester;
import com.example.spotman.classes.models.root.Profile;
import com.google.gson.Gson;

public class Global
{


    //=======================================================================
    //global fields:

    public Requester requester;

    //set in main activity once it is initialized
    public Context mainContext;

    //authorization:
    public final String CLIENT_ID = "7b0da78a9ddf480b8c0c5180c80da606";
    //must match spotify's servers:
    public final String REDIRECT_URI = "http://localhost/good";
    public final String[] SCOPES_LIST = new String[] { "user-read-recently-played", "playlist-read-private", "playlist-modify-public", "playlist-modify-private", "ugc-image-upload", "user-library-modify"};

    public AccessToken accessToken;

    public Gson gson = new Gson();


    //=======================================================================
    //models

    public Profile myProfile = new Profile();
    public Profile selectedProfile = new Profile();

/*    public void setSelectedProfile(String json)
    {
        selectedProfile = Profile.newFromJson(json);
    }

    public void setMyProfile(String json)
    {
        myProfile = Profile.newFromJson(json);
    }*/





    //constructor
    public Global()
    {

    }


    public void initRequester(Context context)
    {
        requester = new Requester(context);
    }

}
