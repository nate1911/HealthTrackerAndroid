package com.example.healthtrackerapp.classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthtrackerapp.AlcoholQuestionActivity;
import com.example.healthtrackerapp.NutritionQuestionActivity;
import com.example.healthtrackerapp.R;
import com.example.healthtrackerapp.SleepQuestionActivity;
import com.example.healthtrackerapp.StressQuestionActvity;

import java.util.ArrayList;

public class QuestionsAdapter extends RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>
{
    ArrayList<String> stringArrayList;
    Context context;

    public QuestionsAdapter(ArrayList<String> stringArrayList, Context context)
    {
        this.stringArrayList = stringArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.titleTv.setText(stringArrayList.get(position));
        holder.titleTv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                switch (holder.getAdapterPosition())
                {
                    case 0:
                    context.startActivity(new Intent(context, SleepQuestionActivity.class));
                    break;
                    case 1:
                    context.startActivity(new Intent(context, NutritionQuestionActivity.class));
                    break;
                    case 2:
                    context.startActivity(new Intent(context, StressQuestionActvity.class));
                    break;
                    case 3:
                    context.startActivity(new Intent(context, AlcoholQuestionActivity.class));
                    break;

                }
            }
        });
    }

    @Override
    public int getItemCount()
    {
        return stringArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTv;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            titleTv = itemView.findViewById(R.id.textView2);
        }
    }
}
