package com.example.spotman.classes.misc;

import android.content.Context;

import com.example.spotman.classes.Fact;
import com.example.spotman.classes.misc.http.Requester;

import java.util.ArrayList;
import java.util.List;

public class Global
{


    //=======================================================================
    //global fields:

    public Requester requester;

    public Context mainContext;

    //authorization:
    public final String CLIENT_ID = "7b0da78a9ddf480b8c0c5180c80da606";
    //must match spotify's servers:
    public final String REDIRECT_URI = "http://localhost/good";
    public final String[] SCOPES_LIST = new String[] { "user-read-recently-played", "playlist-read-private", "playlist-modify-public", "playlist-modify-private", "ugc-image-upload", "user-library-modify"};


    //end of global fields
    //=======================================================================


    //constructor
    public Global()
    {
    }


    public void initRequester(Context context)
    {
        requester = new Requester(context);
    }

}
