package com.example.josh.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class loginDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_display);
        Intent intent = getIntent();
        Bundle extras = getIntent().getExtras();
        String userNameMsg = extras.getString("mUSERNAME");
        String passWordMsg = extras.getString("mPASSWORD");
        TextView pWordPassedMsg = (TextView) findViewById(R.id.passed_PWmsg);
        TextView uNamePassedMsg = (TextView) findViewById(R.id.passed_UNmsg);
        pWordPassedMsg.setText(passWordMsg);
        uNamePassedMsg.setText(userNameMsg);
    }

    public void returnHome3(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
