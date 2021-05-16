package com.example.restaurant_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.restaurant_app.Retrofit.RetrofitClient;
import com.example.restaurant_app.Retrofit.RetrofitInterface;
import com.example.restaurant_app.model.Item;
import com.example.restaurant_app.model.List;
import com.example.restaurant_app.model.PendingOrder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Cook_Pending_Orderlist_Fragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
//    private int i;
//    GridView gridView;

    public Cook_Pending_Orderlist_Fragment() {

    }


    public static Cook_Pending_Orderlist_Fragment newInstance(String param1, String param2) {
        Cook_Pending_Orderlist_Fragment fragment = new Cook_Pending_Orderlist_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    PendingOrder pendingOrder = new PendingOrder();
    java.util.List<List> list = new ArrayList<>();
    java.util.List<Item> items = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        cookpendingorder();
    }

    private void cookpendingorder() {
        Retrofit retrofit = RetrofitClient.getInstance();
        RetrofitInterface retrofitInterface = retrofit.create(RetrofitInterface.class);

        Call<PendingOrder> call = retrofitInterface.cookpending();

        call.enqueue(new Callback<PendingOrder>() {
            @Override
            public void onResponse(Call<PendingOrder> call, Response<PendingOrder> response) {
                if (response.isSuccessful()){
//                    pendingOrder = response.body();
//                    list = pendingOrder.getList();
//                    items = list.get(i).getItems();
//
//                    CustomAdepter customAdepter = new CustomAdepter();


                    Toast.makeText(getContext(), "success cook", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getContext(), ""+response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PendingOrder> call, Throwable t) {
                Toast.makeText(getContext(), ""+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_cook__pending__orderlist_, container, false);
    }
}

//class CustomAdepter extends BaseAdapter{
//
//
//    @Override
//    public int getCount() {
//        return 0;
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return position;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        return convertView;
//    }
//}