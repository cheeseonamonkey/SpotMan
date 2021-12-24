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
import com.example.spotman.classes.adapters.RecycAdapter_RecentsTops;
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

        //all playlists adapter:
        RecyclerView recycAllPlaylists = binding.recycPlaylistsAll;

        //layout manager tells it how to behave as a list
        recycAllPlaylists.setLayoutManager(new LinearLayoutManager(getContext()));
        RecycAdapter_PlaylistsAll recycAllPlaylists_Adapter = new RecycAdapter_PlaylistsAll(MainActivity.global.selectedProfilePlaylistsList, getContext(), this);

        //set adapter
        recycAllPlaylists.setAdapter(recycAllPlaylists_Adapter);


        //
        //YOU ARE HERE
        /*

        Playlist view is working but buggy, you have to go out of the tab and back in for it to load, the adapter just needs to be notified of data changes

         */


        //playlist view tracks adapter:
        if(MainActivity.global.selectedPlaylistTracks.isLoaded())
        {
            RecyclerView recycViewPlaylist = binding.recycPlaylist;

            recycViewPlaylist.setLayoutManager(new LinearLayoutManager(getContext()));

            RecycAdapter_RecentsTops playlistViewTrackAdapter = new RecycAdapter_RecentsTops(MainActivity.global.selectedPlaylistTracks, getContext());

            //set adapter
            recycViewPlaylist.setAdapter(playlistViewTrackAdapter);
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PlaylistsViewModel.class);

    }

    public void goToPlaylist(String playlistId)
    {
        binding.tabHostPlaylist.setCurrentTabByTag("Playlist");

        MainActivity.global.getPlaylist(playlistId);


    }

    void setupTabs(TabHost tabHost)
    {

        tabHost.setup();

        TabHost.TabSpec PlaylistsTabSpec = tabHost.newTabSpec("All");
        PlaylistsTabSpec.setContent(R.id.tabAllPlaylists);
        PlaylistsTabSpec.setIndicator("All");

        tabHost.addTab(PlaylistsTabSpec);

        TabHost.TabSpec PlaylistNameTabSpec = tabHost.newTabSpec("Playlist");
        PlaylistNameTabSpec.setContent(R.id.tabPlaylistName);
        PlaylistNameTabSpec.setIndicator("Playlist");

        tabHost.addTab(PlaylistNameTabSpec);
    }

}