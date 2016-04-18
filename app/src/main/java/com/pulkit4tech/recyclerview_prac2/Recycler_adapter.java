package com.pulkit4tech.recyclerview_prac2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

//extending our custom adapter with Recyclerview.adapter<OurHolder>
public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyHolder> {

    private LayoutInflater inflater;
    List<data_item> data = Collections.emptyList();
    private Context context;
    //constructor
    public Recycler_adapter(Context context,List<data_item> data){

        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    //This method is like oncreate method for our recyclerview adapter
    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating view using inflater with custom_cardLayout

        View viewholder = inflater.inflate(R.layout.custom_cardlayout_row, parent, false);
        //instantiating myholder and passing viewhlder(to bind our layout) to contructor(which will also pass it to its super class)
        MyHolder myHolder = new MyHolder(viewholder);

        return myHolder;
    }


    //this method is frequently called during scrolling by recycler view
    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        //binding our data to holder
        data_item current = data.get(position);
        holder.title.setText(current.title);
        holder.img.setImageResource(current.imageid);
        //we want card should be deleted if user taps on title of card
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //note here we are sending holder.getPosition() rather than position .. This is important as our
                //holder will be updated and if we pass position you will observe strange behaviour but will understand what
                //is happening.Try EXPERIMENTING!!
                delete(holder.getPosition());
                Toast.makeText(context, "Deleted position : " + holder.getPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //deleting from card

    private void delete(int position) {
        //clearing from our List
        data.remove(position);
        //notifying adapter that a item is removed.Visit developer page for information regarding this and other loads of method.
        notifyItemRemoved(position);

    }

    //return item in data list
    @Override
    public int getItemCount() {
        return data.size();
    }

    //our holder class extending RecyclerView.ViewHolder
    class MyHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;

        //constructor
        public MyHolder(View itemView) {
            //passing itemView to super class constructor
            super(itemView);
            //Binding our layout view
            title = (TextView) itemView.findViewById(R.id.list_text);
            img = (ImageView) itemView.findViewById(R.id.list_icon);

        }
    }

}
