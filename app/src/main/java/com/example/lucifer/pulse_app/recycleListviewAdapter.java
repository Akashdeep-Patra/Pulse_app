package com.example.lucifer.pulse_app;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycleListviewAdapter extends RecyclerView.Adapter<recycleListviewAdapter.ViewHolder> {


    ArrayList<OBJECT_MODEL> list;
    Context context;
    String url = "https://s3.ap-south-1.amazonaws.com/pulse-flp/assets/img/";
    private  int lastpos=-1;

    public recycleListviewAdapter(ArrayList<OBJECT_MODEL> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.data_adapter_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OBJECT_MODEL object_model = list.get(position);
        holder.id.setText("ID = "+object_model.getPid());
        holder.category.setText("CATEGORY = "+object_model.getCategory());
        holder.name.setText("NAME = "+object_model.getPname());
        holder.mrp.setText("PRICE = "+object_model.getMrp());
        Picasso.get().load(url + object_model.getPimage()).placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp).into(holder.img);
        setAnimation(holder.itemView,position);
    }
    private  void  setAnimation(View view, int i)
    {
        if (i>lastpos)
        {
            Animation animation= AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
            view.startAnimation(animation);
//            lastpos=i;
        }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView img;
        TextView id, name, category, mrp;

        public ViewHolder(@NonNull View view) {
            super(view);
            img = view.findViewById(R.id.image);
            id = view.findViewById(R.id.id);
            name = view.findViewById(R.id.name);
            category = view.findViewById(R.id.category);
            mrp = view.findViewById(R.id.mrp);
            img.setOnClickListener(this);
            name.setOnClickListener(this);
            id.setOnClickListener(this);
            category.setOnClickListener(this);
            mrp.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            OBJECT_MODEL obj = list.get(getAdapterPosition());
            switch (view.getId()) {
                case R.id.image: {
                    Context c = view.getContext();
                    Intent i = new Intent(context, Image.class);
                    i.putExtra("image", url + obj.getPimage());
                    c.startActivity(i);
                    break;
                }
                case R.id.id: {
                    Context c = view.getContext();
                    Intent i = new Intent(context, Details.class);
                    i.putExtra("id", obj.getPid());
                    i.putExtra("name", obj.getPname());
                    i.putExtra("category", obj.getCategory());
                    i.putExtra("mrp", obj.getMrp());
                    c.startActivity(i);
                    break;
                }
                case R.id.name: {
                    Context c = view.getContext();
                    Intent i = new Intent(context, Details.class);
                    i.putExtra("id", obj.getPid());
                    i.putExtra("name", obj.getPname());
                    i.putExtra("category", obj.getCategory());
                    i.putExtra("mrp", obj.getMrp());
                    c.startActivity(i);
                    break;
                }
                case R.id.category: {
                    Context c = view.getContext();
                    Intent i = new Intent(context, Details.class);
                    i.putExtra("id", obj.getPid());
                    i.putExtra("name", obj.getPname());
                    i.putExtra("category", obj.getCategory());
                    i.putExtra("mrp", obj.getMrp());
                    c.startActivity(i);
                    break;
                }
                case R.id.mrp: {
                    Context c = view.getContext();
                    Intent i = new Intent(context, Details.class);
                    i.putExtra("id", obj.getPid());
                    i.putExtra("name", obj.getPname());
                    i.putExtra("category", obj.getCategory());
                    i.putExtra("mrp", obj.getMrp());
                    c.startActivity(i);
                    break;
                }
            }
        }
    }
}
