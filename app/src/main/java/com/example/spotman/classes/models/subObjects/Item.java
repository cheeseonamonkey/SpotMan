package com.example.spotman.classes.models.subObjects;

import java.util.List;

public class Item
{
    public Item()
    {
    }


//could abstract this

    //playlist items
    private boolean collaborative;
    private String description;
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private List<Image> images;
    private String name;
    private Owner owner;
    private Object primary_color;
    private boolean isPrivate;        //name wasn't compatible
    private String snapshot_id;
    private Tracks tracks;
    private String type;
    private String uri;

    //track items

    //todo: still using this datetime class from C#
  //  private DateTime added_at;
    private AddedBy added_by;
    private boolean is_local;
    private Track track;
    private VideoThumbnail video_thumbnail;

    //recently played items


 //   private DateTime played_at;
    private SpotifyContext context;     //todo: wacky DateTime class here also


}
