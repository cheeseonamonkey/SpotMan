package com.example.spotman.classes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotman.R;
import com.example.spotman.classes.models.root.PlaylistList;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class RecycAdapter_PlaylistsAll extends RecyclerView.Adapter<RecycAdapter_PlaylistsAll.ViewHolder>
{

    List<Item> itemList;
    Context context;

    public RecycAdapter_PlaylistsAll(PlaylistList playlistList, Context context)
    {
        this.context = context;

        this.itemList = playlistList.getItems();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View singleView = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_card_simple, parent, false);

        //turns it to the ViewHolder class we defined at the bottom
        RecycAdapter_PlaylistsAll.ViewHolder viewHolder = new RecycAdapter_PlaylistsAll.ViewHolder(singleView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        //this gets the ViewHolder class that we made below, and has all the fields of the card
        int pos = holder.getAdapterPosition();
        Item currentItem = itemList.get(pos);

        //holder.imgPlaylistCover
        holder.txtPlaylistName.setText(String.valueOf(currentItem.getName()));
        holder.txtPlaylistNumTracks.setText(String.valueOf(currentItem.getTracks().getCount()));

    }

    @Override
    public int getItemCount()
    {
        if(itemList == null)
            return 0;
        else
            return itemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder
    {

        ImageView imgPlaylistCover;
        TextView txtPlaylistName;
        TextView txtPlaylistNumTracks;
        Spinner spnPlaylistCardActions;


        public ViewHolder(View view)
        {
            super(view);

            imgPlaylistCover = view.findViewById(R.id.imgPlaylistCover);
            txtPlaylistName = view.findViewById(R.id.txtPlaylistName);
            txtPlaylistNumTracks = view.findViewById(R.id.txtPlaylistNumTracks);
            spnPlaylistCardActions = view.findViewById(R.id.spnPlaylistCardActions);



        }
    }

}
