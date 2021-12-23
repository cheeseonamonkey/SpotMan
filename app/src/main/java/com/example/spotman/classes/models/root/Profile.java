package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.ExternalUrls;
import com.example.spotman.classes.models.subObjects.Followers;
import com.example.spotman.classes.models.subObjects.Image;
import com.google.gson.Gson;

public class Profile implements Settable
{
    public Profile()
    {

    }

    public boolean isLoaded = false;

    private String display_name;
    private ExternalUrls external_urls;
    private Followers followers;
    private String href;
    private String id;
    private Image[] images;
    private String type;
    private String uri;

    @Override
    public String toString()
    {
        return "Profile{" +
                "display_name='" + display_name + '\'' +
                ", external_urls=" + external_urls +
                ", followers=" + followers +
                ", href='" + href + '\'' +
                ", id='" + id + '\'' +
                ", images=" + images[0].toString() +
                ", type='" + type + '\'' +
                ", uri='" + uri + '\'' +
                '}';
    }

    public static Profile newFromJson(String strJson)
    {
        Gson gson = MainActivity.global.gson;
        return gson.fromJson(strJson, Profile.class);
    }


    @Override
    public void setLoaded(boolean isLoaded)
    {

    }

    @Override
    public void setFromJson(String json)
    {
        Profile p = newFromJson(json);

        this.display_name = p.display_name;
        this.external_urls = p.external_urls;
        this.followers = p.followers;
        this.href = p.href;
        this.id = p.id;
        this.images = p.images;
        this.type = p.type;
        this.uri = p.uri;

        isLoaded = true;

        MainActivity.log.log("MyProfile set", "model");
    }

    public String getDisplay_name()
    {
        return display_name;
    }

    public ExternalUrls getExternal_urls()
    {
        return external_urls;
    }

    public Followers getFollowers()
    {
        return followers;
    }

    public String getHref()
    {
        return href;
    }

    public String getId()
    {
        return id;
    }

    public Image[] getImages()
    {
        return images;
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