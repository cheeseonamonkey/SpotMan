package com.example.spotman.classes.models.root;

import com.example.spotman.classes.models.SettableModel;
import com.example.spotman.classes.models.subObjects.Seed;
import com.example.spotman.classes.models.subObjects.Track;

import java.util.List;

import kotlin.NotImplementedError;

public class Recommendation  implements SettableModel
{
    public Recommendation()
    {
    }

    private List<Track> tracks;
    private List<Seed> seeds;

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
