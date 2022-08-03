package com.gzeinnumer.dynamiccheckbox_example;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.gzeinnumer.dc.DynamicCheckBox;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    DynamicCheckBox dynamicCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dynamicCheckBox = findViewById(R.id.dc);

        sample1();
    }

    private void sample1() {
        ArrayList<String> listString = new ArrayList<String>();
        listString.add("Satu");
        listString.add("Dua");
        listString.add("Tiga");
        listString.add("Empat");

        ArrayList<Integer> is = new ArrayList<Integer>();
        is.add(1);
        is.add(2);
        is.add(3);

        dynamicCheckBox
//                .setSelectedItem(1, 2, 3)
                .setSelectedItem(is)
                .setItemList(listString)
                .setOnCheckedChangeListener(new DynamicCheckBox.OnCheckedChangeListener<String>() {
                    @Override
                    public void onCheckedChanged(ArrayList<String> items) {
                        for (int i = 0; i < items.size(); i++) {
                            Log.d(TAG, "onCheckedChanged: " + items.get(i));
                        }
                    }

                    @Override
                    public void onCheckedShow(String clickedValue) {
                        Log.d(TAG, "onCheckedShow: " + clickedValue);
                    }
                });
    }
}