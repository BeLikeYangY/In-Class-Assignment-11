package com.example.android.inclassassignment11_yangy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Yang on 2017/4/18.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<Item> mDataset;
    private Context context;

    public MyAdapter(ArrayList<Item> myDataset,Context context) {
        mDataset = myDataset;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        ImageView item_photo;
        TextView item_title;
        TextView item_desc;
        Button share;
        Button readMore;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.card_view);
            item_photo= (ImageView) itemView.findViewById(R.id.item_photo);
            item_title= (TextView) itemView.findViewById(R.id.item_title);
            item_desc= (TextView) itemView.findViewById(R.id.item_desc);
            share= (Button) itemView.findViewById(R.id.btn_share);
            readMore= (Button) itemView.findViewById(R.id.btn_more);


        }

    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(context)
                .inflate(R.layout.list_item, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int j = position;

        holder.item_photo.setImageResource(mDataset.get(position).getPhotoId());
        holder.item_title.setText(mDataset.get(position).getTitle());
        holder.item_desc.setText(mDataset.get(position).getDesc());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ItemActivity.class);
                intent.putExtra("Item",mDataset.get(j));
                context.startActivity(intent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_SUBJECT, "Share");
                intent.putExtra(Intent.EXTRA_TEXT, mDataset.get(j).getDesc());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(Intent.createChooser(intent, mDataset.get(j).getTitle()));
            }
        });

        holder.readMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,ItemActivity.class);
                intent.putExtra("Item",mDataset.get(j));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


}
