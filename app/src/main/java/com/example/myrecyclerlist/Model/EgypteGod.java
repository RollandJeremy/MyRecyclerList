package com.example.myrecyclerlist.Model;

import android.util.Log;

public class EgypteGod {


    private String name;
    private String url;
    private String[] affiliation;
    private String symbole;
    private String symbimage;
    private String divinite;
    private String signification;
    private String role;
    private String element;
    private String animal;
    private String[] attributs;


    public EgypteGod(String name, String url, String[] affiliation, String symbole, String symbimage, String divinite, String signification, String role, String element, String animal, String[] attributs) {
        this.name = name;
        this.url = url;
        this.affiliation = affiliation;
        this.symbole = symbole;
        this.symbimage = symbimage;
        this.divinite = divinite;
        this.signification = signification;
        this.role = role;
        this.element = element;
        this.animal = animal;
        this.attributs = attributs;
    }

    public void setName(String name) {
        Log.d("egypte !!","le nom est bon");
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getSymbole() {
        return symbole;
    }

    public String getUrlsymbole() {
        return symbimage;
    }

    public String getDivinite() {
        return divinite;
    }

    public String getSignification() {
        return signification;
    }

    public String getRole() {
        return role;
    }

    public String[] getAffiliation() {
        return affiliation;
    }

    public String getElement() {
        return element;
    }

    public String getAnimal() {
        return animal;
    }

    public String[] getAttributs() {
        return attributs;
    }


}
