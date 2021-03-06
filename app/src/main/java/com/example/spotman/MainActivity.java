package com.example.spotman;

import android.os.Bundle;

import com.example.spotman.classes.misc.Global;
import com.example.spotman.classes.misc.MyLogger;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.spotman.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
{

    //binding
    private ActivityMainBinding binding;


    //===============================================
    //statics:

    //log:
    public static MyLogger log = new MyLogger();

    //global data:
    public static Global global = new Global();


    //===============================================




    //define requester in global
    //      (init after the onCreate() method has set up)



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        //=========

    //===========================================
    //setup:

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // passing each menu ID as a set of Ids

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_profiles, R.id.navigation_misc)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

    //end setup
    //===========================================


    //==================================================================
        //init requester:
            // (init in global after the setup stuff)
            // provide the requester with a context reference

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);


        global.initRequester(this);
        global.mainContext = this;
        global.appContext = getApplicationContext();

    //==================================================================

    }



}