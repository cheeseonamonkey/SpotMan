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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.models.root.Profile;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.classes.ui.LoadableSubView;
import com.example.spotman.databinding.ProfileSubViewFragmentBinding;

import org.w3c.dom.Text;

public class ProfileSubViewFragment extends Fragment implements LoadableSubView
{

    private ProfileSubViewViewModel mViewModel;
    private ProfileSubViewFragmentBinding binding;

    Global global;

    ImageView imgProfilePic;
    TextView txtProfileName;



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

//==========
//recyclers:

        RecyclerView recycRecents = binding.recycRecent;
        //layout manager tells it how to behave as a list
        recycRecents.setLayoutManager(new LinearLayoutManager(getContext()));

        //fill in the constructor
        RecycRecentAdapter recycRecentAdapter = new RecycRecentAdapter(global.myRecentlyPlayed, getContext());

        //set adapter
        recycRecents.setAdapter(recycRecentAdapter);




//=========

        //=======================================================================
        //LISTENERS:



        //=========












        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ProfileSubViewViewModel.class);
        // TODO: Use the ViewModel
    }







    //=======================================================================
    //subview
    @Override
    public void unload()
    {

    }

    //subview
    @Override
    public void load(Object toLoad)
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

        }


    }
}