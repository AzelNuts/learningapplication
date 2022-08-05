package com.example.learningapp_forkids;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    String tabTitle[] = {"ABCD","Shape","Animals","Colors", "Fun"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();


        TabLayout tl = findViewById(R.id.tabLayout);
        ViewPager2 pager = findViewById(R.id.viewPager2);
        pager.setOffscreenPageLimit(6);

        pager.setAdapter(new MyAdapter(getSupportFragmentManager(),getLifecycle()));

        TabLayoutMediator tm = new TabLayoutMediator(tl,pager, true,
                (tab, position) -> {
                    tab.setText(tabTitle[position]);

                });
        tm.attach();
    }



}