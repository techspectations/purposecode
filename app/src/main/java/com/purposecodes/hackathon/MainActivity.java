package com.purposecodes.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.purposecodes.hackathon.affective.AffectiveActivity;
import com.purposecodes.hackathon.clarifai.ClarifaiActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        String [] items = getResources().getStringArray(R.array.items);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i) {

                    case 0:
                        startActivity(ClarifaiActivity.class);
                        break;

                    case 1:
                        startActivity(com.purposecodes.hackathon.affective.MainActivity.class);
                        break;
                }
            }
        });
    }

    private void startActivity(Class <?> className) {
        startActivity(new Intent(this, className));
    }
}
