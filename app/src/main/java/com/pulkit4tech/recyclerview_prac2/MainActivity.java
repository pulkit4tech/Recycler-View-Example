package com.pulkit4tech.recyclerview_prac2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv;
    private Recycler_adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rcv = (RecyclerView) findViewById(R.id.recycler_view);

        adapter = new Recycler_adapter(getApplicationContext(),getdata());
        rcv.setAdapter(adapter);

        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    public static List<data_item> getdata(){
        List<data_item> data = new ArrayList<>();
        int icon[] = {R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher,
                R.drawable.ic_launcher,R.drawable.ic_launcher,R.drawable.ic_launcher};
        String text[] = {"Monday","tuesday","wednessday","thurs",
        "friday","sat","sunday","monday"};

        for (int i=0;i<100;i++){
            data_item temp = new data_item();
            Random r = new Random();
            int index = r.nextInt(7);
            temp.title = text[index];
            temp.imageid = icon[index];


            data.add(temp);
        }

        return data;
    }
}
