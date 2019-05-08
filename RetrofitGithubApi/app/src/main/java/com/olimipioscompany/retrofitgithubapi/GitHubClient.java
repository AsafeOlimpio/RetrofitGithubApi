package com.olimipioscompany.retrofitgithubapi;

import com.olimipioscompany.retrofitgithubapi.model.GitHubRepo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Interface where HTTP methods are declared
 */
public interface GitHubClient {

    /**
     * Retrofit's get method with relative url path
     * @param user
     * @return
     */
    @GET("users/{user}/repos")
    Call<List<GitHubRepo>> reposForUser(@Path("user") String user);

}
