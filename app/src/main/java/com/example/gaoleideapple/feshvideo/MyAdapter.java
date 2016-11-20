package com.example.gaoleideapple.feshvideo;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collection;
import java.util.List;

/**
 * Created by gaoleideapple on 16/10/22.
 */

public class MyAdapter extends BaseAdapter {

    private Context context;
    private List<Cook> list;

    public MyAdapter(Context context, List<Cook> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.item_adapter,parent,false);
            convertView.setTag(new MyViewHolder(convertView));
        }
        MyViewHolder viewHolder= (MyViewHolder) convertView.getTag();
        Cook cook=list.get(position);
        viewHolder.title.setText(cook.getName());
        Log.d("gl","======="+cook.getName());
        viewHolder.desc.setText(cook.getDescription());
        Picasso.with(context).load("http://tnfs.tngou.net/img"+cook.getImg()).into(viewHolder.imageView);
        return convertView;
    }

    public  void addAll(Collection<? extends Cook> collection){
        list.addAll(collection);
        notifyDataSetChanged();
    }


    public static class MyViewHolder {
        ImageView imageView;
        TextView title, desc;

        public MyViewHolder(View item) {
            imageView = (ImageView) item.findViewById(R.id.item_image);
            title = (TextView) item.findViewById(R.id.item_title);
            desc = (TextView) item.findViewById(R.id.item_info);

        }
    }
}
