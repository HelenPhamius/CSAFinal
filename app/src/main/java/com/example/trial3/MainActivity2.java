package com.example.trial3;

import static com.example.trial3.MainActivity.name;

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

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    private TextView act2Title;
    private TextInputEditText ratingInpt;
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
        act2Title = findViewById(R.id.textView1);
        act2Title.setText("Hello " + name + act2Title.getText());
        ratingTV = findViewById(R.id.textView);
        catImg = findViewById(R.id.imageView2);
        progress = findViewById(R.id.progressBar);
        catImg.setImageResource(imgList[0]);
        ratingInpt = findViewById(R.id.inpt2);
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


    public void submitRating(View view){
        ratings[0] = Integer.parseInt(ratingInpt.getText().toString());
    }
    public void backImg(View view){
        if(index != 0){
            index--;
            catImg.setImageResource(imgList[index]);
            ratingInpt.setText(ratings[index]);
            progress.setProgress(progress.getProgress()-1);
        }
    }

    public void nextImg(View view){
        if(index != imgList.length-1){
            index++;
            catImg.setImageResource(imgList[index]);
            ratingInpt.setText(ratings[index]);
            progress.setProgress(progress.getProgress()+1);
        }
    }
}