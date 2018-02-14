package com.example.tpoapplication;

import android.graphics.Movie;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

/**
 * Created by HP INDIA on 07-Feb-18.
 */

public class CompaniesAdapter extends RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder> {

    private List<Companies> companiesList;
    private List<Companies> itemsCopy;
    public class CompaniesViewHolder extends RecyclerView.ViewHolder {
        public TextView companyName, venue, date, eligibility, salary;
        public ImageView imageView,imageView2;
        public ProgressBar progress;

        public CompaniesViewHolder(View view) {
            super(view);
            companyName = view.findViewById(R.id.textView2);
            venue = view.findViewById(R.id.venue);
            date = view.findViewById(R.id.date);
            eligibility = view.findViewById(R.id.eligibility);
            imageView = view.findViewById(R.id.imageView2);
            imageView2 = view.findViewById(R.id.imageView3);
            salary = view.findViewById(R.id.salary);
            progress  = view.findViewById(R.id.progress);
        }
    }

    public CompaniesAdapter(List<Companies> companiesList, List<Companies> itemsCopy) {
        this.companiesList = companiesList;
        this.itemsCopy = itemsCopy;
    }

    @Override
    public CompaniesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        final ImageView img = itemView.findViewById(R.id.imageView3);
        img.setTag(R.drawable.ic_keyboard_arrow_down_black_24dp);
        final LinearLayout popup = itemView.findViewById(R.id.popup);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img.getTag().equals(R.drawable.ic_keyboard_arrow_down_black_24dp)) {
                    img.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
                    popup.setVisibility(View.VISIBLE);
                    img.setTag(R.drawable.ic_keyboard_arrow_up_black_24dp);

                }else{
                    img.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
                    popup.setVisibility(View.GONE);
                    img.setTag(R.drawable.ic_keyboard_arrow_down_black_24dp);

                }
            }
        });
        return new CompaniesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CompaniesViewHolder holder, int position) {
        Companies companies = companiesList.get(position);
        holder.companyName.setText(companies.getName());
        holder.venue.setText(companies.getVenue());
        holder.date.setText(companies.getDate());
        holder.eligibility.setText(companies.getEligibility());
        holder.salary.setText(companies.getSalary());
        Glide.with(holder.imageView.getContext())
                .load(companies.getImgId())
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        holder.progress.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        holder.progress.setVisibility(View.GONE);
                        return false;
                    }
                })
                .error(R.drawable.no_logo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageView);

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
                if(item.getName().toLowerCase().contains(text) || item.getDate().toLowerCase().contains(text) || item.getEligibility().toLowerCase().contains(text)){
                    companiesList.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }

}
