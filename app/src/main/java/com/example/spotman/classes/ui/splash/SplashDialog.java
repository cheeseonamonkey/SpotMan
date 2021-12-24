package com.example.spotman.classes.ui.splash;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spotman.MainActivity;
import com.example.spotman.classes.ui.misc.MiscFragment;
import com.example.spotman.databinding.SplashFragmentBinding;

public class SplashDialog extends DialogFragment
{

    /*
    Manual auth flow:
    - user logs in on spotify with their credentials through the authorization url which contains our client code, the matching callback url, and the scopes to be requested from the user
    - spotify returns to us an access code string in the callback
    - access code is posted to API, with our obfuscated client and secret codes
    - spotify returns the access token object
    */


    private SplashViewModel mViewModel;
    private SplashFragmentBinding binding;

    private MiscFragment parentFrag;

    public SplashDialog(MiscFragment miscFragment)
    {
        super();
        parentFrag = miscFragment;

    }





    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding = SplashFragmentBinding.inflate(getLayoutInflater(), container,false);
        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//listeners:


        binding.btnSplashConnect.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                Context c = MainActivity.global.mainContext;

                //start auth activity
                Intent authIntent = new Intent(c, AuthActivity.class);
                c.startActivity(authIntent);



            }
        });

        binding.btnSplashDialogForget.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivity.global.accessToken.resetAccessToken(getContext());
            }
        });


        //return binding view
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(SplashViewModel.class);
    }

    @Override
    public void onDestroyView()
    {


        super.onDestroyView();
        MainActivity.log.log("Destroying splash dialog...");
        MainActivity.global.getMe();
    }
}