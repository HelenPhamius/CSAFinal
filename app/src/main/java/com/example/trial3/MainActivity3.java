package com.example.trial3;

import static com.example.trial3.MainActivity2.ratings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity
{
    private TextView avgRating;
    private TextView hiRating;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //to find the average rating//
        avgRating = findViewById(R.id.textView3);
        int avg = 0;
        for(String i : ratings)
        {
            avg += Integer.parseInt(i);
        }
        avg /= ratings.length;
        avgRating.setText(avgRating.getText() + "" + avg + "/10");

        //traverses ratings list to find the max (the highest rating)
        hiRating = findViewById(R.id.textView4);
        String high = ratings[0];
        for(int i = 1; i < ratings.length; i++)
        {
            if(Integer.parseInt(high) < Integer.parseInt(ratings[i]))
            {
                high = ratings[i];
            }
        }
        hiRating.setText(hiRating.getText() + " " + high + "/10");


    } //end of onCreate method//

    //takes the user to the home page//
    public void home(View view)
    {
        startActivity(new Intent(MainActivity3.this, MainActivity.class));
    } //end of home method//

    //goes to the previous page
    public void backFrom3(View view)
    {
        startActivity(new Intent(MainActivity3.this, MainActivity2.class));
    } //end of backFrom3 method//
} //end of MainActivity3 class//