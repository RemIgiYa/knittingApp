package com.example.businessapplicationdevelopment.api;


import com.example.businessapplicationdevelopment.api.volumes.LibraryPatterns;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("oauth2/token")
    Call<AccessToken> getNewAccessToken(
            @Field("code") String code,
            @Field("grant_type") String grantType,
            @Field("redirect_uri") String redirect_url);

            /*@Field("code") String code,
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("redirect_uri") String redirect_url,
            @Field("grant_type") String grantType);*/

    @Headers("Accept: application/json")
    @FormUrlEncoded
    @POST("oauth2/token")
    Call<AccessToken> getRefreshAccessToken(

            @Field("refresh_token") String refreshToken,
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("redirect_uri") String redirect_url,
            @Field("grant_type") String grantType);

    @GET("https://api.ravelry.com/current_user.json")
        //Call<List<RaverlyRepo>> projectsForUser(@Path("username") String user);
        //@Headers("Authorization: ")
    Call<List<RaverlyRepo>> userInfo();

    //@Headers("Accept: application/json")
    @GET("https://api.ravelry.com/projects/{username}/list.json")
    //Call<List<RaverlyRepo>> projectsForUser(@Path("username") String user);
    //@Headers("Authorization: ")
    Call<RaverlyProjects> projectsForUser(@Path("username") String user);


    @Headers("Accept: application/json")
    //@FormUrlEncoded
    @POST("https://api.ravelry.com/product_attachments/{id}/generate_download_link.json")
    Call<ProductLink> getPatternLink(@Path("id") Integer id);

    @GET("https://api.ravelry.com/people/{username}/library/search.json?type=pdf")
    Call<LibraryPatterns> libraryVolumes(@Path("username") String user);

    @GET("https://api.ravelry.com/volumes/{id}.json")
    Call<VolumeDetails> volumeDetail(@Path("id") Integer id);


}
