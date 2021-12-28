package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.HeartedList;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Item;
import com.example.spotman.classes.models.subObjects.Track;
import com.example.spotman.classes.ui.playlists.PlaylistsFragment;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTracks implements Settable
{
    public PlaylistTracks()
    {
        items = new ArrayList<>();

    }

    boolean isLoaded = false;

    HeartedList heartedList;

    private String href;
    private List<Item> items;
    private int limit;
    private java.lang.Object next;
    private int offset;
    private java.lang.Object previous;
    private int total;


    @Override
    public String toString()
    {
        return "PlaylistTracks{" +
                "href='" + href + '\'' +
                ", items=" + items +
                ", limit=" + limit +
                ", next=" + next +
                ", offset=" + offset +
                ", previous=" + previous +
                ", total=" + total +
                '}';
    }

    //todo: require this isloaded in that model interface
    public boolean isLoaded()
    {
        return isLoaded;
    }


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
    public void setLoaded(boolean isLoaded)
    {
        this.isLoaded = isLoaded;

    }

    public List<Track> getTrackList()
    {
        List<Track> trackListOut = new ArrayList<>();

        for(Item i : items)
        {
            trackListOut.add(i.getTrack());
        }

        return trackListOut;
    }

    @Override
    public void setFromJson(String json)
    {
        PlaylistTracks p = MainActivity.global.gson.fromJson(json, PlaylistTracks.class);


        href = p.href;
        items = p.items;
        limit = p.limit;
        next = p.next;
        offset = p.offset;
        previous = p.previous;
        total = p.total;

        heartedList = HeartedList.fetchHeartedList(getTrackIdsString());

        setLoaded(true);






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
