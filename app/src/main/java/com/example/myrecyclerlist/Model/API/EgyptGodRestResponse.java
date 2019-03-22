package com.example.myrecyclerlist.Model.API;

import com.example.myrecyclerlist.Model.EgypteGod;

import java.util.List;

public class EgyptGodRestResponse {

    private List<EgypteGod> results;

    public EgyptGodRestResponse(List<EgypteGod> results) {
        this.results = results;
    }

    public List<EgypteGod> getResults(){
        return results;
    }

}
