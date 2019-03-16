package com.example.myrecyclerlist;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface EgyptGodRestApi {

    @GET("monapi.json")
    Call<EgyptGodRestResponse> getEgypteGod();
}
