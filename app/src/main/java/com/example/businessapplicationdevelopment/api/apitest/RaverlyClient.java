package com.example.businessapplicationdevelopment.api.apitest;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface RaverlyClient {


    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("oauth2/token")
    Call<AccessToken> getAccessToken(

            @Field("code") String code,
            @Field("grant_type") String grantType,
            @Field("redirect_uri") String redirect_url);


    @GET("https://api.ravelry.com/current_user.json")
        //Call<List<RaverlyRepo>> projectsForUser(@Path("username") String user);
        //@Headers("Authorization: ")
    Call<List<RaverlyRepo>> userInfo();

    //@Headers("Accept: application/json")
    @GET("https://api.ravelry.com/projects/{username}/list.json")
    //Call<List<RaverlyRepo>> projectsForUser(@Path("username") String user);
    //@Headers("Authorization: ")
    Call<RaverlyProjects> projectsForUser(@Path("username") String user);


}
