package com.rais.haidar.hypebeastnews.Network;

import com.rais.haidar.hypebeastnews.main.model.ResponseHypebeast;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("everything?domains=hypebeast.com&apiKey=742f9c39ed6c4d5c8874aadb10b34b79")
    Call<ResponseHypebeast> getHypebeast(
    );
}
