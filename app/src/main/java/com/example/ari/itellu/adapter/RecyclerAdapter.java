package com.example.ari.itellu.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ari.itellu.DetailActivity;
import com.example.ari.itellu.R;
import com.example.ari.itellu.content.kontenUkm;

import java.util.List;
import java.util.Set;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    Context mContext;
    List<kontenUkm> mData;


    public RecyclerAdapter(Context mContext, List<kontenUkm> mData) {
        this.mContext = mContext;
        this.mData = mData;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_frag1, parent, false);
        MyViewHolder vHolder = new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        final String name=mData.get(position).getName();
        final int image=mData.get(position).getPhoto();
        final String deskrip = mData.get(position).getDeskripsi();

        holder.tv_name.setText(name);
        holder.img.setImageResource(image);
        holder.tv_desk.setText(deskrip);

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                openDetailActivity(name,image,deskrip);
                Toast.makeText(mContext,name,Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void openDetailActivity(String name,int image, String deskripsi)
    {
        Intent i=new Intent(mContext, DetailActivity.class);

        //PACK DATA TO SEND
        i.putExtra("NAME_KEY",name);
        i.putExtra("PHOTO_KEY",image);
        i.putExtra("DESK_KEY", deskripsi);

        //open activity
        mContext.startActivity(i);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView tv_name;
        private TextView tv_desk;
        private ImageView img;
        ItemClickListener itemClickListener;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView) itemView.findViewById(R.id.name_ukm);
            tv_desk = (TextView) itemView.findViewById(R.id.deskripsiukm);
            img = (ImageView) itemView.findViewById(R.id.img_ukm);

            //Set the OnClickListener to the whole view
            itemView.setOnClickListener(this);
        }
        public void setItemClickListener(ItemClickListener itemClickListener)
        {
            this.itemClickListener=itemClickListener;
        }
        @Override
        public void onClick(View v) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }
    }


}
