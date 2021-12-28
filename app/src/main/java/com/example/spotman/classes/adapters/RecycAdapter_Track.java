package com.example.spotman.classes.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.spotman.MainActivity;
import com.example.spotman.R;
import com.example.spotman.classes.models.Settable;
import com.example.spotman.classes.models.root.PlaylistTracks;
import com.example.spotman.classes.models.root.RecentlyPlayed;
import com.example.spotman.classes.models.root.TopTracks;
import com.example.spotman.classes.models.subObjects.Track;

import java.util.ArrayList;
import java.util.List;

public class RecycAdapter_Track extends RecyclerView.Adapter<RecycAdapter_Track.TrackSimpleViewHolder>
{
    //reference fields
  //  RecentlyPlayed recentlyPlayed;
    List<Track> itemList;
    Context context;

    List<Integer> selectedThings;


    //onCreateViewHolder() – inflates the layout_product_card.xml layout
    //onBindViewHolder() – the data (product image, product name etc) is retrieved from the object and is set to each item/row in the list.
            // We’ll also override imageView onClick method to display a toast saying which item is selected.
    //getItemCount() – returns the numbers of items/rows in the list.

    public RecycAdapter_Track(Settable rootModelWithTrackList, Context context)
    {

        selectedThings = new ArrayList<>();

        if(rootModelWithTrackList instanceof RecentlyPlayed)
        {
            RecentlyPlayed rplay = (RecentlyPlayed) rootModelWithTrackList;


            itemList = rplay.getTracklist();

        }else if (rootModelWithTrackList instanceof TopTracks)
        {
            TopTracks topt = (TopTracks) rootModelWithTrackList;

            itemList = topt.getTracklist();

        }else if(rootModelWithTrackList instanceof PlaylistTracks)
        {
            PlaylistTracks pt = (PlaylistTracks) rootModelWithTrackList;

            itemList = pt.getTrackList();

        }


        this.context = context;

    }


    @NonNull
    @Override
    public TrackSimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
       // MainActivity.log.log("\t -- created ");



        //inflates layout on a new view
        View listItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_card_simple, parent, false);

        //turns it to the ViewHolder class we defined at the bottom
        TrackSimpleViewHolder viewHolder = new TrackSimpleViewHolder(listItemView);



        return viewHolder;

    }



    @Override
    public void onBindViewHolder(@NonNull TrackSimpleViewHolder holder, int position)
    {

        //MainActivity.log.log("\t -- binded " + itemList.get(position).getName());



        //this gets the ViewHolder class that we made below, and has all the fields of the card

        int pos = holder.getAdapterPosition();



        //set image too:
        //holder.imageProductImage;
        holder.txtArtist.setText(itemList.get(pos).getArtists().get(0).getName());
        holder.txtTrack.setText(itemList.get(pos).getName());

        //=======================================================================
        //because that took forever to figure out:
        //YOU MUST SET EVERY SINGLE VIEWHOLDER VIEWS HERE OR THE DATA WILL BE RECYCLED A FEW VIEWHOLDERS DOWN:
            //when the holder is re-used further down the list, any attributes left unset will remain the same!
            //thats why the artist and track name were fine but the unimplemented heart checkbox was not
                //holder.ckbHeart.setChecked(false);

        if(itemList.get(pos).isHearted())
        {
            holder.ckbHeart.setChecked(true);
            holder.ckbHeart.setBackgroundResource(R.drawable.hearticonchecked);
        }
        else
        {
            holder.ckbHeart.setChecked(false);
            holder.ckbHeart.setBackgroundResource(R.drawable.hearticon);
        }

        //holder.ckbHeart.setChecked(itemList.get(pos).isHearted());



        //ckb heart
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
        //fields for adapter
        boolean selected;   //will this stay when the recycler is loading/unloading the views? or should it be stored in this adapter class?

        //ui in the view
        ImageView imageProductImage;
        TextView txtTrack;
        TextView txtArtist;
        CheckBox ckbHeart;
        CardView crdTrackSimple;
        ImageButton btnOptions;

        //init
        public TrackSimpleViewHolder(View view)
        {
            //takes the container and gets to know all of the child views
            super(view);
            imageProductImage= view.findViewById(R.id.imgProfilePic);
            txtTrack = view.findViewById(R.id.txtTrackSimpleTitle);
            txtArtist = view.findViewById(R.id.txtTrackSimpleArtist);
            ckbHeart = view.findViewById(R.id.ckbHeartTrack);
            crdTrackSimple = view.findViewById(R.id.crdTrackSimple);
            btnOptions = view.findViewById(R.id.btnTrackCardOptions);



            btnOptions.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    PopupMenu menu = new PopupMenu(context, view);
                    menu.getMenuInflater().inflate(R.menu.track_menu_options, menu.getMenu());
                    menu.show();
                }
            });



            view.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View view)
                {
                    MainActivity.log.log("long clicked " + getAdapterPosition());

                    selected = true;
                    selectedThings.add(getAdapterPosition());

                    view.setBackgroundColor(Color.BLACK);

                    MainActivity.log.log(itemList.get(getAdapterPosition()).toString() );

                    return false;
                }
            });

        }
    }

}
