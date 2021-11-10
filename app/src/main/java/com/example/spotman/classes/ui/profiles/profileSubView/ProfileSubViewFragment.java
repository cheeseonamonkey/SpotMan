package com.example.spotman.classes.ui.profiles.profileSubView;

import androidx.lifecycle.ViewModelProvider;

import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.models.SettableModel;
import com.example.spotman.classes.models.root.Profile;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.classes.models.root.TopTracks;
import com.example.spotman.classes.ui.LoadableSubView;
import com.example.spotman.databinding.ProfileSubViewFragmentBinding;

public class ProfileSubViewFragment extends Fragment implements LoadableSubView
{

    private ProfileSubViewViewModel mViewModel;
    private ProfileSubViewFragmentBinding binding;

    Global global;

    ImageView imgProfilePic;
    TextView txtProfileName;

//recyclers (just inits for scope, data done in interface methods to prevent null errors)

    RecycAdapter_RecentsTops recycAdapterRecents;
    RecycAdapter_RecentsTops recycAdapterTops;

//=========


    //child views:

            //===========

    public static ProfileSubViewFragment newInstance()
    {
        return new ProfileSubViewFragment();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = ProfileSubViewFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

//init:

        global = MainActivity.global;
        Profile me = global.myProfile;

        imgProfilePic = binding.imgProfilePic;
        txtProfileName = binding.txtProfileName;


        //=======================================================================
        //track card simple stuff



        //=======================================================================
//==========


        //=======================================================================
        //LISTENERS:

        //recents expand button

        binding.ckbRecentsExpand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                //checked
                if (b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretdownicon);

                    binding.frmRecycRecentHolder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));

                //unchecked
                }else if(! b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretupicon);

                    binding.frmRecycRecentHolder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0f));


                }
            }
        });



        //tops expand button

        binding.ckbTopsExpand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                //checked
                if (b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretdownicon);

                    binding.frmRecycTopsHolder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));

                    //unchecked
                }else if(! b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretupicon);

                    binding.frmRecycTopsHolder.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 0f));


                }

            }
        });

        //END OF LISTENERS
        //=========









        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileSubViewViewModel.class);

    }







    //=======================================================================
    //subview
    @Override
    public void unloadSubView()
    {

    }

    //subview
    @Override
    public void loadSubView(SettableModel toLoad)
    {

        if(toLoad instanceof Profile)
        {
            Profile profile = (Profile) toLoad;

            // MainActivity.log.log("Profile loading: " + toLoad.toString());


            //write to UI:
            imgProfilePic.setImageURI(Uri.parse(profile.getImages()[0].getUrl()));
            txtProfileName.setText(profile.getDisplay_name());


        }else if(toLoad instanceof RecentlyPlayed)
        {
            RecentlyPlayed recents = (RecentlyPlayed) toLoad;

            RecyclerView recycRecents = binding.recycRecent;
            //layout manager tells it how to behave as a list
            recycRecents.setLayoutManager(new LinearLayoutManager(getContext()));

            //fill in the constructor
            recycAdapterRecents = new RecycAdapter_RecentsTops(recents, getContext());

            //set adapter
            recycRecents.setAdapter(recycAdapterRecents);


        }else if(toLoad instanceof TopTracks)
        {
            TopTracks tops = (TopTracks) toLoad;

            RecyclerView recycTops = binding.recycTop;
            //layout manager tells it how to behave as a list
            recycTops.setLayoutManager(new LinearLayoutManager(getContext()));

            //fill in the constructor
            recycAdapterTops = new RecycAdapter_RecentsTops(tops, getContext());

            //set adapter
            recycTops.setAdapter(recycAdapterTops);
        }


    }
}