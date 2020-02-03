package com.example.library.Retrofit;


import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by aditya
 */

public interface INodeJs {
    @POST("register")
    @FormUrlEncoded
    Observable<String> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("id") String id,
            @Field("mobile") String mobile,
            @Field("password") String password);


    @POST("login")
    @FormUrlEncoded
    Observable<String> loginUser(
            @Field("email") String email,
            @Field("password") String password);

    @POST("forgot")
    @FormUrlEncoded
    Observable<String> forgot(
            @Field("name") String name,
            @Field("email") String email,
            @Field("mobile") String mobile);


    @POST("books")
    @FormUrlEncoded
    Observable<String> books(
            @Field("val") String val
    );


}
