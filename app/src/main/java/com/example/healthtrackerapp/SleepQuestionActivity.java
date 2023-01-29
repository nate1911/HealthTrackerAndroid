package com.example.healthtrackerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthtrackerapp.fragments.AnalyzesFragment;

public class SleepQuestionActivity extends AppCompatActivity
{
    EditText editText;
    Button submitBtn;
    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep_question);

        editText = findViewById(R.id.answerEt);
        submitBtn = findViewById(R.id.submitBtn);
        backBtn = findViewById(R.id.button_back);

        submitBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String answer = editText.getText().toString().trim();
                if (answer.equals(""))
                {
                    Toast.makeText(SleepQuestionActivity.this, "Please enter your answer.", Toast.LENGTH_SHORT).show();
                }
                else {
                    AnalyzesFragment.sleepAnswer = answer;
                    editText.setText("");
                    Toast.makeText(SleepQuestionActivity.this, "Answer submitted.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}