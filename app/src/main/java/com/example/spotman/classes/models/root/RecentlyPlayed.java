package com.example.spotman.classes.models.root;

import android.content.Context;
import android.widget.LinearLayout;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.SettableModel;
import com.example.spotman.classes.models.subObjects.Cursors;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class RecentlyPlayed implements SettableModel
{


    private List<Item> items;
    private String next;
    private Cursors cursors;
    private int limit;
    private String href;

    public boolean isLoaded = false;

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
    public void setFromJson(String json)
    {
        RecentlyPlayed rp = MainActivity.global.gson.fromJson(json, RecentlyPlayed.class);

        items = rp.items;
        next = rp.next;
        cursors = rp.cursors;
        limit = rp.limit;
        href = rp.href;

        isLoaded = true;

        MainActivity.log.log("MyRecentlyPlayed set", "model");

    }


/*
    public static LinearLayout buildListItem(RecentlyPlayed recentlyPlayed, Context context)
    {
        LinearLayout linRoot = new LinearLayout(context);

        return linRoot;

    }
*/

    public List<Item> getItems()
    {
        return items;
    }
}
