package com.example.josh.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class passWordDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_word_display);
        Intent intent = getIntent();
        String passWordMsg = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView pWordPassedMsg = (TextView) findViewById(R.id.pw_passedMsg);
        pWordPassedMsg.setText(passWordMsg);
    }
    public void returnHome2(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
