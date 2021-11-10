package com.example.spotman.classes.ui.profiles.profileSubView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotman.R;
import com.example.spotman.classes.models.SettableModel;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.classes.models.root.TopTracks;
import com.example.spotman.classes.models.subObjects.Item;

import java.util.List;

public class RecycAdapter_RecentsTops extends RecyclerView.Adapter<RecycAdapter_RecentsTops.TrackSimpleViewHolder>
{
    //reference fields
  //  RecentlyPlayed recentlyPlayed;
    List<Item> itemList;
    Context context;


    //onCreateViewHolder() – inflates the layout_product_card.xml layout
    //onBindViewHolder() – the data (product image, product name etc) is retrieved from the object and is set to each item/row in the list.
            // We’ll also override imageView onClick method to display a toast saying which item is selected.
    //getItemCount() – returns the numbers of items/rows in the list.

    public RecycAdapter_RecentsTops(SettableModel rootModelWithTrackList, Context context)
    {
        if(rootModelWithTrackList instanceof RecentlyPlayed)
        {
            RecentlyPlayed rplay = (RecentlyPlayed) rootModelWithTrackList;

            itemList = rplay.getItems();

        }else if (rootModelWithTrackList instanceof TopTracks)
        {
            TopTracks topt = (TopTracks) rootModelWithTrackList;

            itemList = topt.getItems();

        }


        this.context = context;

    }


    @NonNull
    @Override
    public TrackSimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_card_simple, parent, false);

        //turns it to the ViewHolder class we defined at the bottom
        TrackSimpleViewHolder viewHolder = new TrackSimpleViewHolder(listItemView);

        return viewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull TrackSimpleViewHolder holder, int position)
    {
        //this uses the same ViewHolder class that we made below, and so has all the fields of the card

        //set image too:
        //holder.imageProductImage;
        holder.txtArtist.setText(itemList.get(position).getTrack().getArtists().get(0).getName());
        holder.txtTrack.setText(itemList.get(position).getTrack().getName());

        //might need to make this not anonymous later?
        holder.ckbHeart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                //checked
                if(b)
                {
                    compoundButton.setBackgroundResource(R.drawable.hearticonchecked);

                    //todo: api post

                }else if

                //not checked
                (! b)
                {
                    compoundButton.setBackgroundResource(R.drawable.hearticon);

                    //todo: api post
                }


            }
        });
    }







    @Override
    public int getItemCount()
    {
        if(itemList == null)
            return 0;
        else
            return itemList.size();
    }


    //view holder for cards
    public class TrackSimpleViewHolder extends RecyclerView.ViewHolder
    {

        //ui in the view
        ImageView imageProductImage;
        TextView txtTrack;
        TextView txtArtist;
        CheckBox ckbHeart;


        //init
        public TrackSimpleViewHolder(View view)
        {
            //takes the container and gets to know all of the child views

            super(view);
            imageProductImage= view.findViewById(R.id.imgProfilePic);
            txtTrack = view.findViewById(R.id.txtTrackSimpleTitle);
            txtArtist = view.findViewById(R.id.txtTrackSimpleArtist);
            ckbHeart = view.findViewById(R.id.ckbHeartTrack);
        }
    }

}
