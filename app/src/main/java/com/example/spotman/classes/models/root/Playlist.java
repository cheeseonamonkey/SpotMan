package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.subObjects.ExternalUrls;
import com.example.spotman.classes.models.subObjects.Followers;
import com.example.spotman.classes.models.subObjects.Image;
import com.example.spotman.classes.models.subObjects.Owner;
import com.example.spotman.classes.models.subObjects.Tracks;

import java.util.List;

public class Playlist
{
    public Playlist()
    {
    }

    private boolean collaborative;
    private String description;
    private ExternalUrls external_urls;
    private Followers followers;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Owner owner;
    private Object primary_color;
    private boolean isPrivate;
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;
}
