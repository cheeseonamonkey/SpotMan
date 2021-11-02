package com.example.spotman.classes.misc.http;

import android.content.Context;

import com.example.spotman.MainActivity;
import com.spotify.sdk.android.auth.AuthorizationClient;

public class AccessToken
{
    public String access_token;
    public String token_type;
    public long expires_in;

    public String scope;

    public boolean isSet()
    {
        if (access_token == null || access_token == "")
            return false;
        else
            return true;
    }

    public void resetAccessToken(Context mainContext)
    {
       // Globals.Connected = false;
        access_token = "";

        AuthorizationClient.clearCookies(mainContext);
    }

    public void setAccess_token(String token)
    {
        access_token = token;
    }
    public void setAccessToken(String token, String token_type, long expires_in)
    {
        access_token = token;
        this.token_type = token_type;
        this.expires_in = expires_in;
    }
}
