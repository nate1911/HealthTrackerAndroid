package com.example.healthtrackerapp.classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthtrackerapp.R;

import java.util.ArrayList;

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder>
{

    ArrayList<HomeDescriptionModel> urlArrayList;
    Context context;

    public HomeRecyclerViewAdapter(ArrayList<HomeDescriptionModel> urlArrayList, Context context)
    {
        this.urlArrayList = urlArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_recycler_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.titleTv.setText(urlArrayList.get(position).getTitle()+":");
        String videoID = urlArrayList.get(position).getVideoUrl();
        holder.webView.getSettings().setJavaScriptEnabled(true);
        holder.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        holder.webView.loadUrl("https://www.youtube.com/embed/" + videoID + "?autoplay=1&vq=small");
        holder.webView.setWebChromeClient(new WebChromeClient());
    }

    @Override
    public int getItemCount()
    {
        return urlArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        WebView webView;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTv = itemView.findViewById(R.id.titleTv);
            webView = itemView.findViewById(R.id.webView);
        }
    }
}
