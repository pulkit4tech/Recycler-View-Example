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

/**
 * Created by PULKIT on 2/11/2016.
 */
public class Recycler_adapter extends RecyclerView.Adapter<Recycler_adapter.MyHolder> {

    private LayoutInflater inflater;
    List<data_item> data = Collections.emptyList();
    private Context context;
    public Recycler_adapter(Context context,List<data_item> data){
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewholder = inflater.inflate(R.layout.custom_cardlayout_row, parent, false);
        MyHolder myHolder = new MyHolder(viewholder);

        return myHolder;
    }

    @Override
    public void onBindViewHolder(final MyHolder holder, int position) {

        data_item current = data.get(position);
        holder.title.setText(current.title);
        holder.img.setImageResource(current.imageid);
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete(holder.getPosition());
                Toast.makeText(context, "Deleted position : " + holder.getPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void delete(int position) {

        data.remove(position);

        notifyItemRemoved(position);


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView img;

        public MyHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.list_text);
            img = (ImageView) itemView.findViewById(R.id.list_icon);

        }
    }

}
