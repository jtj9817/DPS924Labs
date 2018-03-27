package com.example.josh.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        ArrayAdapter<String> listView1Adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, items
        );
        listView1.setAdapter(listView1Adapter);
    }


}
