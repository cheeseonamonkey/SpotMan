package com.example.spotman.classes.models;

public interface SettableModel
{
    public void setLoaded(boolean isLoaded);

    public void setFromJson(String json);
    public String toString();
}
