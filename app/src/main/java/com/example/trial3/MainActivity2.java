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

public class MainActivity2 extends AppCompatActivity
{
    private TextView act2Title;
    private TextInputEditText ratingInpt;
    private TextView ratingTV;
    private ImageView catImg;
    private ProgressBar progress;
    private int[] imgList = {R.drawable.cute, R.drawable.mello, R.drawable.mocha, R.drawable.po, R.drawable.sema };
    public static int[] ratings = new int[5];
    private int index = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //A special greeting for Ms. Rioux//
        act2Title = findViewById(R.id.textView1);
        if(name.contains("Rioux")){
            act2Title.setText("Hello " + name + "!!! " + act2Title.getText());
        }
            else
            {
            act2Title.setText("Hello " + name + act2Title.getText());
            }
        //assign the elements to a variable//
        ratingTV = findViewById(R.id.textView);
        catImg = findViewById(R.id.imageView2);
        progress = findViewById(R.id.progressBar);
        catImg.setImageResource(imgList[0]);
        ratingInpt = findViewById(R.id.inpt2);
        check();
    } //end of onCreate method/


//button methods//
    //return to previous page//
    public void back(View view)
    {
        startActivity(new Intent(MainActivity2.this, MainActivity.class));
    } //end of back method//

    //go to next page//
    public void next(View view)
    {
        startActivity(new Intent(MainActivity2.this, MainActivity3.class));
    } //end of next method//

    //Checks and changes the color of the rating text box background depending on the current rating//
    public void check() {
        if (ratings[index] >= 7)
        {
            ratingTV.setBackgroundColor(Color.parseColor("#71e3aa"));
        }
            else if (ratings[index] < 5)
            {
                ratingTV.setBackgroundColor(Color.parseColor("#ed5c9e"));
            }
            else
            {
            ratingTV.setBackgroundColor(Color.TRANSPARENT);
            }
    } //end of check method//

    //Takes the information in the rating text input (as type Editable)
    //Turns the editable to a String then an int to be added to the ratings list
    public void submitRating(View view)
    {
        ratings[index] = Integer.parseInt(ratingInpt.getText().toString());
        check();
    } //end of submitRating method//

    //goes to previous image, making sure to display the corresponding rating
    // and update the progress bar
    public void backImg(View view)
    {
        if(index != 0)
        {
            index--;
            catImg.setImageResource(imgList[index]);
            ratingInpt.setText(ratings[index] + "");
            progress.setProgress(progress.getProgress()-1);
        }
    } //end of backImg rating//

    //goes to next image, making sure to display the corresponding rating
    // and update the progress bar
    public void nextImg(View view)
    {
        if(index != imgList.length-1)
        {
            index++;
            catImg.setImageResource(imgList[index]);
            ratingInpt.setText(ratings[index] + "");
            progress.setProgress(progress.getProgress()+1);
        }
    } //end of nextImg method//
} //end of MainActivity2 class//