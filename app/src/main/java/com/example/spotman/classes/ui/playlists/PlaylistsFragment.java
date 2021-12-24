package com.example.spotman.classes.ui.playlists;

import androidx.lifecycle.ViewModelProvider;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.example.spotman.classes.adapters.RecycAdapter_PlaylistsAll;
import com.example.spotman.classes.models.root.PlaylistList;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.databinding.PlaylistsFragmentBinding;

public class PlaylistsFragment extends Fragment
{

    private PlaylistsViewModel mViewModel;
    private PlaylistsFragmentBinding binding;

    public static PlaylistsFragment newInstance()
    {
        return new PlaylistsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = PlaylistsFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++



        //init:
        setupTabs(binding.tabHostPlaylist);
        setupAdapters();






//=========
//LISTENERS:


//=========



        return view;


    }

    public void setupAdapters()
    {

        RecyclerView recycAllPlaylists = binding.recycPlaylistsAll;

//layout manager tells it how to behave as a list
        recycAllPlaylists.setLayoutManager(new LinearLayoutManager(getContext()));

//fill in the constructor
        RecycAdapter_PlaylistsAll recycAllPlaylists_Adapter = new RecycAdapter_PlaylistsAll(MainActivity.global.myPlaylistsList, getContext());


//set adapter
        recycAllPlaylists.setAdapter(recycAllPlaylists_Adapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlaylistsViewModel.class);

    }

    private void setupTabs(TabHost tabHost)
    {

        tabHost.setup();

        TabHost.TabSpec PlaylistsTabSpec = tabHost.newTabSpec("Playlists");
        PlaylistsTabSpec.setContent(R.id.tabAllPlaylists);
        PlaylistsTabSpec.setIndicator("Playlists");

        tabHost.addTab(PlaylistsTabSpec);

        TabHost.TabSpec PlaylistNameTabSpec = tabHost.newTabSpec("View");
        PlaylistNameTabSpec.setContent(R.id.tabPlaylistName);
        PlaylistNameTabSpec.setIndicator("View");

        tabHost.addTab(PlaylistNameTabSpec);


    }

}