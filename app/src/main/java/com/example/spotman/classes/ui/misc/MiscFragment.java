package com.example.spotman.classes.ui.misc;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.misc.http.AccessToken;
import com.example.spotman.classes.ui.splash.SplashDialog;
import com.example.spotman.databinding.MiscFragmentBinding;

public class MiscFragment extends Fragment
{

    private MiscViewModel mViewModel;

    private MiscFragment thisInstance = this;

    Global global;

    private MiscFragmentBinding binding;


    public static MiscFragment newInstance()
    {
        return new MiscFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        binding = MiscFragmentBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        //after init:
        global = MainActivity.global;
        //========


//=========
//LISTENERS:

binding.btnConnectToSpotify.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {
        SplashDialog splashDialog = new SplashDialog(thisInstance);
        splashDialog.show(getChildFragmentManager(), "splashFragment");

    }
});



binding.btnGetMe.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {


        MainActivity.global.getMe();
        

    }
});

binding.btnConnectWithCode.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {

        SharedPreferences prefs = getContext().getSharedPreferences("auth", Context.MODE_PRIVATE);
        String savedAccessToken = prefs.getString("accessToken", null);//If there is no YOURKEY found null will be the default value.

        MainActivity.global.accessToken = new AccessToken(savedAccessToken);

MainActivity.log.log("Retrieving saved token: " + savedAccessToken);

        MainActivity.global.getMe();

    }


});

binding.btnSelectTestProfile.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view)
    {
        MainActivity.global.getUserPlaylists("11132358058");
    }
});

//=========





        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MiscViewModel.class);

    }



}