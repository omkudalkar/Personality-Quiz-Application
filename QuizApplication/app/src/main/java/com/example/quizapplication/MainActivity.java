package com.example.quizapplication;
/*
HEADER COMMENT -
AUTHOR: Om Kudalkar
DESCRIPTION: This is the java file for the home page of the quiz app.
here the user has the button to start the quiz.
*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** called when the user taps the 'take quiz' button */
    public void dueDatesButton(View view) {
        // Do something in response to button
        //Basically our intent on the button click is that we display the questions_activity class.
        Intent intent = new Intent(this, questions_Activity.class);

        startActivity(intent);
    }
}