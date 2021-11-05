package com.example.spotman.classes.ui.me;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MeViewModel extends ViewModel
{

    private final MutableLiveData<String> mText;

    public MeViewModel()
    {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText()
    {
        return mText;
    }
}