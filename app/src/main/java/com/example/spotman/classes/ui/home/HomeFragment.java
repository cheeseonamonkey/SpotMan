package com.example.spotman.classes.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.models.root.Profile;
import com.example.spotman.classes.ui.splash.SplashDialog;
import com.example.spotman.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment
{
    //binding vars:
    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;


    Global global;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {

//binding:
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
//=======================================================================

        //after init stuff:


        global = MainActivity.global;
        //


//=======================================================================
        //LISTENERS:

        //btnConnect
        binding.btnConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                String str = "";

                new SplashDialog().show(getChildFragmentManager(), "splashFragment");



            }
        });



        binding.btnOut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                global.requester.GetAndSetAsync("me", global.myProfile);




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
}