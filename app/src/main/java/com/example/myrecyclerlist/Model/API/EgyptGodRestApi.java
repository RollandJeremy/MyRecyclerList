package com.example.myrecyclerlist.Model.API;

import retrofit2.Call;
import retrofit2.http.GET;



public interface EgyptGodRestApi {

    @GET("monapi.json")
    Call<EgyptGodRestResponse> getEgypteGod();
}
