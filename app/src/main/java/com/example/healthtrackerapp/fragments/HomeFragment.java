package com.example.healthtrackerapp.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.healthtrackerapp.R;
import com.example.healthtrackerapp.classes.HomeDescriptionModel;
import com.example.healthtrackerapp.classes.HomeRecyclerViewAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2)
    {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if (getArguments() != null)
        {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    View view;
    RecyclerView recyclerView;
    HomeRecyclerViewAdapter recyclerViewAdapter;
    ArrayList<HomeDescriptionModel> descriptionModelArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);

        descriptionModelArrayList = new ArrayList<>();
        descriptionModelArrayList.add(new HomeDescriptionModel(
                "Introduction to mental health", "-OAjfrhuwRk"));
        descriptionModelArrayList.add(new HomeDescriptionModel(
                "- Sleep and mental health", "98V1q5k8x5E"));
        descriptionModelArrayList.add(new HomeDescriptionModel(
                "Nutrition and mental health", "xyQY8a-ng6g"));
        descriptionModelArrayList.add(new HomeDescriptionModel(
                "Stress and mental health", "DxIDKZHW3-E"));
        descriptionModelArrayList.add(new HomeDescriptionModel(
                "Alcohol and mental health", "hzcZd08PqSQ"));
        recyclerView = view.findViewById(R.id.homeRcyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewAdapter = new HomeRecyclerViewAdapter(descriptionModelArrayList, getContext());
        recyclerView.setAdapter(recyclerViewAdapter);

        return view;
    }
}