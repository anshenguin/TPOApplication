package com.example.tpoapplication;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by HP INDIA on 07-Feb-18.
 */

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder> {

    private List<Companies> companiesList;
    private List<Companies> itemsCopy;
    public class CompaniesViewHolder extends RecyclerView.ViewHolder {
        public TextView companyName, venue, date;

        public CompaniesViewHolder(View view) {
            super(view);
            companyName = view.findViewById(R.id.companyName);
            venue = view.findViewById(R.id.venue);
            date = view.findViewById(R.id.date);
        }
    }

    public CompaniesAdapter(List<Companies> companiesList, List<Companies> itemsCopy) {
        this.companiesList = companiesList;
        this.itemsCopy = itemsCopy;
    }

    @Override
    public CompaniesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new CompaniesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CompaniesViewHolder holder, int position) {
        Companies companies = companiesList.get(position);
        holder.companyName.setText(companies.getName());
        holder.venue.setText(companies.getVenue());
        holder.date.setText(companies.getDate());
    }

    @Override
    public int getItemCount() {
        return companiesList.size();
    }
    public void filter(String text) {
        companiesList.clear();
        if(text.isEmpty()){
            companiesList.addAll(itemsCopy);
        } else{
            text = text.toLowerCase();
            for(Companies item: itemsCopy){
                if(item.getName().toLowerCase().contains(text) || item.getDate().toLowerCase().contains(text)){
                    companiesList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
