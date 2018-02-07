package com.example.josh.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class userNameDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_name_display);
        Intent intent = getIntent();
        String userNameMsg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView uNamePassedMsg = (TextView) findViewById(R.id.un_passedMsg);
        uNamePassedMsg.setText(userNameMsg);
    }

    public void returnHome1(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
