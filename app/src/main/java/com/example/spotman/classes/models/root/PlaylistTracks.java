package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class PlaylistTracks implements Settable
{
    public PlaylistTracks()
    {
    }

    private String href;
    private List<Item> items;
    private int limit;
    private Object next;
    private int offset;
    private Object previous;
    private int total;

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
    }
}
