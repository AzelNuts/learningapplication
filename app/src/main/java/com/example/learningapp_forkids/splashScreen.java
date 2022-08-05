package com.example.learningapp_forkids;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash_screen);

        getSupportActionBar().hide();

        Button get_started = findViewById(R.id.get_started);
        Button toASL = findViewById(R.id.asl);

        ImageView bearAnim = findViewById(R.id.bearAnim);

        Glide.with(this).load(R.drawable.bear).into(bearAnim);

        get_started.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(getBaseContext(),MainActivity.class);
                startActivity(i1);
            }
        });

        toASL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mIntent = getPackageManager().getLaunchIntentForPackage("com.example.sign_lang_ml");
                if (mIntent != null) {
                    try {
                        startActivity(mIntent);
                    } catch (ActivityNotFoundException err) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "App is not found", Toast.LENGTH_SHORT);
                        t.show();
                    }
                }
            }
        });
    }
}
