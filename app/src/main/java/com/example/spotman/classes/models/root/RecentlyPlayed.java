package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.subObjects.Cursors;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class RecentlyPlayed
{
    private List<Item> items;
    private String next;
    private Cursors cursors;
    private int limit;
    private String href;
}
