package com.example.businessapplicationdevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.businessapplicationdevelopment.api.apitest.AccessToken;
import com.example.businessapplicationdevelopment.api.apitest.RaverlyClient;
import com.example.businessapplicationdevelopment.api.apitest.RaverlyProjectAdapter;
import com.example.businessapplicationdevelopment.api.apitest.RaverlyProjects;
import com.example.businessapplicationdevelopment.api.apitest.ServiceGenerator;

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
    RaverlyProjects raverlyProjects = new RaverlyProjects();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES){

            setTheme(R.style.darkTheme);
        }
        else{ setTheme(R.style.AppTheme);}

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ravelry__screen);
        listView = findViewById(R.id.raverlyList);
        Button loginButton = (Button) findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, parse(ServiceGenerator.Base_URL + "oauth2/auth" + "?response_type=code" + "&client_id=" + clientId + "&redirect_uri=" + redirectUrl + "&state=themeows" + "&scope=offline"));
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

            // get access token
            RaverlyClient client = ServiceGenerator.createService(RaverlyClient.class, clientId, clientSecret);


            Call<AccessToken> accessTokenCall =
                    client.getAccessToken(code, "authorization_code", redirectUrl);

            accessTokenCall.enqueue(new Callback<AccessToken>() {
                @Override
                public void onResponse(Call<AccessToken> accessTokenCall, Response<AccessToken> accessTokenResponse) {

                    Toast.makeText(Ravelry_Screen.this, " yay got the token", Toast.LENGTH_SHORT).show();

                    if (accessTokenResponse.body() == null) {
                        Toast.makeText(Ravelry_Screen.this, " I didnt get a token!", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        String oneToken = accessTokenResponse.body().getAccessToken();

                        requestData(oneToken);
                        System.out.println("testing this again");
                    }


                }

                @Override
                public void onFailure(Call<AccessToken> call, Throwable t) {
                    Toast.makeText(Ravelry_Screen.this, " aww didnt get the token", Toast.LENGTH_SHORT).show();
                }
            });



        }




    }
    private void requestData(String oneToken) {

        RaverlyClient raverlyClient = ServiceGenerator.createService(RaverlyClient.class, " Bearer" + " " + oneToken);
        Call<RaverlyProjects> raverlyProjectCall = raverlyClient.projectsForUser("theyarnturtle");
        raverlyProjectCall.enqueue(new Callback<RaverlyProjects>() {
            @Override
            public void onResponse(Call<RaverlyProjects> call, Response<RaverlyProjects> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Ravelry_Screen.this, "yay!! it worked", Toast.LENGTH_SHORT).show();
                    if (response.body() == null) {
                        Toast.makeText(Ravelry_Screen.this, " No response here, bud", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        ArrayList project_array = new ArrayList<>(response.body().getProjects());
                        listView.setAdapter(new RaverlyProjectAdapter(Ravelry_Screen.this, project_array));
                    }

                }
                else{
                    Toast.makeText(Ravelry_Screen.this, "Probably not", Toast.LENGTH_SHORT).show();

                }
            }

            @Override
            public void onFailure(Call<RaverlyProjects> call, Throwable t) {
                Toast.makeText(Ravelry_Screen.this, " error :(", Toast.LENGTH_SHORT).show();


            }

        });

    }
}
