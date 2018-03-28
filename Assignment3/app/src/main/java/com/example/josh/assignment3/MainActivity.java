package com.example.josh.assignment3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TeamBaseHelper teamsDB = new TeamBaseHelper(this);
        Button mainbutton;
        mainbutton = findViewById(R.id.bttnAddTeam);
        mainbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TeamAdd.class);
                startActivity(intent);
            }
        });
        ListView listView1 = (ListView) findViewById(R.id.listViewTeams);
        //populate an ArrayList<String> from the database and then view it
        ArrayList<String> theList = new ArrayList<>();
        Cursor teams = teamsDB.getTeamNames();
        int teamNameIndex = teams.getColumnIndex("teamName");
        while(teams.moveToNext())
        {
                theList.add(teams.getString(teamNameIndex));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                //listView1.setAdapter(listAdapter);
                listView1.setAdapter(new ArrayAdapter<String>(this, R.layout.listrow, R.id.textView2, theList));
        }
        /*
        ArrayAdapter<String> listView1Adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items
        );
        listView1.setAdapter(listView1Adapter);*/
    }


}
