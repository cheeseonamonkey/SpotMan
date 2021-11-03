package com.example.spotman.classes.models.root;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.subObjects.ExternalUrls;
import com.example.spotman.classes.models.subObjects.Followers;
import com.example.spotman.classes.models.subObjects.Image;
import com.google.gson.Gson;

import java.util.List;

public class Profile implements Settable
{
    public Profile()
    {
    }

    private String display_name;
    private ExternalUrls external_urls;
    private Followers followers;
    private String href;
    private String id;
    private List<Image> images;
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
                ", images=" + images +
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
    }
}