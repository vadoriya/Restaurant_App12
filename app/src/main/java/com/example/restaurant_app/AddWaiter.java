package com.example.restaurant_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant_app.Retrofit.RetrofitClient;
import com.example.restaurant_app.Retrofit.RetrofitInterface;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddWaiter extends AppCompatActivity {
    ImageView logo_image;
    EditText name, phone, email, password;
    Button register;
    private Button backbtn;
    RetrofitInterface retrofitInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_waiter);

        Retrofit retrofitClient = RetrofitClient.getInstance();
        retrofitInterface = retrofitClient.create(RetrofitInterface.class);

        backbtn = (Button) findViewById(R.id.btnback);
        logo_image = (ImageView) findViewById(R.id.logo_image);
        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        register = (Button) findViewById(R.id.register_btn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(AddWaiter.this, "Please Enter Name", Toast.LENGTH_SHORT).show();
                }
                if (phone.getText().toString().isEmpty()) {
                    Toast.makeText(AddWaiter.this, "Please Enter Phone number", Toast.LENGTH_SHORT).show();
                }
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(AddWaiter.this, "Please Enter Email", Toast.LENGTH_SHORT).show();
                }
                if (password.getText().toString().isEmpty()) {
                    Toast.makeText(AddWaiter.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }


                HashMap<String, String> map = new HashMap<>();

                map.put("name", name.getText().toString());
                map.put("email", email.getText().toString());
                map.put("password", password.getText().toString());
                map.put("phone", phone.getText().toString());

                Call<Void> call = retrofitInterface.executeWaiterRegister(map);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {

                        if (response.code() == 200) {
                            Toast.makeText(AddWaiter.this,
                                    "Signed up successfully", Toast.LENGTH_LONG).show();

                            startActivity(new Intent(AddWaiter.this, UserLogin.class));
                        } else if (response.code() == 401) {
                            Toast.makeText(AddWaiter.this,
                                    "Already registered", Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(AddWaiter.this, "Please! Check Network of Your Device",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddWaiter.this, ManagerHome.class);
                startActivity(intent);
            }
        });
    }
}