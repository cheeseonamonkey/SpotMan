package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.Cursors;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class RecentlyPlayed implements Settable
{
    private List<Item> items;
    private String next;
    private Cursors cursors;
    private int limit;
    private String href;

    @Override
    public void setFromJson(String json)
    {
        RecentlyPlayed rp = MainActivity.global.gson.fromJson(json, RecentlyPlayed.class);

        items = rp.items;
        next = rp.next;
        cursors = rp.cursors;
        limit = rp.limit;
        href = rp.href;
    }
}
