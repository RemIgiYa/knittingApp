package com.example.businessapplicationdevelopment.api.apitest;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public class TokenAuthenticator implements Authenticator {

    private final AccessToken accessTokens;

    public TokenAuthenticator(AccessToken accessTokens) {
        this.accessTokens = accessTokens;
    }


    @Nullable
    @Override
    public Request authenticate(Route route, Response response) {
        final String accessToken = accessTokens.getAccessToken();
        if (!isRequestWithAccessToken(response) || accessToken == null) {
            return null;
        }
        synchronized (this) {
            final String newToken = accessTokens.getAccessToken();
            if (!accessToken.equals(newToken)) {
                return newRequestWithAccessToken(response.request(), newToken);
            }
            final String updatedToken = accessTokens.getRefreshToken();
            return newRequestWithAccessToken(response.request(), updatedToken);

        }
    }


    private Request newRequestWithAccessToken(Request request, String accessToken) {
        return request.newBuilder().header("Authorization", "Bearer " + accessToken).build();
    }

    private boolean isRequestWithAccessToken(@NonNull Response response) {
        String header = response.request().header("Authorization");
        return header != null && header.startsWith("Bearer");
    }
}
