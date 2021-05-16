package com.example.restaurant_app.Retrofit;

import com.example.restaurant_app.ForgotResult;
import com.example.restaurant_app.LoginResult;
import com.example.restaurant_app.Menu;
import com.example.restaurant_app.model.PendingOrder;
import com.example.restaurant_app.modeladmin.Getmanager;
import com.example.restaurant_app.modeladmin.Staffdetails;
import com.example.restaurant_app.modelmanager.Availableitem.Availableitem;
import com.example.restaurant_app.modelmanager.feedback.Avaragerating;
import com.example.restaurant_app.modelmanager.cookdetails.Cookdetails;
import com.example.restaurant_app.modelmanager.feedback.Feedbackdetails;
import com.example.restaurant_app.modelmanager.getingrediants.Getingredients;
import com.example.restaurant_app.modelmanager.getmenu.Menudetails;
import com.example.restaurant_app.modelmanager.Orderdetails;
import com.example.restaurant_app.modelmanager.showrevenuemodel.Sumrevenue;
import com.example.restaurant_app.modelmanager.waiterdetails.Waiterdetails;
import com.example.restaurant_app.modelmanager.booktable.BookTable;
import com.example.restaurant_app.modelmanager.managecomplain.Getcomplate;
import com.example.restaurant_app.modelmanager.setdiscount.Order;
import com.example.restaurant_app.modelmanager.showrevenuemodel.Showrevenue;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RetrofitInterface {

    //Admin Login
    @POST("/admin/login")
    Call<LoginResult> executeAdminLogin(@Body HashMap<String, String> map);

    //User register & login
    @PUT("/auth/register")
    Call<Void> executeRegister(@Body HashMap<String, String> map);

    @POST("/auth/login")
    Call<LoginResult> executeLogin(@Body HashMap<String, String> map);

    //Waiter register & login
    @PUT("/waiter/addwaiter")
    Call<Void> executeWaiterRegister(@Body HashMap<String, String> map);

    @POST("/waiter/login")
    Call<LoginResult> executeWaiterLogin(@Body HashMap<String, String> map);

    //Cook register
    @PUT("/cook/addcook")
    Call<Void> executeCookRegister(@Body HashMap<String, String> map);

    //cook login
    @POST("/cook/login")
    Call<LoginResult> executeCookLogin(@Body HashMap<String, String> map);

    //Manager register
    @PUT("/manage/addmanager")
    Call<Void> executeAddManagerRegister(@Body HashMap<String, String> map);

    //manager login
    @POST("/manage/login")
    Call<LoginResult> executeManagerLogin(@Body HashMap<String, String> map);

    //User Forgot password
    @POST("/auth/forgot")
    Call<ForgotResult> executeforgotpass(@Body HashMap<String, String> map);

    //Menu
    @GET("/feed/menu")
    Call<Menu> executeMenu(@Body HashMap<String, String> map);

    //view cook
    @GET("/cook/getcooks")
    Call<Cookdetails> Getcook();

    //view waiter
    @GET("/waiter/getwaiters")
    Call<Waiterdetails> Getwaiter();

    //view manager
    @GET("/manage/getmanagers")
    Call<Getmanager> Getmanager();

    //view order
    @GET("/order/getorders")
    Call<Orderdetails> Getorder();

    //view feedback
    @GET("/feedback/feedbacks")
    Call<Feedbackdetails> Getfeedback();

    //view avaragerating
    @GET("/feedback/average")
    Call<Avaragerating> Getavaragerating();

    //show menu
    @GET("/feed/getposts")
    Call<Menudetails> Getshowmenu();

    //item available
    @POST("/feed/getmenu")
    Call<Availableitem> GetitemAvailable();

    //show staff details
    @GET("/all/geteveryone")
    Call<Staffdetails> Getshowstaffdetails();

    //show complate
    @GET("/complaint/complaints")
    Call<Getcomplate> GetComplate();

    //view ingrediants
    @GET("/ingredient/getingredients")
    Call<Getingredients> Getingrediants();

    //view totalrevenue
    @GET("/revenue/sum")
    Call<Sumrevenue> GetTotalRevenue();

    //view showrevenue
    @POST("/revenue/year")
    Call<Showrevenue> showRevenue(@Body HashMap<String, String> map);

    //view set discount
    @PUT("/order/setdiscount/60813fc1bd08352ee06de526")
    Call<Order> setdiscount(@Body HashMap<String, String> map);

    //booktable
    @GET("/table/tables")
    Call<BookTable> showtable();

    //cook pending
    @PUT("/order/list")
    Call<PendingOrder> cookpending();

}
