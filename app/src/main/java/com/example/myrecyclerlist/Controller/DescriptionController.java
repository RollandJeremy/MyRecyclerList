package com.example.myrecyclerlist.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myrecyclerlist.Model.EgypteGod;
import com.example.myrecyclerlist.R;
import com.example.myrecyclerlist.View.DescriptionActivity;


public class DescriptionController {

    private static DescriptionController instanceDC = null;
    private DescriptionActivity descriptionActivity;

    private DescriptionController(DescriptionActivity descriptionActivity) {

        this.descriptionActivity = descriptionActivity;
    }
    public static DescriptionController getInstance(DescriptionActivity mainActivity){
        if(instanceDC==null){
            instanceDC = new DescriptionController(mainActivity);
        }
        else {
            instanceDC.descriptionActivity = mainActivity;
        }
        return instanceDC;
    }

    public void onCreate(){
        this.ecranDescriptif();
    }

    @SuppressLint("SetTextI18n")
    private void ecranDescriptif(){
        Intent descriptif = descriptionActivity.getIntent();

        EgypteGod god = new EgypteGod(
                descriptif.getStringExtra("name"),
                descriptif.getStringExtra("url"),
                descriptif.getStringArrayExtra("affiliation"),
                descriptif.getStringExtra("symbole"),
                descriptif.getStringExtra("symbimage"),
                descriptif.getStringExtra("divinite"),
                descriptif.getStringExtra("signification"),
                descriptif.getStringExtra("role"),
                descriptif.getStringExtra("element"),
                descriptif.getStringExtra("animal"),
                descriptif.getStringArrayExtra("attributs"));

        TextView name = descriptionActivity.findViewById(R.id.name);
        TextView divinite = descriptionActivity.findViewById(R.id.divinite);
        ImageView url = descriptionActivity.findViewById(R.id.url);
        TextView role =  descriptionActivity.findViewById(R.id.role);
        TextView affiliation =  descriptionActivity.findViewById(R.id.affiliation);
        TextView element = descriptionActivity.findViewById(R.id.element);
        TextView animal =  descriptionActivity.findViewById(R.id.animal);
        TextView attributs =  descriptionActivity.findViewById(R.id.attributs);
        ImageView symbimage =  descriptionActivity.findViewById(R.id.symbimage);
        TextView symbole = descriptionActivity.findViewById(R.id.symbole);
        TextView signification = descriptionActivity.findViewById(R.id.signification);


        name.setText(god.getName());
        divinite.setText(god.getDivinite());
        Glide.with(descriptionActivity).asBitmap().load(god.getUrl()).into(url);
        role.setText(god.getRole()+"\n");
        StringBuilder ligne;
        ligne = new StringBuilder();
        for(int repetition = 0;repetition < god.getAffiliation().length;repetition++){
            ligne.append(god.getAffiliation()[repetition]).append("\n");
        }
        affiliation.setText(ligne.toString());
        StringBuilder ligne2;
        ligne2 = new StringBuilder();
        for(int repetition = 0;repetition < god.getAttributs().length;repetition++){
            ligne2.append(god.getAttributs()[repetition]).append("\n");
        }
        attributs.setText(ligne2);
        element.setText(god.getElement());
        animal.setText(god.getAnimal()+"\n");
        Glide.with(descriptionActivity).asBitmap().load(god.getUrlsymbole()).into(symbimage);
        symbole.setText(god.getSymbole()+"\n");
        signification.setText("("+god.getSignification()+")");
    }
}
