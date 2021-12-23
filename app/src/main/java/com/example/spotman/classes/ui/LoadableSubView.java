package com.example.spotman.classes.ui;

import com.example.spotman.classes.models.Settable;

public interface LoadableSubView
{
    public void unloadSubView();
    public void loadSubView(Settable toLoad);

}
