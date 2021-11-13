package com.example.spotman.classes.models.subObjects;

import java.util.List;

public class Track
{

    public Track()
    {
    }

    boolean isHearted;

    private Album album;
    private List<Artist> artists;
    private List<String> available_markets;
    private int disc_number;
    private int duration_ms;
    private boolean episode;
    private boolean isExplicit;        //name wasn't compatible!
    private ExternalIds external_ids;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private boolean is_local;        //name wasn't compatible!
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


    public boolean isHearted()
    {
        return isHearted;
    }

    public void setHearted(boolean hearted)
    {
        isHearted = hearted;
    }

    @Override
    public String toString()
    {
        return "Track{" +
                "isHearted=" + isHearted +
                ", album=" + album +
                ", artists=" + artists +
                ", available_markets=" + available_markets +
                ", disc_number=" + disc_number +
                ", duration_ms=" + duration_ms +
                ", episode=" + episode +
                ", isExplicit=" + isExplicit +
                ", external_ids=" + external_ids +
                ", external_urls=" + external_urls +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", is_local=" + is_local +
                ", name='" + name + '\'' +
                ", popularity=" + popularity +
                ", preview_url='" + preview_url + '\'' +
                ", track=" + track +
                ", track_number=" + track_number +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }
}
