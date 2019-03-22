package com.example.myrecyclerlist.Model;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;


public class EgypteGodCache {

    private SharedPreferences sharedPreferences;

    public EgypteGodCache(Context context){
        sharedPreferences = context.getSharedPreferences("GOD",Context.MODE_PRIVATE);
    }

    public boolean testCache(){
        if(sharedPreferences.contains("NAME")){
            System.out.println("TRUEEEE");
            return true;
        }
        else{
            System.out.println("FALSEEEE");
            return false;
        }
    }

    public List<EgypteGod> getCache(){

        String name = sharedPreferences.getString("NAME",null);
        assert name != null;
        String[] nameG = name.split("&");
        String url = sharedPreferences.getString("URL",null);
        assert url != null;
        String[] urlG = url.split("&");
        String affiliation = sharedPreferences.getString("AFFILIATION",null);
        assert affiliation != null;
        String[] affiliationG = affiliation.split("&");
        String symbole = sharedPreferences.getString("SYMBOLE",null);
        assert symbole != null;
        String[] symboleG = symbole.split("&");
        String symbimage = sharedPreferences.getString("SYMBIMAGE",null);
        assert symbimage != null;
        String[] symbimageG = symbimage.split("&");
        String divinite = sharedPreferences.getString("DIVINITE",null);
        assert divinite != null;
        String[] diviniteG = divinite.split("&");
        String signification = sharedPreferences.getString("SIGNIFICATION",null);
        assert signification != null;
        String[] significationG = signification.split("&");
        String role = sharedPreferences.getString("ROLE",null);
        assert role != null;
        String[] roleG = role.split("&");
        String element = sharedPreferences.getString("ELEMENT",null);
        assert element != null;
        String[] elementG = element.split("&");
        String animal = sharedPreferences.getString("ANIMAL",null);
        assert animal != null;
        String[] animalG = animal.split("&");
        String attributs = sharedPreferences.getString("ATTRIBUTS",null);
        assert attributs != null;
        String[] attributsG = attributs.split("&");

        List<EgypteGod> liste = new ArrayList<>();
        for(int repetition = 0;repetition<nameG.length;repetition++)
        {
            liste.add(new EgypteGod(
                    nameG[repetition],
                    urlG[repetition],
                    affiliationG[repetition].split("\t"),
                    symboleG[repetition],
                    symbimageG[repetition],
                    diviniteG[repetition],
                    significationG[repetition],
                    roleG[repetition],
                    elementG[repetition],
                    animalG[repetition],
                    attributsG[repetition].split("\t")));
           //System.out.println(nameI.next());
        }

        return liste;


    }

    public void writeCache(List<EgypteGod> listGod){

        StringBuilder name = new StringBuilder();
        StringBuilder url = new StringBuilder();
        StringBuilder affiliation = new StringBuilder();
        StringBuilder symbole = new StringBuilder();
        StringBuilder symbimage = new StringBuilder();
        StringBuilder divinite = new StringBuilder();
        StringBuilder signification = new StringBuilder();
        StringBuilder role = new StringBuilder();
        StringBuilder element = new StringBuilder();
        StringBuilder animal = new StringBuilder();
        StringBuilder attributs = new StringBuilder();
        EgypteGod god;


        for(int repetition = 0; repetition < listGod.size();repetition++){
            god = listGod.get(repetition);

            name.append(god.getName()).append("&");
            url.append(god.getUrl()).append("&");

            StringBuilder build = new StringBuilder();
            for(int rep=0;rep<god.getAffiliation().length;rep++){
                build.append(god.getAffiliation()[rep]).append("\t");
            }
            affiliation.append(build.toString()).append("&");
            symbole.append(god.getSymbole()).append("&");
            symbimage.append(god.getUrlsymbole()).append("&");
            divinite.append(god.getDivinite()).append("&");
            signification.append(god.getSignification()).append("&");
            role.append(god.getRole()).append("&");
            element.append(god.getElement()).append("&");
            animal.append(god.getAnimal()).append("&");

            build = new StringBuilder();
            for(int rep=0;rep<god.getAttributs().length;rep++){
                build.append(god.getAttributs()[rep]).append("\t");
            }
            attributs.append(build.toString()).append("&");
        }

        sharedPreferences.edit()
                .putString("NAME",name.toString())
                .putString("URL",url.toString())
                .putString("AFFILIATION",affiliation.toString())
                .putString("SYMBOLE",symbole.toString())
                .putString("SYMBIMAGE",symbimage.toString())
                .putString("DIVINITE",divinite.toString())
                .putString("SIGNIFICATION",signification.toString())
                .putString("ROLE",role.toString())
                .putString("ELEMENT",element.toString())
                .putString("ANIMAL",animal.toString())
                .putString("ATTRIBUTS",attributs.toString())
                .apply();
       // List<EgypteGod> goddy = this.getCache();
    }
    

}
