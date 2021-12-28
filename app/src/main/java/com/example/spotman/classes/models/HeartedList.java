package com.example.spotman.classes.models;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.subObjects.Track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//this is a Settable wrapper

public class HeartedList implements Settable
{

    //link to each track with dict necessary?

    //List<Track> assocTrackList;
    List<Boolean> heartedList;

    public HeartedList()
    {

    }


    @Override
    public void setLoaded(boolean isLoaded)
    {

    }

    @Override
    public void setFromJson(String json)
    {
        heartedList = new ArrayList<Boolean>();

        heartedList = MainActivity.global.gson.fromJson(json, heartedList.getClass());

       // MainActivity.log.log("\n\tHearted: \n\t" + heartedList.toString());
    }


    public List<Boolean> getHeartedList()
    {
        return heartedList;
    }


    public static HeartedList fetchHeartedList(String trackIds)
    {
        //on set, gets which songs are hearted - must be done in setFromJson() in model to stay synchronous
        HeartedList heartedList = new HeartedList();
        MainActivity.global.requester.getAndSetAsync("me/tracks/contains?ids=" + trackIds, heartedList);

        return heartedList;
    }
}
