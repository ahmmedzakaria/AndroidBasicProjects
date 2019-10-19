package com.example.retrofitstart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.retrofitstart.recyclerview.MyAdapter;

import java.util.Arrays;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private GitHubRepoAdapter adapter;
    List<GitHubRepo> gitHubRepoList;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        context=this;
        //listView = (ListView) findViewById(R.id.listView);


        String API_BASE_URL = "https://api.github.com/";



        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .baseUrl(API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create()
                        );

        Retrofit retrofit =
                builder
                        .client(
                                httpClient.build()
                        )
                        .build();

        //GitHubClient client =  retrofit.create(GitHubClient.class);
        // Create a very simple REST adapter which points the GitHub API endpoint.
        GitHubClient client =  retrofit.create(GitHubClient.class);

// Fetch a list of the Github repositories.
        Call<List<GitHubRepo>> call =
                client.reposForUser("ahmmedzakaria");

// Execute the call asynchronously. Get a positive or negative callback.
        call.enqueue(new Callback<List<GitHubRepo>>() {
            @Override
            public void onResponse(Call<List<GitHubRepo>> call, Response<List<GitHubRepo>> response) {
                // The network call was a success and we got a response
                // TODO: use the repository list and display it
               gitHubRepoList = response.body();
                Toast.makeText(MainActivity.this, "Size: "+gitHubRepoList.size(), Toast.LENGTH_SHORT).show();

//                adapter = new GitHubRepoAdapter(MainActivity.this, gitHubRepoList);
//                listView.setAdapter(adapter);
                mAdapter = new MyAdapter(gitHubRepoList,context);

                recyclerView.setAdapter(mAdapter);
                recyclerView.setHasFixedSize(true);
            }

            @Override
            public void onFailure(Call<List<GitHubRepo>> call, Throwable t) {
                // the network call was a failure
                // TODO: handle error
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        });

//        gitHubRepoList = Arrays.asList(new GitHubRepo("Java"),
//                new GitHubRepo("JavaScript"));




    }
}
