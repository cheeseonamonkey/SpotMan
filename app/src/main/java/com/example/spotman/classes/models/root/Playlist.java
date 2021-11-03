package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.ExternalUrls;
import com.example.spotman.classes.models.subObjects.Followers;
import com.example.spotman.classes.models.subObjects.Image;
import com.example.spotman.classes.models.subObjects.Owner;
import com.example.spotman.classes.models.subObjects.Tracks;

import java.util.List;

public class Playlist implements Settable
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

    @Override
    public void setFromJson(String json)
    {
        Playlist p = MainActivity.global.gson.fromJson(json, Playlist.class);

        this.collaborative = p.collaborative;
        this.description = p.description;
        this.external_urls = p.external_urls;
        this.followers = p.followers;
        this.href = p.href;
        this.id = p.id;
        this.images = p.images;
        this.name = p.name;
        this.owner = p.owner;
        this.primary_color = p.primary_color;
        this.isPrivate = p.isPrivate;
        this.snapshot_id = p.snapshot_id;
        this.tracks = p.tracks;
        this.type = p.type;
        this.uri = p.uri;
    }
}
