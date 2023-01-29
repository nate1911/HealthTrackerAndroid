package com.example.healthtrackerapp.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthtrackerapp.R;
import com.example.healthtrackerapp.classes.TextClassificationHelper;

import org.tensorflow.lite.support.label.Category;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnalyzesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnalyzesFragment extends Fragment
{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnalyzesFragment()
    {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnalyzesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnalyzesFragment newInstance(String param1, String param2)
    {
        AnalyzesFragment fragment = new AnalyzesFragment();
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
    TextClassificationHelper classificationHelper, classificationHelper2,
            classificationHelper3, classificationHelper4;
    List<Category> categoryList;
    Button classifyBtn;
    TextView firstResultTv, secondResultTv, nutitionFirstTv, nutitionSecondTv,
    stressFirstTv, stressSecondTv, alcohalFirstTv, alcohalSecondTv;
    static public String sleepAnswer = "", nutritionAnswer = "", stressAnswer = "", alcohalAnswer = "";

    private TextClassificationHelper.TextResultsListener listener = new TextClassificationHelper.TextResultsListener()
    {
        @Override
        public void onResult(@NonNull List<Category> results, long inferenceTime)
        {
            categoryList = results;
            float score = new BigDecimal(categoryList.get(0).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            firstResultTv.setText(categoryList.get(0).getLabel()+" : "+score);
            float score2 = new BigDecimal(categoryList.get(1).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            secondResultTv.setText(categoryList.get(1).getLabel()+" : "+score2);
        }

        @Override
        public void onError(@NonNull String error)
        {
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        }
    };

private TextClassificationHelper.TextResultsListener listener2 = new TextClassificationHelper.TextResultsListener()
    {
        @Override
        public void onResult(@NonNull List<Category> results, long inferenceTime)
        {
            categoryList = results;
            float score = new BigDecimal(categoryList.get(0).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            nutitionFirstTv.setText(categoryList.get(0).getLabel()+" : "+score);
            float score2 = new BigDecimal(categoryList.get(1).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            nutitionSecondTv.setText(categoryList.get(1).getLabel()+" : "+score2);
        }

        @Override
        public void onError(@NonNull String error)
        {
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        }
    };

private TextClassificationHelper.TextResultsListener listener3 = new TextClassificationHelper.TextResultsListener()
    {
        @Override
        public void onResult(@NonNull List<Category> results, long inferenceTime)
        {
            categoryList = results;
            float score = new BigDecimal(categoryList.get(0).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            stressFirstTv.setText(categoryList.get(0).getLabel()+" : "+score);
            float score2 = new BigDecimal(categoryList.get(1).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            stressSecondTv.setText(categoryList.get(1).getLabel()+" : "+score2);
        }

        @Override
        public void onError(@NonNull String error)
        {
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        }
    };

private TextClassificationHelper.TextResultsListener listener4 = new TextClassificationHelper.TextResultsListener()
    {
        @Override
        public void onResult(@NonNull List<Category> results, long inferenceTime)
        {
            categoryList = results;
            float score = new BigDecimal(categoryList.get(0).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            alcohalFirstTv.setText(categoryList.get(0).getLabel()+" : "+score);
            float score2 = new BigDecimal(categoryList.get(1).getScore()).setScale(4, RoundingMode.FLOOR).floatValue();
            alcohalSecondTv.setText(categoryList.get(1).getLabel()+" : "+score2);
        }

        @Override
        public void onError(@NonNull String error)
        {
            Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_analyzes, container, false);
        Toast.makeText(getContext(), "please wait", Toast.LENGTH_SHORT).show();
        classifyBtn = view.findViewById(R.id.classifyButton);
        firstResultTv = view.findViewById(R.id.firstResult);
        secondResultTv = view.findViewById(R.id.secondResult);
        nutitionFirstTv = view.findViewById(R.id.nutritionFirstResult);
        nutitionSecondTv = view.findViewById(R.id.nutritionSecondResult);
        stressFirstTv = view.findViewById(R.id.stressFirstResult);
        stressSecondTv = view.findViewById(R.id.stressSecondResult);
        alcohalFirstTv = view.findViewById(R.id.alcohalFirstResult);
        alcohalSecondTv = view.findViewById(R.id.alcohalSecondResult);

        classificationHelper = new TextClassificationHelper(requireContext());
        classificationHelper2 = new TextClassificationHelper(requireContext());
        classificationHelper3 = new TextClassificationHelper(requireContext());
        classificationHelper4 = new TextClassificationHelper(requireContext());
        classificationHelper.initClassifier();
        classificationHelper2.initClassifier();
        classificationHelper3.initClassifier();
        classificationHelper4.initClassifier();

        classifyBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                classificationHelper.classify(sleepAnswer, listener);
                classificationHelper2.classify(nutritionAnswer, listener2);
                classificationHelper3.classify(stressAnswer, listener3);
                classificationHelper4.classify(alcohalAnswer, listener4);
            }
        });

        return view;
    }
}