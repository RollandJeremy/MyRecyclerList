package com.example.myrecyclerlist.Controller;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;


import com.example.myrecyclerlist.R;
import com.example.myrecyclerlist.View.DescriptionActivity;
import com.example.myrecyclerlist.Model.API.EgyptGodRestApi;
import com.example.myrecyclerlist.Model.API.EgyptGodRestResponse;
import com.example.myrecyclerlist.Model.EgypteGod;
import com.example.myrecyclerlist.Model.EgypteGodCache;
import com.example.myrecyclerlist.View.MainActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.internal.EverythingIsNonNull;

public class MainController {

    private MainActivity mainActivity;
    private static MainController instanceMC = null;
    private final EgypteGodCache cache;
    private Retrofit retrofit;
    private RecyclerViewAdapter recyclerViewAdapter;


    private MainController(MainActivity mainActivity) {
        Log.d("mainController","Il est créé");
        this.mainActivity = mainActivity;
        cache = new EgypteGodCache(mainActivity);
        Gson gson = new GsonBuilder().setLenient().create();
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/RollandJeremy/APIEgypte/master/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
    public static MainController getInstance(MainActivity mainActivity){
        if(instanceMC==null){
            instanceMC = new MainController(mainActivity);
        }
        else {
            instanceMC.mainActivity = mainActivity;
        }
        return instanceMC;
    }

    public void onCreate() {


        this.readAPI();
    }
    private void initRecyclerView(List<EgypteGod> egyptGod){

        Log.d("TAG", "initRecyclerView: init RecyclerView");
        RecyclerView recyclerView = mainActivity.findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(mainActivity,egyptGod);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mainActivity));
    }
    private void readAPI(){

        EgyptGodRestApi egypteGodRestApi = retrofit.create(EgyptGodRestApi.class);

        Call<EgyptGodRestResponse> call = egypteGodRestApi.getEgypteGod();

        Log.d("MainController","le Call est fait !!");
        call.enqueue(new Callback<EgyptGodRestResponse>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<EgyptGodRestResponse> call, Response<EgyptGodRestResponse> response) {
                Log.d("MainController","le Call est arrivé !!");
                EgyptGodRestResponse reponse = response.body();
                assert reponse != null;
                List<EgypteGod> liste = reponse.getResults();
                cache.writeCache(liste);
                initRecyclerView(liste);
            }
            @EverythingIsNonNull
            @Override
            public void onFailure(Call<EgyptGodRestResponse> call, Throwable t) {
                if(cache.testCache()){
                    List<EgypteGod> liste = cache.getCache();
                    initRecyclerView(liste);
                }
                else {
                    Log.d("Errrror", "API ERREUR");
                    t.printStackTrace();
                }
            }
        });

    }
    void onItemClicked(EgypteGod itemClicked){
        Toast.makeText(mainActivity, itemClicked.getName(),Toast.LENGTH_SHORT).show();
        Intent descriptif = new Intent(mainActivity, DescriptionActivity.class);
        descriptif.putExtra("name",itemClicked.getName());
        descriptif.putExtra("affiliation",itemClicked.getAffiliation());
        descriptif.putExtra("url",itemClicked.getUrl());
        descriptif.putExtra("symbole",itemClicked.getSymbole());
        descriptif.putExtra("symbimage",itemClicked.getUrlsymbole());
        descriptif.putExtra("animal",itemClicked.getAnimal());
        descriptif.putExtra("element",itemClicked.getElement());
        descriptif.putExtra("role",itemClicked.getRole());
        descriptif.putExtra("signification",itemClicked.getSignification());
        descriptif.putExtra("divinite",itemClicked.getDivinite());
        descriptif.putExtra("attributs",itemClicked.getAttributs());
        mainActivity.startActivity(descriptif);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = mainActivity.getMenuInflater();
        inflater.inflate(R.menu.egyptegod_search,menu);

        MenuItem searchItem = menu.findItem(R.id.search_barre);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerViewAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

}
