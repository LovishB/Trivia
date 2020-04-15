package com.ishan.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private ImageView finish;
    private ImageView history;

    private Intent mIntent;
    private String[] data;

    private TextView name,ans1,ans2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        mIntent=getIntent();
         data= mIntent.getStringArrayExtra("Data");

        finish=findViewById(R.id.summary_finish);
        history=findViewById(R.id.summary_history);
        name=findViewById(R.id.summary_name);
        ans1=findViewById(R.id.summary_ans1);
        ans2=findViewById(R.id.summary_ans2);
        //function to load summary for local storage
        loadData();

        //intent to Enter Name Activity
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EnterName.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        //Intent to History Activity
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),HistoryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void loadData(){

        name.setText("Hello, "+data[0]);
        ans1.setText("Answer: "+data[2]);
        ans2.setText("Answer: "+data[3]);

        //data[0] is name
        //data[1] is time
        //data[2] is ans1
        //data[3] is ans2

    }


    //Disabled Back Button
    @Override
    public void onBackPressed () {

    }
}
