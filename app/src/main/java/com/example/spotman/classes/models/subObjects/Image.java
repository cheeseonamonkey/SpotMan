package com.example.spotman.classes.models.subObjects;

public class Image
{

    public Image()
    {
    }

    private Object height;
    private String url;
    private Object width;

    @Override
    public String toString()
    {
        return "Image{" +
                "height=" + height +
                ", url='" + url + '\'' +
                ", width=" + width +
                '}';
    }

    public String getUrl()
    {
        return url;
    }
}
