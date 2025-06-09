package com.example.trial3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {
    private TextView ratingTV;
    private ImageView catImg;
    private int[] imgList = {R.drawable.cute, R.drawable.mello, R.drawable.mocha, R.drawable.po, R.drawable.sema };
    private int rate = 0;
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

        catImg.setImageResource(imgList[0]);
    }

    public void back(View view){
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
    }

    public void next(View view){
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
    }

    public void decRating(View view){
        rate--;
        ratingTV.setText(rate + "/10");
    }

    public void incRating(View view){
        rate++;
        ratingTV.setText(rate + "/10");
    }

    public void backImg(View view){
        index--;
        catImg.setImageResource(imgList[index]);
    }

    public void nextImg(View view){
        index++;
        catImg.setImageResource(imgList[index]);
    }
}