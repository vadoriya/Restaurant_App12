package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Waiter_Tablewise_Orderlist extends AppCompatActivity {
    Button backbutn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_tablwise_orderlist);

        backbutn = (Button)findViewById(R.id.btnback);
        backbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Waiter_Tablewise_Orderlist.this, Waiter_Home.class);
                startActivity(intent);
            }
        });
    }
}
