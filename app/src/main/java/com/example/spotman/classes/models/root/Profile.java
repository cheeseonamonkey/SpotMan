package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.subObjects.ExternalUrls;
import com.example.spotman.classes.models.subObjects.Followers;
import com.example.spotman.classes.models.subObjects.Image;

import java.util.List;

public class Profile
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
}