package com.example.josh.project2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public static final String EXTRA_MESSAGE =
            "com.example.josh.project2.extra.MESSAGE";

    public void launchUNActivity(View view) {
       Intent intent = new Intent(this, userNameDisplay.class);
        EditText UsernameTextEdit = (EditText)findViewById(R.id.editTextUN);
        String userNameMessage = UsernameTextEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, userNameMessage);
       startActivity(intent);
    }

    public void launchPWActivity(View view) {
        Intent intent = new Intent(this, passWordDisplay.class);
        EditText PasswordTextEdit = (EditText)findViewById(R.id.editTextPW);
        String passWordMessage = PasswordTextEdit.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, passWordMessage);
        startActivity(intent);
    }

    public void launchLoginActivity(View view){
        Intent intent = new Intent(this, loginDisplay.class);
        Bundle extras = new Bundle();
        EditText UsernameTextEdit = (EditText)findViewById(R.id.editTextUN);
        EditText PasswordTextEdit = (EditText)findViewById(R.id.editTextPW);
        String usernameMessage = UsernameTextEdit.getText().toString();
        String passWordMessage = PasswordTextEdit.getText().toString();
        extras.putString("mUSERNAME", usernameMessage);
        extras.putString("mPASSWORD", passWordMessage);
        intent.putExtras(extras);
        startActivity(intent);
    }
}

