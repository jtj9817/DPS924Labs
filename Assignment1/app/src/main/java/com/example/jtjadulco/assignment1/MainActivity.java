package com.example.jtjadulco.assignment1;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private RadioGroup nameSelection1, nameSelection2;
    private RadioButton radioNameButton, radioNameButton2;

    private String selectedName1, selectedName2;
    private Button sayHi, sayHello;

    private TextView displayName, displayName2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerNameBttn();
        addListenerNameBttn2();

    }

    public void addListenerNameBttn(){
        nameSelection1 = (RadioGroup) findViewById(R.id.namesRGroup1);
        sayHi =  (Button) findViewById(R.id.hiBttn);
        displayName = (TextView) findViewById(R.id.txtViewNameDisplay);

        sayHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedIDName = nameSelection1.getCheckedRadioButtonId();
                radioNameButton = (RadioButton) findViewById(selectedIDName);
                displayName.setText(radioNameButton.getText());
                Toast.makeText(MainActivity.this, radioNameButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        nameSelection1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedIDName = nameSelection1.getCheckedRadioButtonId();
                radioNameButton = (RadioButton) findViewById(selectedIDName);
                switch(i)
                {
                    case R.id.radioAlice:
                        Toast.makeText(MainActivity.this, radioNameButton.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioBob:
                        Toast.makeText(MainActivity.this, radioNameButton.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioCarol:
                        Toast.makeText(MainActivity.this, radioNameButton.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    public void addListenerNameBttn2(){
        nameSelection2 = (RadioGroup) findViewById(R.id.namesRGroup2);
        sayHello =  (Button) findViewById(R.id.helloBttn);
        displayName2 = (TextView) findViewById(R.id.txtViewNameDisplay2);

        sayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedIDName2 = nameSelection2.getCheckedRadioButtonId();
                radioNameButton2 = (RadioButton) findViewById(selectedIDName2);
                displayName2.setText(radioNameButton2.getText());
                Toast.makeText(MainActivity.this, radioNameButton2.getText(), Toast.LENGTH_SHORT).show();
            }
        });

        nameSelection2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedIDName2 = nameSelection2.getCheckedRadioButtonId();
                radioNameButton2 = (RadioButton) findViewById(selectedIDName2);
                switch(i)
                {
                    case R.id.radioDave:
                        Toast.makeText(MainActivity.this, radioNameButton2.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioEve:
                        Toast.makeText(MainActivity.this, radioNameButton2.getText(), Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.radioFred:
                        Toast.makeText(MainActivity.this, radioNameButton2.getText(), Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }


}
