package com.olimipioscompany.retrofitgithubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.olimipioscompany.retrofitgithubapi.R;
import com.olimipioscompany.retrofitgithubapi.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        //Retrofit builder with baseurl and gson converter
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create());

        //Inicialize builder
        Retrofit retrofit = builder.build();

        //Create client
        GitHubClient client = retrofit.create(GitHubClient.class);

        //Call get method
        Call<List<GitHubRepo>> call = client.reposForUser("asafeolimpio");

        /**
         * Retrofit call
         */
        call.enqueue(new Callback<List<GitHubRepo>>() {

            /**
             * On call response manage actions
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                List<GitHubRepo> repos = response.body();

                listView.setAdapter(new GitHubRepoAdapter(MainActivity.this, repos));
            }

            /**
             * On call faliure handle errors
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
