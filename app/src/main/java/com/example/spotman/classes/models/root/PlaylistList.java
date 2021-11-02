package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class PlaylistList
{
    public PlaylistList()
    {
    }

    private String href;
    private List<Item> items;
    private int limit;
    private String next;
    private int offset;
    private Object previous;
    private int total;
}
