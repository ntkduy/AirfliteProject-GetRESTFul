package com.ntkduy1604.airfliteproject_getrestful;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the View that shows the numbers category & Set a click listener on that View
        TextView numbers = (TextView) findViewById(R.id.meal_type_01);
        numbers.setOnClickListener(new View.OnClickListener(){
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                String message = "Open the list of " + getString(R.string.category_device_list);
                Toast.makeText(view.getContext(),message, Toast.LENGTH_SHORT).show();
                Intent numbersIntent = new Intent(MainActivity.this, GetRest.class);
                startActivity(numbersIntent);
            }
        });
    }
}
