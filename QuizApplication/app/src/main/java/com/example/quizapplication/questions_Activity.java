package com.example.quizapplication;

/*
HEADER COMMENT -
AUTHOR: Om Kudalkar
DESCRIPTION: This is the java file for the page/activity where the questions show
up and the user needs to select a response for each question.
*/

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.Random;

public class questions_Activity extends AppCompatActivity {
    //private InputStream fileInputStream;
    //private Reader inputStreamReader;
    Random random = new Random();

    //we will store the questions/every line of the melancholic file as elements of these arrays.
    private static String[] qs_melancholic = new String[12];
    //this integer array is to keep a track of the completed questions in the melancholic file.
    //we keep this file so that we can check it to make sure we don't repeat questions.
    private static int[] completed_qs_melancholic = new int[12];

    //we will store the questions/every line of the melancholic file as elements of these arrays.
    private static String[] qs_phlegmatic = new String[12];
    //this integer array is to keep a track of the completed questions in the melancholic file.
    //we keep this file so that we can check it to make sure we don't repeat questions.
    private static int[] completed_qs_phleg = new int[12];

    //we will store the questions/every line of the melancholic file as elements of these arrays.
    private static String[] qs_choleric = new String[12];
    //this integer array is to keep a track of the completed questions in the melancholic file.
    //we keep this file so that we can check it to make sure we don't repeat questions.
    private static int[] completed_qs_choleric = new int[12];

    //we will store the questions/every line of the melancholic file as elements of these arrays.
    private static String[] qs_sang = new String[12];
    //this integer array is to keep a track of the completed questions in the melancholic file.
    //we keep this file so that we can check it to make sure we don't repeat questions.
    private static int[] completed_qs_sang = new int[12];


    //this is to keep track of how many questions we have asked the user till now.
    private static int total_question_count=1;
    //this is so that we know which file we need to pull the question from.
    //there is a particular order of asking questions that needs to be followed
    //so this is required.
    private static int round_count=1;

    //counts for each type.
    //this is the total for every type of temperament.
    protected static int choleric_count=0;
    protected static int melancholic_count=0;
    protected static int phleg_count=0;
    protected static int sang_count=0;

    //this is the amount to add for a specifc question based on the
    //radio button selected.
    private static int amount_to_add;
    //this is the string for the category the user scores the most points in.
    private static String biggest_temp;
    //this is to keep a track of the highest score so we can find the max.
    private static int max_temp_count;

    //this is a variable introduced to handle the case of when there is a tie.

    private static int number_of_maxes=0;





    public questions_Activity() throws IOException {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //this is the textview we made for displaying the questions.
        TextView txtView = (TextView)findViewById(R.id.question_text);


        //all this code below is to get every line of the melancholic file in an array.

        InputStream inputStream_melancholic = getResources().openRawResource(R.raw.melancholic);
        BufferedReader bufferedReader_melancholic= new BufferedReader(new InputStreamReader(inputStream_melancholic));
        String eachline = null;
        int count_of_lines=0;

        try {
            eachline = bufferedReader_melancholic.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (eachline != null) {

            try {
                //txtView.setText(eachline);
                qs_melancholic[count_of_lines] = eachline;
                count_of_lines+=1;
                eachline = bufferedReader_melancholic.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //txtView.setText(qs_melancholic[11]);


        //all this code below is to get every line of the melancholic file in an array.
        InputStream inputStream_choleric = getResources().openRawResource(R.raw.choleric);
        BufferedReader bufferedReader_choleric= new BufferedReader(new InputStreamReader(inputStream_choleric));
        String eachline_choleric = null;
        int count_of_lines_choleric=0;

        try {
            eachline_choleric = bufferedReader_choleric.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (eachline_choleric != null) {
            // the words in the file are separated by space, so to get each words

            try {
                //txtView.setText(eachline);
                qs_choleric[count_of_lines_choleric] = eachline_choleric;
                count_of_lines_choleric+=1;
                eachline_choleric = bufferedReader_choleric.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //all this code below is to get every line of the melancholic file in an array.
        InputStream inputStream_phleg = getResources().openRawResource(R.raw.phlegmatic);
        BufferedReader bufferedReader_phleg= new BufferedReader(new InputStreamReader(inputStream_phleg));
        String eachline_phleg = null;
        int count_of_lines_phleg =0;

        try {
            eachline_phleg = bufferedReader_phleg.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (eachline_phleg != null) {
            // the words in the file are separated by space, so to get each words

            try {
                //txtView.setText(eachline);
                qs_phlegmatic[count_of_lines_phleg] = eachline_phleg;
                count_of_lines_phleg+=1;
                eachline_phleg = bufferedReader_phleg.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //all this code below is to get every line of the melancholic file in an array.

        InputStream inputStream_sang = getResources().openRawResource(R.raw.sanguine);
        BufferedReader bufferedReader_sang= new BufferedReader(new InputStreamReader(inputStream_sang));
        String eachline_sang = null;
        int count_of_lines_sang=0;

        try {
            eachline_sang = bufferedReader_sang.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (eachline_sang != null) {
            // the words in the file are separated by space, so to get each words

            try {
                //txtView.setText(eachline);
                qs_sang[count_of_lines_sang] = eachline_sang;
                count_of_lines_sang+=1;
                eachline_sang = bufferedReader_sang.readLine();


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //AT THIS POINT, ALL THE FILES HAVE BEEN READ INTO ARRAYS.
        int random_int = random.nextInt(12-0)+0;
        txtView.setText(qs_choleric[random_int]);


    }

    /** called when the user taps the 'next question' button */
    public void nextQuestionButton(View view) {
        //we get the id of the text-view where the question is to be displayed.
        TextView txtView = (TextView)findViewById(R.id.question_text);

        //if the round_count is 12 meaning last round so next button click has to
        //be the summary page.
        if (round_count!=12) {

            //we check what "round" we are on and accordingly decide
            //what file to pull from.
            if (round_count == 1 || round_count == 5 || round_count == 9) {
                choleric_count+=amount_to_add;
                int random_int = random.nextInt(12 - 0) + 0;

                //this is to make sure we don't pull out the same question again.
                while ((Arrays.asList(completed_qs_choleric).contains(random_int)) == true) {
                    random_int = random.nextInt(12 - 0) + 0;
                }

                txtView.setText(qs_choleric[random_int]);
                completed_qs_choleric[round_count] = random_int;
            }

            if (round_count == 2 || round_count == 6 || round_count == 10) {
                sang_count+=amount_to_add;
                int random_int = random.nextInt(12 - 0) + 0;

                //this is to make sure we dont pull out the same question again.
                while ((Arrays.asList(completed_qs_sang).contains(random_int)) == true) {
                    random_int = random.nextInt(12 - 0) + 0;
                }
                txtView.setText(qs_sang[random_int]);
                completed_qs_sang[round_count] = random_int;
            }


            if (round_count == 3 || round_count == 7 || round_count == 11) {
                melancholic_count+=amount_to_add;
                int random_int = random.nextInt(12 - 0) + 0;

                //this is to make sure we dont pull out the same question again.
                while ((Arrays.asList(completed_qs_melancholic).contains(random_int)) == true) {
                    random_int = random.nextInt(12 - 0) + 0;
                }

                txtView.setText(qs_melancholic[random_int]);
                completed_qs_melancholic[round_count] = random_int;
            }


            if (round_count == 4 || round_count == 8 || round_count == 12) {
                phleg_count+=amount_to_add;
                int random_int = random.nextInt(12 - 0) + 0;

                //this is to make sure we dont pull out the same question again.
                while ((Arrays.asList(completed_qs_phleg).contains(random_int)) == true) {
                    random_int = random.nextInt(12 - 0) + 0;
                }

                txtView.setText(qs_phlegmatic[random_int]);
                completed_qs_phleg[round_count] = random_int;

            }
            round_count+=1;
        }else{

            //the way our if/else is set up, on the last round ie the 12th round,
            //the score isn't added to phleg category since @ 12, it jumps
            //into this else.
            //SO, we add to phleg count one last time here.
            phleg_count+=amount_to_add;
            int random_int = random.nextInt(12 - 0) + 0;

            //this is to make sure we don't pull out the same question again.
            while ((Arrays.asList(completed_qs_phleg).contains(random_int)) == true) {
                random_int = random.nextInt(12 - 0) + 0;
            }

            txtView.setText(qs_phlegmatic[random_int]);

            //now we need to calculate which trait is the biggest.
            max_temp_count = choleric_count;

            if (sang_count > max_temp_count)
                max_temp_count = sang_count;

            if (melancholic_count > max_temp_count)
                max_temp_count = melancholic_count;

            if (phleg_count > max_temp_count)
                max_temp_count = phleg_count;

            //after all the ifs have run, we will have a largest temperament score.

            //we need to pass all of these extras to our intent.
            Intent intent_new = new Intent(this, summary_Activity.class);
            intent_new.putExtra("chol_count", String.valueOf(choleric_count));
            intent_new.putExtra("sang_count",String.valueOf(sang_count));
            intent_new.putExtra("melancholic_count",String.valueOf(melancholic_count));
            intent_new.putExtra("phleg_count",String.valueOf(phleg_count));

            //here, we determine which is the highest scoring temperament.
            //we set the string to that temperament and then pass it to the intent.
            if (max_temp_count == choleric_count){
                number_of_maxes+=1;
                biggest_temp = "Choleric";
                intent_new.putExtra("largest", biggest_temp);
                intent_new.putExtra("largest_description", this.getString(R.string.choleric_description));

            }
            if (max_temp_count == sang_count){
                number_of_maxes+=1;
                biggest_temp = "Sanguine";
                intent_new.putExtra("largest", biggest_temp);
                intent_new.putExtra("largest_description", this.getString(R.string.sanguine_description));


            }
            if (max_temp_count == melancholic_count){
                number_of_maxes+=1;
                biggest_temp = "Melancholic";
                intent_new.putExtra("largest", biggest_temp);
                intent_new.putExtra("largest_description", this.getString(R.string.melancholic_description));


            }
            if (max_temp_count == phleg_count){
                number_of_maxes+=1;
                biggest_temp = "Phlegmatic";
                intent_new.putExtra("largest", biggest_temp);
                intent_new.putExtra("largest_description", this.getString(R.string.phleg_description));



            }

            //we have kept a track of whether there are more than one dominant
            //traits.

            if(number_of_maxes>1){

                biggest_temp = this.getString(R.string.tie_message)+" "+ biggest_temp;
                intent_new.putExtra("largest", biggest_temp);
            }

            startActivity(intent_new);

        }

    }

    public void add_four(View view){
        amount_to_add=4;
    }

    public void add_three(View view) {
        amount_to_add = 3;

    }
    public void add_two(View view){
        amount_to_add = 2;
    }
    public void add_one(View view){
        amount_to_add = 1;

    }
    public void add_zero(View view){
        amount_to_add = 0;

    }


}