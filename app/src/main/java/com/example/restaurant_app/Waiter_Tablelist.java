package com.example.restaurant_app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurant_app.Retrofit.RetrofitClient;
import com.example.restaurant_app.Retrofit.RetrofitInterface;
import com.example.restaurant_app.modelmanager.booktable.BookTable;
import com.example.restaurant_app.modelmanager.booktable.Table;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Waiter_Tablelist extends AppCompatActivity {

    GridView gridView;

    BookTable bookTable = new BookTable();
    List<Table> tables = new ArrayList<>();
    Button backbutn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_tablelist);

        gridView = (GridView)findViewById(R.id.gridview);
        backbutn = (Button)findViewById(R.id.btnback);

        tablelist();
        backbutn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Waiter_Tablelist.this, Waiter_Home.class);
                startActivity(intent);
            }
        });
    }

    private void tablelist() {

        Retrofit retrofit = RetrofitClient.getInstance();
        RetrofitInterface retrofitInterface= retrofit.create(RetrofitInterface.class);

        Call<BookTable> call = retrofitInterface.showtable();
        call.enqueue(new Callback<BookTable>() {
            @Override
            public void onResponse(Call<BookTable> call, Response<BookTable> response) {
                if (response.isSuccessful()){

                    bookTable = response.body();
                    tables = bookTable.getTables();


                    CustomAdepter customAdepter = new CustomAdepter(Waiter_Tablelist.this,tables);
                    gridView.setAdapter(customAdepter);

                    Toast.makeText(Waiter_Tablelist.this, "Tablelist", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Waiter_Tablelist.this, ""+response.message(), Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<BookTable> call, Throwable t) {
                Toast.makeText(Waiter_Tablelist.this, "Failed", Toast.LENGTH_SHORT).show();

            }
        });
    }

    class CustomAdepter extends BaseAdapter {

        List<Table> tables;
        Context context;



        public CustomAdepter(Waiter_Tablelist waiter_tablelist, List<Table> tables) {
            this.context = waiter_tablelist;
            this.tables = tables;
        }

        @Override
        public int getCount() {
            return   tables.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.booktablelayout,viewGroup,false);
                LayoutInflater lInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
                view = lInflater.inflate(R.layout.booktablelayout, null);
            }

            TextView tid = view.findViewById(R.id.tid);
            TextView ttable = view.findViewById(R.id.ttable);
            TextView tsize = view.findViewById(R.id.tsize);
            TextView tstatus = view.findViewById(R.id.tstatus);
            // TextView twaiting = view.findViewById(R.id.twaiting);

            tid.setText(tables.get(i).getId());
            ttable.setText(tables.get(i).getTable().toString());
            tsize.setText(tables.get(i).getSize().toString());
            tstatus.setText(tables.get(i).getStatus());
            //  twaiting.setText(tables.get(i).getWaiting());


            return view;
        }
    }
}

