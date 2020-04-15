package com.ishan.trivia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {


    private ImageView finish;
    private RecyclerView mRecyclerView;
    private HistoryCustomAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<AddingItemsHistoryModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        finish=findViewById(R.id.history_finish);

        data=new ArrayList<>();

        //Configuring Recycler View
        mRecyclerView=findViewById(R.id.history_container);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        //function to add items in recycler View
        addHistory();

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),EnterName.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void addHistory(){

        //RIght now i have manually added data into adapter
        //download all rows here and add them in ADAPTER

        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));
        data.add(new AddingItemsHistoryModel("GAME1 : ","15th March 2:00pm","Name : Lovish Badlani","Virat Kohli","green,white,orange"));

        //Addind items Now
        mAdapter= new HistoryCustomAdapter(data);
        mRecyclerView.setAdapter(mAdapter);
    }
}
