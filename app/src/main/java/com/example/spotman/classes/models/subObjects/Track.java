package com.example.spotman.classes.models.subObjects;

import java.util.List;

public class Track
{

    public Track()
    {
    }

    private Album album;
    private List<Artist> artists;
    private List<String> available_markets;
    private int disc_number;
    private int duration_ms;
    private boolean episode;
    private boolean isExplicit;        //name wasn't compatible
    private ExternalIds external_ids;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private boolean is_local;        //name wasn't compatible
    private String name;
    private int popularity;
    private String preview_url;
    private boolean track;
    private int track_number;
    private String type;
    private String uri;


    public List<Artist> getArtists()
    {
        return artists;
    }

    public ExternalIds getExternal_ids()
    {
        return external_ids;
    }

    public ExternalUrls getExternal_urls()
    {
        return external_urls;
    }

    public String getHref()
    {
        return href;
    }

    public String getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public int getPopularity()
    {
        return popularity;
    }

    public boolean isTrack()
    {
        return track;
    }

    public int getTrack_number()
    {
        return track_number;
    }

    public String getType()
    {
        return type;
    }

    public String getUri()
    {
        return uri;
    }
}
