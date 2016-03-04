package com.example.keshav.represent;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Keshav on 3/1/16.
 */
public class RepAdapter extends ArrayAdapter {
    private List list=new ArrayList();

    public RepAdapter(Context context, int resource) {
        super(context, resource);
    }
    public void add(RepCand object){
        list.add(object);
        super.add(object);
    }
    static class ImgHolder{
        ImageView img;
        ImageView twot;
        TextView name;
        TextView party;
        TextView email;
        TextView web;
        TextView tweet;
        TextView termend;
        TextView committee;
        TextView bills;
    }
    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return this.list.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row;
        row=convertView;
        ImgHolder holder;
        if(convertView==null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.row_layout, parent, false);
            holder = new ImgHolder();

            holder.img = (ImageView) row.findViewById(R.id.rep_img);
            holder.name = (TextView) row.findViewById(R.id.rep_name);
            holder.party = (TextView) row.findViewById(R.id.rep_party);
            holder.email = (TextView) row.findViewById(R.id.rep_email);
            holder.web=(TextView) row.findViewById(R.id.rep_web);
            holder.tweet=(TextView) row.findViewById(R.id.rep_tweet);
            holder.twot=(ImageView) row.findViewById(R.id.rep_twot);

            row.setTag(holder);
        }
        else{
            holder = (ImgHolder) row.getTag();

        }
        RepCand rc=(RepCand) getItem(position);
        holder.img.setImageResource(rc.getRep_resource());
        holder.name.setText(rc.getRep_name());
        holder.party.setText(rc.getRep_party());
        holder.email.setText(rc.getRep_email());
        holder.web.setText(rc.getRep_web());
        holder.tweet.setText(rc.getRep_tweet());
        holder.twot.setImageResource(rc.getTwot());
        return row;
    }
}