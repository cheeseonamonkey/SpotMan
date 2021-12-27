package com.example.spotman.classes.ui.playlists;

import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotman.R;

public class PlaylistStatsDialogFragment extends DialogFragment {

    private PlaylistStatsDialogViewModel mViewModel;

    public static PlaylistStatsDialogFragment newInstance() {
        return new PlaylistStatsDialogFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.playlist_stats_dialog_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlaylistStatsDialogViewModel.class);
        // TODO: Use the ViewModel
    }

}