package com.example.learningapp_forkids;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    String tabTitle[] = {"ABCD","Shape","Colors","Animal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        TabLayout tl = findViewById(R.id.tabLayout);
        ViewPager2 pager = findViewById(R.id.viewPager2);
        pager.setOffscreenPageLimit(5);

        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),getLifecycle()));

        TabLayoutMediator tm = new TabLayoutMediator(tl,pager, true,
                (tab, position) -> {
                    tab.setText(tabTitle[position]);

                });
        tm.attach();
    }



}