package com.example.spotman.classes.misc;

import android.content.Context;
import android.widget.TabHost;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.misc.http.AccessToken;
import com.example.spotman.classes.misc.http.Requester;
import com.example.spotman.classes.models.root.Playlist;
import com.example.spotman.classes.models.root.PlaylistList;
import com.example.spotman.classes.models.root.PlaylistTracks;
import com.example.spotman.classes.models.root.Profile;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.classes.models.root.TopTracks;
import com.example.spotman.databinding.PlaylistsFragmentBinding;
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
    public final String[] SCOPES_LIST = new String[] { "user-read-recently-played", "playlist-read-private", "playlist-modify-public", "playlist-modify-private",
            "ugc-image-upload", "user-library-modify", "user-top-read", "user-library-read"};



    public AccessToken accessToken;
    public boolean authenticated = false;

    public Gson gson = new Gson();

    public Context appContext;

    //=======================================================================
    //models

    //me:
    public String myProfileID = new String();
    public TopTracks myTopTracks = new TopTracks();

    public Profile myProfile = new Profile();
    public RecentlyPlayed myRecentlyPlayed = new RecentlyPlayed();
    public PlaylistList myPlaylistsList = new PlaylistList();

    //user:
    public Profile selectedProfile = new Profile();
    public RecentlyPlayed selectedProfileRecentlyPlayed = new RecentlyPlayed();

    public PlaylistList selectedProfilePlaylistsList = new PlaylistList();

    public Playlist selectedPlaylist = new Playlist();
    public PlaylistTracks selectedPlaylistTracks = new PlaylistTracks();


    public void getMe()
    {
        //me only:
        requester.getAndSetAsync("me", myProfile);
        requester.getAndSetAsync("me/player/recently-played", myRecentlyPlayed);
        requester.getAndSetAsync("me/top/tracks", myTopTracks);

        myProfileID = myProfile.getId();

        requester.getAndSetAsync("me/playlists", myPlaylistsList);

        selectedProfile = myProfile;
        selectedProfilePlaylistsList = myPlaylistsList;
        selectedProfileRecentlyPlayed = myRecentlyPlayed;



    }

    public void getUserPlaylists(String userId)
    {
        //todo: need to loop this w/ offset
        requester.getAndSetAsync("users/" + userId + "/playlists?limit=50", selectedProfilePlaylistsList);
    }

    public void getPlaylist(String playlistId)
    {
        requester.getAndSetAsync("playlists/" + playlistId, selectedPlaylist);
        requester.getAndSetAsync("playlists/" + playlistId + "/tracks", selectedPlaylistTracks);
    }

    public void getPlaylist(String playlistId, PlaylistsFragmentBinding fragmentBinding)
    {
        getPlaylist(playlistId);

    }


    //========

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
