package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.businessapplicationdevelopment.api.AccessToken;
import com.example.businessapplicationdevelopment.api.PatternActivity;
import com.example.businessapplicationdevelopment.api.RaverlyClient;
import com.example.businessapplicationdevelopment.api.RaverlyProjectAdapter;
import com.example.businessapplicationdevelopment.api.RaverlyProjects;
import com.example.businessapplicationdevelopment.api.ServiceGenerator;
import com.example.businessapplicationdevelopment.api.VolumeAdapter;
import com.example.businessapplicationdevelopment.api.volumes.LibraryPatterns;
import com.example.businessapplicationdevelopment.api.volumes.Volume;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.net.Uri.parse;

public class Ravelry_Screen extends AppCompatActivity {
    private ListView listView;
    private String clientId = "bc0689bbeb69e1e567c7d6e37f7fd80c";
    private String clientSecret = "f_mPxFRqLBjC2TS08V9C7PNxliSTxzOYpJ3MOwJY";
    private String redirectUrl = "com.example.businessapplicationdevelopment://callback";
    private EditText rUsername;
    private String mUser;
    // RaverlyProjects raverlyProjects = new RaverlyProjects();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {

            setTheme(R.style.darkTheme);
        } else {
            setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ravelry__screen);
        listView = findViewById(R.id.raverlyList);
        rUsername = findViewById(R.id.raverly_username);
        final SharedPreferences users = this.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
        Button loginButton = (Button) findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUser = rUsername.getText().toString();
                Log.d("meow", "we got user" + mUser);
                users.edit().putString("raverly.user", mUser).apply();
                Intent intent = new Intent(Intent.ACTION_VIEW, parse(ServiceGenerator.Base_URL + "oauth2/auth" + "?response_type=code" + "&client_id=" + clientId + "&redirect_uri=" + redirectUrl + "&state=themeows" + "&scope=offline+library-pdf"));
                startActivity(intent);


            }

        });
    }
    @Override
    protected void onResume() {
        super.onResume();


        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(redirectUrl)) {
            final String code = uri.getQueryParameter("code");
            if (code != null) {

                final SharedPreferences prefs = this.getSharedPreferences(
                        BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

                RaverlyClient client = ServiceGenerator.createService(RaverlyClient.class, clientId, clientSecret);
                Call<AccessToken> call = client.getNewAccessToken(code, "authorization_code",
                        redirectUrl
                );
                call.enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {

                        // String oneToken = response.body().getAccessToken();
                        int statusCode = response.code();
                        if (statusCode == 200) {
                            AccessToken token = response.body();
                            prefs.edit().putBoolean("oauth.loggedin", true).apply();
                            prefs.edit().putString("oauth.accesstoken", token.getAccessToken()).apply();
                            prefs.edit().putString("oauth.refreshtoken", token.getRefreshToken()).apply();
                            prefs.edit().putString("oauth.tokentype", token.getTokenType()).apply();


                            Log.d("Yay", " got the token");


                        } else {

                            Toast.makeText(Ravelry_Screen.this, "Token didnt save. Here's the code: " + statusCode, Toast.LENGTH_SHORT).show();


                        }
                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable t) {

                        Log.d("Aww", " didnt get the token");

                    }
                });
            } else {

                Toast.makeText(Ravelry_Screen.this, " The redirect link isnt working properly", Toast.LENGTH_SHORT).show();


            }
            RaverlyClient client;

            final SharedPreferences prefs = this.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
            final SharedPreferences users = this.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);
            final AccessToken token = new AccessToken();
            token.setAccessToken(prefs.getString("oauth.accesstoken", ""));
            token.setRefreshToken(prefs.getString("oauth.refreshtoken", ""));
            token.setTokenType(prefs.getString("oauth.tokentype", ""));
            token.setClientId(clientId);
            token.setClientSecret(clientSecret);
            String aUser = users.getString("raverly.user", "");
            Log.d("meow", "we retrieved" + aUser);

            client = ServiceGenerator.createService(RaverlyClient.class, token, this);
            Call<LibraryPatterns> raverlyDetail = client.libraryVolumes(aUser);
            raverlyDetail.enqueue(new Callback<LibraryPatterns>() {
                @Override
                public void onResponse(Call<LibraryPatterns> call, Response<LibraryPatterns> response) {
                    if (response.isSuccessful()) {

                        Log.d("Yay", " yay!! it worked");
                        ArrayList library_array = new ArrayList<>(response.body().getVolumes());


                        ArrayList values1 = library_array;

                        String authorName = "";
                        Integer volumeId = 0;


                        for (int i = 0; i < values1.size(); i++) {
                            final Volume item = (Volume) values1.get(i);
                            authorName = item.getAuthorName();
                            volumeId = item.getId();

                            if (library_array.isEmpty()) {
                                Toast.makeText(Ravelry_Screen.this, "You dont have any downloadable patterns", Toast.LENGTH_SHORT).show();
                            } else {

                                listView.setAdapter(new VolumeAdapter(Ravelry_Screen.this, values1));

                                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                    @Override
                                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {


                                        Integer patternVolume = ((Volume) listView.getItemAtPosition(position)).getId();
                                        String tokens = token.accessToken;
                                        Log.d("Pattern id", String.valueOf(patternVolume));
                                        Intent viewPattern = new Intent(getApplicationContext(), PatternActivity.class);
                                        viewPattern.putExtra("heres_token", tokens);
                                        viewPattern.putExtra("pattern_file", patternVolume);

                                        startActivity(viewPattern);

                                    }
                                });


                            }
                        }


                    } else {
                        Toast.makeText(Ravelry_Screen.this, "Probably not", Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<LibraryPatterns> call, Throwable t) {
                    Toast.makeText(Ravelry_Screen.this, " error :(", Toast.LENGTH_SHORT).show();


                }

            });

        }


    }


}
