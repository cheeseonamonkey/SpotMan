package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.HeartedList;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Cursors;
import com.example.spotman.classes.models.subObjects.Item;
import com.example.spotman.classes.models.subObjects.Track;

import java.util.ArrayList;
import java.util.List;

public class RecentlyPlayed implements Settable
{


    private List<Item> items;
    private String next;
    private Cursors cursors;
    private int limit;
    private String href;

    public boolean isLoaded = false;


    HeartedList heartedList;


    public String getTrackIdsString()
    {
        String strOut = "";

        if(items != null)
        {
            for (Item i : items)
            {
                strOut += i.getTrack().getId() + ",";
            }

            strOut = strOut.substring(0, strOut.length() - 1);

            return strOut;

        }else
            return "no IDs set.";

    }


    @Override
    public String toString()
    {
        return "RecentlyPlayed{" +
                "items=" + items +
                ", next='" + next + '\'' +
                ", cursors=" + cursors +
                ", limit=" + limit +
                ", href='" + href + '\'' +
                '}';
    }



    @Override
    public void setLoaded(boolean isLoaded)
    {
        this.isLoaded = isLoaded;
    }

    @Override
    public void setFromJson(String json)
    {
        RecentlyPlayed rp = MainActivity.global.gson.fromJson(json, RecentlyPlayed.class);

        items = rp.items;
        next = rp.next;
        cursors = rp.cursors;
        limit = rp.limit;
        href = rp.href;

        setLoaded(true);

        MainActivity.log.log("MyRecentlyPlayed set", "model");


        //on set, gets which songs are hearted - must be done here to stay synchronous
        heartedList = new HeartedList();
        MainActivity.global.requester.GetAndSetAsync("me/tracks/contains?ids=" + getTrackIdsString(), heartedList);




    }




    public List<Track> getTracklist()
    {
        List<Track> trackList = new ArrayList<>();

        for(Item i : items)
        {
            trackList.add(i.getTrack());
        }

        return trackList;
    }

    public void setHeartedList()
    {
        //sloppy
        for (int i = 0; i < items.size(); i++)
        {
            items.get(i).getTrack().setHearted(
                    heartedList.getHeartedList().get(i) );
        }
    }


}
