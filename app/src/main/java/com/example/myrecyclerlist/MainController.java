package com.example.myrecyclerlist;

import android.util.Log;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainController {

    private final MainActivity mainActivity;
    private static MainController instanceMC = null;

    public MainController(MainActivity mainActivity) {
        Log.d("mainController","Il est créé");
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
                .baseUrl("https://raw.githubusercontent.com/RollandJeremy/APIEgypte/master/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        EgyptGodRestApi egypteGodRestApi = retrofit.create(EgyptGodRestApi.class);

        Call<EgyptGodRestResponse> call = egypteGodRestApi.getEgypteGod();

        Log.d("MainController","le Call est fait !!");
        call.enqueue(new Callback<EgyptGodRestResponse>() {
            @Override
            public void onResponse(Call<EgyptGodRestResponse> call, Response<EgyptGodRestResponse> response) {
                Log.d("MainController","le Call est arrivét !!");
                EgyptGodRestResponse reponse = response.body();
                List<EgypteGod> liste = reponse.getResults();
                mainActivity.initRecyclerView(liste);
            }

            @Override
            public void onFailure(Call<EgyptGodRestResponse> call, Throwable t) {
                Log.d("Errrror","API ERREUR");
                t.printStackTrace();
            }
        });



    }

}
