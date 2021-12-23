package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.Settable;

import kotlin.NotImplementedError;

public class TrackFeatures  implements Settable
{

    public TrackFeatures()
    {
    }

    private double danceability;
    private double energy;
    private int key;
    private double loudness;
    private int mode;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double liveness;
    private double valence;
    private double tempo;
    private String type;
    private String id;
    private String uri;
    private String track_href;
    private String analysis_url;
    private int duration_ms;
    private int time_signature;

    @Override
    public void setLoaded(boolean isLoaded)
    {

    }

    @Override
    public void setFromJson(String json)
    {
        throw new NotImplementedError();
    }
}
