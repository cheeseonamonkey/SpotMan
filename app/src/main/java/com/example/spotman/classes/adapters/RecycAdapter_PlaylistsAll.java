package com.example.spotman.classes.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotman.R;
import com.example.spotman.classes.models.root.PlaylistList;
import com.example.spotman.classes.models.subObjects.Item;
import com.example.spotman.classes.ui.playlists.PlaylistsFragment;

import java.util.List;

public class RecycAdapter_PlaylistsAll extends RecyclerView.Adapter<RecycAdapter_PlaylistsAll.ViewHolder>
{

    List<Item> itemList;
    Context context;

    //for in the viewHolder
    PlaylistsFragment parentFrag;

    public RecycAdapter_PlaylistsAll(PlaylistList playlistList, Context context, PlaylistsFragment parentFrag)
    {
        this.context = context;

        this.itemList = playlistList.getItems();

        this.parentFrag = parentFrag;
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

        holder.pos = pos;

        //holder.imgPlaylistCover
        holder.txtPlaylistName.setText(String.valueOf(currentItem.getName()));
        holder.txtPlaylistNumTracks.setText(new String(String.valueOf(currentItem.getTracks().getCount()) + " tracks"));

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
        //adapter position, set in onBind
        int pos;

        ImageView imgPlaylistCover;
        TextView txtPlaylistName;
        TextView txtPlaylistNumTracks;
        Spinner spnPlaylistCardActions;

        ImageButton imgBtnGoToPlaylist;




        public ViewHolder(View view)
        {
            super(view);



            imgPlaylistCover = view.findViewById(R.id.imgPlaylistCover);
            txtPlaylistName = view.findViewById(R.id.txtPlaylistName);
            txtPlaylistNumTracks = view.findViewById(R.id.txtPlaylistNumTracks);
            spnPlaylistCardActions = view.findViewById(R.id.spnPlaylistCardActions);

            imgBtnGoToPlaylist = view.findViewById(R.id.imgBtnPlaylistView);

            imgBtnGoToPlaylist.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    String playlistId = itemList.get(pos).getId();

                    parentFrag.goToPlaylist(playlistId);




                }
            });


        }


        public int getPos() {
            return pos;
        }
        public void setPos(int pos) {
            this.pos = pos;
        }
    }

}
