package com.example.josh.assignment3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Josh on 3/25/2018.
 */

public class TeamAdd extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_team);

        //Setup buttons and edit text fields
        Button addTeambttn = (Button) findViewById(R.id.submitBttn);
        Button exitAddTeambttn = (Button) findViewById(R.id.bttnExit);
        final EditText etextTeamName = (EditText) findViewById(R.id.eTxtTeamName2);
        final  EditText etextTeamMVP = (EditText) findViewById(R.id.eTxtMVP2);
        final  EditText etextCity = (EditText) findViewById(R.id.eTxtCity);
        final  EditText etextStadium = (EditText) findViewById(R.id.eTxtStadium2);
        final  EditText etextSportCategory  = (EditText) findViewById(R.id.eTxtSportCategory2);


        //Setup Database
        final TeamBaseHelper teamDBHelper = new TeamBaseHelper(getApplicationContext());
        final SQLiteDatabase teamDBWritable =  teamDBHelper.getWritableDatabase();
        final SQLiteDatabase teamDBReadable  =  teamDBHelper.getReadableDatabase();


        addTeambttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                StringBuffer teamNames = new StringBuffer();

                String teamname = etextTeamName.getText().toString();
                String mvp = etextTeamMVP.getText().toString();
                String city = etextCity.getText().toString();
                String stadium = etextStadium.getText().toString();
                String category = etextSportCategory.getText().toString();

                //Insert values into database
                ContentValues values = new ContentValues();
                values.put(TeamDbSchema.TeamsTable.Cols.COLUMN_NAME_TEAMNAME, teamname);
                values.put(TeamDbSchema.TeamsTable.Cols.COLUMN_NAME_CITY, city);
                values.put(TeamDbSchema.TeamsTable.Cols.COLUMN_NAME_MVP, mvp);
                values.put(TeamDbSchema.TeamsTable.Cols.COLUMN_NAME_SPORT, category);
                values.put(TeamDbSchema.TeamsTable.Cols.COLUMN_NAME_STADIUM, stadium);
                long result = teamDBWritable.insert(TeamDbSchema.TeamsTable.Cols.TABLE_NAME,
                            null, values);
                if(result == -1){
                    Toast.makeText(getBaseContext(), "Something went wrong :(.", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Successfully inserted data!.", Toast.LENGTH_SHORT).show();
                }
               etextCity.setText("");
               etextSportCategory.setText("");
               etextTeamMVP.setText("");
               etextTeamName.setText("");
               etextSportCategory.setText("");
            }
        });
    }
}
