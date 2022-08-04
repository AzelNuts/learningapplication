package com.example.learningapp_forkids;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        Button get_started = findViewById(R.id.get_started);

        ImageView bearAnim = findViewById(R.id.bearAnim);

        Glide.with(this).load(R.drawable.bear).into(bearAnim);

        get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i1);
            }
        });
    }
}
