package com.ishan.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class EnterName extends AppCompatActivity {

    private ImageView nextButton;
    private EditText userName;
    private String time;
    private Calendar mCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_name);

        nextButton=findViewById(R.id.welcomenext);
        userName=findViewById(R.id.username);

        //Using Calendar to get date and Time when user joined
        mCalendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM hh:mm a");
        time=dateFormat.format(mCalendar.getTime());

        //On clicking next Button
        //Name and date/time will is storing using SQLite
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadNameNDate(); //function to upload data

                //After Uploading intent to Next Activity
                Intent intent=new Intent(getBaseContext(),QuestionActivity.class);
                startActivity(intent);


            }
        });
    }

    private void uploadNameNDate(){
        //upload data to database in this function
        // time is variable for time
        //userName.getText().toString() to get name
    }

    //On Back Press
    // User will exit from app
    public void onBackPressed(){
        finishAffinity();
        finish();

    }
}
