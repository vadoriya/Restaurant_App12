package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Waiter_Home extends AppCompatActivity {
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActionBarDrawerToggle toggle;

    Button tablelist,takeorder,tablwiseorderlist,changesinorder,sendordertokichen,readyorder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_home);

        tablelist = (Button)findViewById(R.id.tablelist);
        takeorder = (Button)findViewById(R.id.takeorder);
        tablwiseorderlist = (Button)findViewById(R.id.tablewiseorderlist);
        changesinorder = (Button)findViewById(R.id.changesinorder);
        sendordertokichen = (Button)findViewById(R.id.sendordertocook);
        readyorder = (Button)findViewById(R.id.redyorderlist);


        drawer = findViewById(R.id.waiter_drawer);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        tablelist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tablelist = new Intent(Waiter_Home.this, Waiter_Tablelist.class);
                startActivity(tablelist);

            }
        });

        takeorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takeorder = new Intent(Waiter_Home.this, Waiter_Takeorder.class);
                startActivity(takeorder);
            }
        });

        changesinorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent changeinorder = new Intent(Waiter_Home.this, Waiter_Change_Orderlist.class);
                startActivity(changeinorder);
            }
        });

        tablwiseorderlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tabwiseorderlist = new Intent(Waiter_Home.this, Waiter_Tablewise_Orderlist.class);
                startActivity(tabwiseorderlist);
            }
        });

        sendordertokichen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendordertokichen = new Intent(Waiter_Home.this, Waiter_Sent_Orderlist.class);
                startActivity(sendordertokichen);
            }
        });

        readyorder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent readyorder = new Intent(Waiter_Home.this, Waiter_Ready_Orderlist.class);
                startActivity(readyorder);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.home:
                        break;

                    case R.id.complain:
                        Intent complain = new Intent(Waiter_Home.this, Waiter_Complainlist.class);
                        startActivity(complain);
                        break;

                    case R.id.logout:
                        Intent logout = new Intent(Waiter_Home.this,  MainActivity.class);
                        startActivity(logout);
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
