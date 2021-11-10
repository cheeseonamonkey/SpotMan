package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.SettableModel;
import com.example.spotman.classes.models.subObjects.Item;
import com.google.gson.Gson;

import java.util.List;

public class TopTracks implements SettableModel
{
    public List<Item> items;
    public int total;
    public int limit;
    public int offset;
    public String previous;
    public String href;
    public String next;

    public boolean isLoaded;


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

    }

    //=======================================================================
    //ISSUE IS HERE:
    //if you check the json in postman you can see that the items are nested slightly differently in recents / tops
    //can fix probably with a type check

    public List<Item> getItems()
    {
        return items;
    }
}