package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Cook_Chienese extends AppCompatActivity {
    Button backbutn;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabItem pending,progress;
    public PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cook_chienese);

        backbutn = (Button)findViewById(R.id.btnback);

        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        pending = (TabItem)findViewById(R.id.pendingtab);
        progress = (TabItem)findViewById(R.id.progresstab);
        viewPager = findViewById(R.id.viewpager);

        pagerAdapter = new com.example.restaurant_app.PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if (tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                else if (tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
//                else if (tab.getPosition() == 2){
//                    pagerAdapter.notifyDataSetChanged();
//                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        backbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cook_Chienese.this,CookHome.class);
                startActivity(intent);

            }
        });
    }
}