package com.example.josh.lab5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] firstSet = {
    "Santa Claus", "Rain Umbrella", "Picket Fence", "Space Ship",
     "Foreign Passport", "Flower Icon", "Snow Man", "Skull Bones",
     "Flower Pot", "Libra Scale", "Teddy Bear", "Diamond Ring"
    };
    String [] secondSet = {

    };
    Integer[] resourceIDs = {

    };
    int[] IMAGESET1= {
        R.drawable.santaclaus, R.drawable.umbrella, R.drawable.fence, R.drawable.spaceship,
            R.drawable.passport, R.drawable.flower, R.drawable.snowman, R.drawable.skull,
            R.drawable.flowerpot, R.drawable.justicescale, R.drawable.teddybear, R.drawable.diamondring
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        final ListView listview1 = (ListView) findViewById(R.id.listView1);
        final ArrayList<String> stringValues1 = new ArrayList<>();
        for(int i=0; i < firstSet.length; i++){
            stringValues1.add(firstSet[i]);
        }*/
        final ListView listview1 = (ListView) findViewById(R.id.listView1);
        CustomAdapter customAdapter = new CustomAdapter();
        listview1.setAdapter(customAdapter);

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                String icon_desc1 = String.valueOf(parent.getItemAtPosition(i));
                int icon = i;
            }
        });


    }

    public class CustomAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return IMAGESET1.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.listrow1,null);
            ImageView imageView1 = (ImageView) view.findViewById(R.id.targetIcon);
            TextView icon_desc1 = (TextView) view.findViewById(R.id.iconDescription);

            imageView1.setImageResource(IMAGESET1[i]);
            icon_desc1.setText(firstSet[i]);

            return view;
        }
    }
}
