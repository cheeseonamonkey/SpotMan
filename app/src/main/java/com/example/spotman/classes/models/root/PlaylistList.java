package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class PlaylistList  implements Settable
{
    public PlaylistList()
    {
    }

    private String href;
    private List<Item> items;
    private int limit;
    private String next;
    private int offset;
    private java.lang.Object previous;
    private int total;

    @Override
    public void setLoaded(boolean isLoaded)
    {

    }

    @Override
    public void setFromJson(String json)
    {
        PlaylistList p = MainActivity.global.gson.fromJson(json, PlaylistList.class);

        href = p.href;
        items = p.items;
        limit = p.limit;
        next = p.next;
        offset = p.offset;
        previous = p.previous;
        total = p.total;
    }

    public List<Item> getItems() {
        return items;
    }

    public int getCount() {
        return total;
    }
}
