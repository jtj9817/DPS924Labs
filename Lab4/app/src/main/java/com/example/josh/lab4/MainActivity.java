package com.example.josh.lab4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ListView listview1 = (ListView) findViewById(R.id.listView1);
        String[] values = new String []  {"A", "B", "C", "D",
                "E", "F", "G", "H", "I", "J", "K", "L", "M"
        };
        final ArrayList<String> list1 = new ArrayList<String>();
        for(int i=0; i < values.length; i++)
        {
            list1.add(values[i]);
        }
        final ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1, list1);
        listview1.setAdapter(new ArrayAdapter<String>(this, R.layout.listrow, R.id.textView2, values));

        final ListView listview2 = (ListView) findViewById(R.id.listView2);
        String[] values2 = new String[] {
                "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };
        final ArrayList<String> list2 = new ArrayList<String>();
        for(int i=0; i < values2.length; i++){
            list2.add(values2[i]);
        }
        final ArrayAdapter adapter2 =  new ArrayAdapter(this, android.R.layout.simple_list_item_1, list2);
        listview2.setAdapter(new ArrayAdapter<String>(this, R.layout.listrow, R.id.textView3, values2));

    }
}
