package com.example.logindemo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by aqsakawan on 4/20/2018.
 */

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {
    Context context;
    ArrayList<String> Name_Rest;
    ArrayList<String> Address_Rest;
    ArrayList<String> Picture_Rest;
    String search_string;

    class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView RestImage;
        TextView Rest_Name, Rest_Address;


        public SearchViewHolder(View itemView) {
            super(itemView);
            RestImage = (ImageView) itemView.findViewById(R.id.rest_image_id);
            Rest_Name = (TextView) itemView.findViewById(R.id.Name_of_Rest);
            Rest_Address = (TextView) itemView.findViewById(R.id.Address_of_Rest);
        }
    }

    public SearchAdapter(Context context, ArrayList<String> Name_Rest, ArrayList<String> Address_Rest, ArrayList<String> Picture_Rest, String string_search) {
        this.context = context;
        this.Name_Rest = Name_Rest;
        this.Address_Rest = Address_Rest;
        this.Picture_Rest = Picture_Rest;
        this.search_string = string_search;
    }

    @Override
    public SearchAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_list_items, parent, false);
        return new SearchAdapter.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        holder.Rest_Name.setText(Name_Rest.get(position));
        holder.Rest_Address.setText(Address_Rest.get(position));

        Glide.with(context).load(Picture_Rest.get(position)).asBitmap().placeholder(R.mipmap.ic_launcher_round).into(holder.RestImage);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(search_string.contains("Zouk")){
                    Intent intent = new Intent(view.getContext(), Zouk_mainpage.class);
                    Toast.makeText(context, "Welcome to Zouk!" , Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);

                }
                if(search_string.contains("Jade")){
                    Intent intent = new Intent(view.getContext(), Jade_mainpage.class);
                    Toast.makeText(context, "Welcome to Jade!", Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);
                }
                if(search_string.contains("China Town")){
                    Intent intent = new Intent(view.getContext(), Jade_mainpage.class);
                    Toast.makeText(context, "Welcome to  China Town!", Toast.LENGTH_SHORT).show();
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return Name_Rest.size();
    }

}

