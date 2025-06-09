package com.example.trial3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView ratingTV;
    private ImageView catImg;
    private ProgressBar progress;
    private int[] imgList = {R.drawable.cute, R.drawable.mello, R.drawable.mocha, R.drawable.po, R.drawable.sema };
    public static int[] ratings = new int[5];
    private int index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ratingTV = findViewById(R.id.textView);
        catImg = findViewById(R.id.imageView2);
        progress = findViewById(R.id.progressBar);
        catImg.setImageResource(imgList[0]);
        check();
    }

    public void back(View view){
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
    }

    public void next(View view){
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
    }
    public void check() {
        if (ratings[index] >= 7) {
            ratingTV.setBackgroundColor(Color.parseColor("#71e3aa"));
        } else if (ratings[index] < 5) {
            ratingTV.setBackgroundColor(Color.parseColor("#ed5c9e"));
        }
            else{
            ratingTV.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    public void decRating(View view){
        ratings[index]--;
        ratingTV.setText(ratings[index] + "/10");
        check();
    }


    public void incRating(View view){
        ratings[index]++;
        ratingTV.setText(ratings[index] + "/10");
        ratingTV.setBackgroundColor(Color.parseColor("#71e3aa"));
        check();
    }

    public void backImg(View view){
        if(index != 0){
            index--;
            catImg.setImageResource(imgList[index]);
            progress.setProgress(progress.getProgress()-1);
        }
    }

    public void nextImg(View view){
        if(index != imgList.length-1){
            index++;
            catImg.setImageResource(imgList[index]);
            ratingTV.setText(ratings[index] + "/10");
            progress.setProgress(progress.getProgress()+1);
        }
    }
}