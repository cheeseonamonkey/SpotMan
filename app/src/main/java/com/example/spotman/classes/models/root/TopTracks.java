package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.HeartedList;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Track;
import com.google.gson.Gson;

import java.util.List;

public class TopTracks implements Settable
{
    public List<Track> items;
    public int total;
    public int limit;
    public int offset;
    public String previous;
    public String href;
    public String next;

    public boolean isLoaded;



    HeartedList heartedList;



    public String getTrackIdsString()
    {
        String strOut = "";

        if(items != null)
        {
            for (Track t : items)
            {
                strOut += t.getId() + ",";
            }

            strOut = strOut.substring(0, strOut.length() - 1);

            return strOut;

        }else
            return "no IDs set.";

    }


    @Override
    public void setLoaded(boolean isLoaded)
    {
        this.isLoaded = isLoaded;
    }

    @Override
    public void setFromJson(String json)
    {
        Gson gson = MainActivity.global.gson;

        TopTracks tt = gson.fromJson(json, TopTracks.class);



        items = tt.items;
        total = tt.total;
        limit = tt.limit;
        offset = tt.offset;
        previous = tt.previous;
        href = tt.href;
        next = tt.next;

        MainActivity.log.log("MyTopTracks set", "model");

        setLoaded(true);


        //on set, gets which songs are hearted - must be done here to stay synchronous
        heartedList = new HeartedList();
        MainActivity.global.requester.GetAndSetAsync("me/tracks/contains?ids=" + getTrackIdsString(), heartedList);



    }


    public List<Track> getTracklist()
    {
        return items;
    }

    public void setHeartedList()
    {
        //sloppy
        for (int i = 0; i < items.size(); i++)
        {
            items.get(i).setHearted(
                    heartedList.getHeartedList().get(i) );
        }
    }
}
