package com.example.quizapplication;

/*
HEADER COMMENT -
AUTHOR: Om Kudalkar
DESCRIPTION: This is the java file for the summary page. Here, we display the quiz summary.
*/

import static com.example.quizapplication.questions_Activity.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class summary_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_summary);
        Intent intent = getIntent();

        //Pull and add which temperament the user scored highest in.
        TextView temp_answer = (TextView)findViewById(R.id.temperament_answer);
        String temp_answer_put =intent.getStringExtra("largest");
        temp_answer.setText(temp_answer_put);

        //Pull and add Temperament Description.
        TextView temp_description = (TextView)findViewById(R.id.temperament_description);
        String temp_description_put =intent.getStringExtra("largest_description");
        temp_description.setText(temp_description_put);

        //Pull and add the count for choleric
        TextView chol_result = (TextView)findViewById(R.id.choleric_result);
        String chol_result_put = intent.getStringExtra("chol_count");
        chol_result.setText(chol_result_put);

        //Pull and add the count for sanguine
        TextView sang_result = (TextView)findViewById(R.id.sang_result);
        String sang_result_put =intent.getStringExtra("sang_count");
        sang_result.setText(sang_result_put);

        //Pull and add the count for melancholic
        TextView melancholic_result = (TextView)findViewById(R.id.melancholic_result);
        String melan_result_put =intent.getStringExtra("melancholic_count");
        melancholic_result.setText(melan_result_put);

        //Pull and add the count for phlegmatic
        TextView phleg_result = (TextView)findViewById(R.id.phelg_result);
        String phleg_result_put =intent.getStringExtra("phleg_count");
        phleg_result.setText(phleg_result_put);
    }
}