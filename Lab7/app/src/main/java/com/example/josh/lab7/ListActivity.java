package com.example.josh.lab7;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //Setup buttons and edit text
        Button addTeam1bttn = (Button) findViewById(R.id.bttnAddTeam1);
        Button addTeam2bttn = (Button) findViewById(R.id.bttnAddTeam2);
        final  EditText etextTeamCaptain1 = (EditText) findViewById(R.id.eTextTeamCaptain1);
        final  EditText etextTeam1Member1 = (EditText) findViewById(R.id.eTextTeam1Member1);
        final  EditText etextTeam1Member2 = (EditText) findViewById(R.id.eTextTeam1Member2);
        final  EditText etextTeamCaptain2 = (EditText) findViewById(R.id.eTextTeamCaptain2);
        final  EditText etextTeam2Member1 = (EditText) findViewById(R.id.eTextTeam2Member1);
        final  EditText etextTeam2Member2 = (EditText) findViewById(R.id.eTextTeam2Member2);


        //Setup Database
        final TeamBaseHelper teamDBHelper = new TeamBaseHelper(getApplicationContext());
        final SQLiteDatabase teamDBWritable =  teamDBHelper.getWritableDatabase();
        final SQLiteDatabase teamDBReadable  =  teamDBHelper.getReadableDatabase();

        //Populate the arrays and adapters for listviews
        String [] items = {"Item 1", "Item 2", "Item 3"};
        ListView listView1 = (ListView) findViewById(R.id.listViewTeam1);
        ArrayAdapter<String> listView1Adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items
        );
        listView1.setAdapter(listView1Adapter);
    }


}
