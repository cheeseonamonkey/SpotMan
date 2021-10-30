package com.example.spotman.classes.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.spotman.MainActivity;
import com.example.spotman.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment
{

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



binding.btntst.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {

        String str = "";

        //MainActivity.requester.Get("fact");

        //MainActivity.log.log( MainActivity.requester.GetAsync("fact") );

    }
});

binding.btnOut.setOnClickListener(new View.OnClickListener()
{
    @Override
    public void onClick(View view)
    {
        MainActivity.log.log( "" );
    }
});




        return root;
    }

    @Override
    public void onDestroyView()
    {
        super.onDestroyView();
        binding = null;
    }
}