package com.example.spotman.classes.ui.me;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.ui.profiles.profileSubView.ProfileSubViewFragment;
import com.example.spotman.databinding.FragmentMeBinding;

import java.util.List;

public class MeFragment extends Fragment
{
    //binding vars:
    private MeViewModel meViewModel;
    private FragmentMeBinding binding;


    Global global;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {

//binding:
        meViewModel =
                new ViewModelProvider(this).get(MeViewModel.class);

        binding = FragmentMeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//=======================================================================



//===================
        //init:

        global = MainActivity.global;




        //MainActivity.log.log(global.toString());
        //MainActivity.log.log(global.myProfile.toString());
        //MainActivity.log.log(global.myRecentlyPlayed.toString());

        //=======================================================================
        //to load instead of using the stupid button:

        /*
        if(global != null
                && global.myProfile != null
                && global.myRecentlyPlayed != null
            &&
                global.authenticated
                && global.myProfile.isLoaded
                && global.myRecentlyPlayed.isLoaded)
        {
            MainActivity.log.log("Loading Me tab", "tab");
            LoadTab();
        }else
            MainActivity.log.log("NOT loading Me tab", "tab");

        global = MainActivity.global;
*/



//=======================================================================
        //LISTENERS:

        binding.btnLoadMe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                LoadTab();
            }
        });


//end of listeners
//=======================================================================








        // return binding
        return root;
    }



    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }


    public void LoadTab()
    {
        //
        //done here to stay synchronous:
        global.myRecentlyPlayed.setHeartedList();
        global.myTopTracks.setHeartedList();
        //

        FragmentContainerView fragHolder = binding.fragHolderMeProfileSubView;

        List<Fragment> fgs = getChildFragmentManager().getFragments();

        ProfileSubViewFragment profileSubViewFrag = (ProfileSubViewFragment)  fgs.get(0);



        profileSubViewFrag.loadSubView(global.myProfile);
        profileSubViewFrag.loadSubView(global.myRecentlyPlayed);
        profileSubViewFrag.loadSubView(global.myTopTracks);
        profileSubViewFrag.loadSubView(global.myPlaylistsList);







    }
}