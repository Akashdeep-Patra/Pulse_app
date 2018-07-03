package com.example.lucifer.pulse_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class list_adapter extends BaseAdapter {
    ArrayList<OBJECT_MODEL> list;
    Context context;
    private int lasPosition = -1;

    public list_adapter(ArrayList<OBJECT_MODEL> list, Context context) {
        this.list = list;
        this.context = context;
    }

//    public String pid,pname,pcategory,pimage,pmrp;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.data_adapter_layout, viewGroup, false);
        }
        ImageView img = view.findViewById(R.id.image);
        TextView id = view.findViewById(R.id.id);
        TextView name = view.findViewById(R.id.name);
        TextView category = view.findViewById(R.id.category);
        TextView mrp = view.findViewById(R.id.mrp);
        Picasso.get().load("https://s3.ap-south-1.amazonaws.com/pulse-flp/assets/img/"+list.get(i).getPimage()).placeholder(R.drawable.ic_android_black_24dp).error(R.drawable.ic_android_black_24dp).into(img);
        String mid = "ID =" + String.valueOf(list.get(i).getPid());
        String mname = "NAME =" + list.get(i).getPname();
        String mcat = "CATEGORY =" + list.get(i).getCategory();
        String mmrp = "MRP =" + String.valueOf(list.get(i).getMrp());
        id.setText(mid);
//        img.setImageResource(R.drawable.ic_android_black_24dp);
        name.setText(mname);
        category.setText(mcat);
        mrp.setText(mmrp);
        Animation animation = AnimationUtils.loadAnimation(context, (i > lasPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
        view.startAnimation(animation);
        return view;
    }
}
