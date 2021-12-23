package com.example.spotman.classes.ui;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotman.R;

public class AudioFeaturesSlidersFragment extends Fragment {

    private AudioFeaturesSlidersViewModel mViewModel;

    public static AudioFeaturesSlidersFragment newInstance() {
        return new AudioFeaturesSlidersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.audio_features_sliders_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AudioFeaturesSlidersViewModel.class);
        // TODO: Use the ViewModel
    }

}