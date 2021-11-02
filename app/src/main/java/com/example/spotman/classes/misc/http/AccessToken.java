package com.example.spotman.classes.misc.http;

import android.content.Context;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.misc.Global;
import com.spotify.sdk.android.auth.AuthorizationClient;

public class AccessToken
{

    public static AccessToken newToken()
    {
        return new AccessToken();
    }

    public String access_token;
    public String token_type;
    public long expires_in;

    public String scope;

    public boolean isSet()
    {
        return access_token != null && access_token != "";
    }

    public void resetAccessToken(Context context)
    {
       // Globals.Connected = false;
        access_token = "";

        //todo: clear cookies
        // AuthorizationClient.clearCookies(context);

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
