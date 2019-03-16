package com.example.myrecyclerlist;

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


    public void setName(String name) {
        Log.d("egypte !!","le nom est bon");
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAffiliation(String[] affiliation) {
        this.affiliation = affiliation;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public void setSymbImage(String symbimage) {
        this.symbimage = symbimage;
    }

    public void setDivinite(String divinite) {
        this.divinite = divinite;
    }

    public void setSignification(String signification) {
        this.signification = signification;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setAttributs(String[] attributs) {
        this.attributs = attributs;
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
