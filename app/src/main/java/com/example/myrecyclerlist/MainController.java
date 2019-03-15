package com.example.myrecyclerlist;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainController {

    private final MainActivity mainActivity;
    private static MainController instanceMC = null;

    public MainController(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    public static MainController getInstance(MainActivity mainActivity){
        if(instanceMC == null){
            instanceMC = new MainController(mainActivity);
        }
        return instanceMC;
    }

    public void onCreate(){
        Gson gson = new GsonBuilder().setLenient().create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("blabla")
                .build();
        EgyptGodRestApi egypteGodRestApi = retrofit.create(EgyptGodRestApi.class);

        Call<EgyptGodRestResponse> call = egypteGodRestApi.getEgypteGod();

        call.enqueue(new Callback<EgyptGodRestResponse>() {
            @Override
            public void onResponse(Call<EgyptGodRestResponse> call, Response<EgyptGodRestResponse> response) {
                EgyptGodRestResponse reponse = response.body();
                List<EgypteGod> liste = reponse.getReponse();
                mainActivity.initRecyclerView(liste);
            }

            @Override
            public void onFailure(Call<EgyptGodRestResponse> call, Throwable t) {
                Log.d("Errrror","API ERREUR");
            }
        });



    }

}
