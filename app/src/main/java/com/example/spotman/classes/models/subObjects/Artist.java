package com.example.spotman.classes.models.subObjects;

public class Artist
{
    private ExternalUrls external_urls;
    private String href;
    private String id;
    private String name;
    private String type;
    private String uri;

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

    public String getUri()
    {
        return uri;
    }
}