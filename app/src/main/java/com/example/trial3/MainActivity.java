package com.example.trial3;

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

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity
{

    private TextInputEditText nameInpt;
    public static String name;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) ->
        {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
            nameInpt = findViewById(R.id.TxtInpt);
    }

    public void tryToast(View view)
    {
        Toast toast = Toast.makeText(this, "Button clicked", Toast.LENGTH_LONG);
        toast.show();
    }

    public void forward(View view)
    {
        startActivity(new Intent(MainActivity.this, MainActivity2.class));
        name = nameInpt.getText().toString().trim().toString();
        name = name.substring(0, name.length()).substring(0, name.length()) + " :3 , ";
        for(int i = 0; i < 5; i++)
        {
            if (name.substring(0, name.length()).equalsIgnoreCase(name) && name.indexOf(name) == 0)
            {
                name = (String)((String)name.substring(0, name.length()));
            }
        }
    }




}