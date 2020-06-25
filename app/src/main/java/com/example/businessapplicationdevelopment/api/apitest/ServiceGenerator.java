package com.example.businessapplicationdevelopment.api.apitest;


import android.app.AlertDialog;
import android.text.TextUtils;

import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.logging.HttpLoggingInterceptor.*;

public class ServiceGenerator {

    public static final String Base_URL = "https://www.ravelry.com/";
    public static final String Api_URL = "https://api.ravelry.com/";
    private static HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(Level.BODY);
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()

                    .baseUrl(Base_URL)

                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit.Builder builder2 =
            new Retrofit.Builder()

                    .baseUrl(Api_URL)

                    .addConverterFactory(GsonConverterFactory.create());
    private static Retrofit retrofit = builder.build();


    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(loggingInterceptor)) {
            httpClient.addInterceptor(loggingInterceptor);
            builder = builder.client(httpClient.build());
            retrofit = builder.build();
        }

        return createService(serviceClass, null);


    }

    public static <S> S createService(
            Class<S> serviceClass, String clientId, String clientSecret) {
        if (!httpClient.interceptors().contains(loggingInterceptor)) {
            httpClient.addInterceptor(loggingInterceptor);
            builder = builder.client(httpClient.build());
            retrofit = builder.build();
        }
        if (!TextUtils.isEmpty(clientId)
                && !TextUtils.isEmpty(clientSecret)) {
            String authToken = Credentials.basic(clientId, clientSecret);
            return createService(serviceClass, authToken);
        }

        return createService(serviceClass, null, null);
    }

    public static <S> S createService(
            Class<S> serviceClass, final String authToken) {
        if (!httpClient.interceptors().contains(loggingInterceptor)) {
            httpClient.addInterceptor(loggingInterceptor);
            builder = builder.client(httpClient.build());
            retrofit = builder.build();
        }
        if (!TextUtils.isEmpty(authToken)) {
            AuthenticationInterceptor interceptor =
                    new AuthenticationInterceptor(authToken);

            if (!httpClient.interceptors().contains(interceptor)) {
                httpClient.addInterceptor(interceptor);

                builder.client(httpClient.build());
                retrofit = builder.build();
            }
        }


        return retrofit.create(serviceClass);
    }
}

