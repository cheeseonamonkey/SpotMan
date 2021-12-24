package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Item;
import com.example.spotman.classes.models.subObjects.Track;

import java.util.ArrayList;
import java.util.List;

public class PlaylistTracks implements Settable
{
    public PlaylistTracks()
    {
    }

    boolean isLoaded = false;


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

    //todo: put this isloaded in that model interface
    public boolean isLoaded()
    {
        return isLoaded;
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

        setLoaded(true);


    }
}
