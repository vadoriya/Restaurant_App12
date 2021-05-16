package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_home);


    drawer = findViewById(R.id.waiter_drawer);
        navigationView = findViewById(R.id.navigation);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawer.closeDrawer(GravityCompat.START);
                switch (item.getItemId()) {
                    case R.id.home:
                        break;

                    case R.id.tablelist:
                        Intent tlist = new Intent(Waiter_Home.this, Waiter_Tablelist.class);
                        startActivity(tlist);
                        break;
                    case R.id.takeorder:
                        Intent takeorder = new Intent(Waiter_Home.this, Waiter_Takeorder.class);
                        startActivity(takeorder);
                        break;
                    case R.id.tablewiseorderlist:
                        Intent twiseorderlist = new Intent(Waiter_Home.this, Waiter_Tablewise_Orderlist.class);
                        startActivity(twiseorderlist);
                        break;

                    case R.id.changesinorderlist:
                        Intent changeorder = new Intent(Waiter_Home.this, Waiter_Change_Orderlist.class);
                        startActivity(changeorder);
                        break;

                    case R.id.sendoredrtocook:
                        Intent sendorder = new Intent(Waiter_Home.this, Waiter_Sent_Orderlist.class);
                        startActivity(sendorder);
                        break;

                    case R.id.readytoserveorderlist:
                        Intent readyorder = new Intent(Waiter_Home.this, Waiter_Ready_Orderlist.class);
                        startActivity(readyorder);
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
