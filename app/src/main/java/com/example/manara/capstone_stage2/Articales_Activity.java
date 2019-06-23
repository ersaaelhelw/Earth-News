package com.example.manara.capstone_stage2;

import android.os.AsyncTask;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class Articales_Activity extends AppCompatActivity {

    ArrayList<Articales> articalesArrayList = new ArrayList<>();

    Articles_Fragment article_fragment = new Articles_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articales_);
        //noinspection deprecation
        final TabLayout table = findViewById(R.id.tabLayout);

        TabItem articles_fargment = findViewById(R.id.articles);
        TabItem favorite_fargment = findViewById(R.id.favorite);
        final ViewPager viewPager = findViewById(R.id.viewpager);
        PageAdapter pageAdapter = new PageAdapter(getSupportFragmentManager(), table.getTabCount());
        viewPager.setAdapter(pageAdapter);
        table.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 0) {
                    table.setBackgroundColor(ContextCompat.getColor(Articales_Activity.this, R.color.colorPrimary));


                } else {
                    table.setBackgroundColor(ContextCompat.getColor(Articales_Activity.this, R.color.colorPrimary));

                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        table.setupWithViewPager(viewPager);

    }

}

