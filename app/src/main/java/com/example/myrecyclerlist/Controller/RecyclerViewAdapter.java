package com.example.myrecyclerlist.Controller;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myrecyclerlist.Model.EgypteGod;
import com.example.myrecyclerlist.R;
import com.example.myrecyclerlist.View.MainActivity;

import java.util.ArrayList;
import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "RecyclerViewAdapter";

    private Context mContext;
    private MainController controlleur;
    private List<com.example.myrecyclerlist.Model.EgypteGod> egypteGod;
    private List<com.example.myrecyclerlist.Model.EgypteGod> egypteGodFull;

    RecyclerViewAdapter(Context mContext, List<EgypteGod> setList) {
        this.mContext = mContext;
        this.egypteGod = setList;
        this.controlleur = MainController.getInstance((MainActivity)this.mContext);
        this.egypteGodFull = new ArrayList<>(setList);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext).asBitmap().load(egypteGod.get(position).getUrl()).into(holder.image);
        holder.image_name.setText(egypteGod.get(position).getName());
        holder.image_divinite.setText(egypteGod.get(position).getDivinite());
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.d(TAG, "onClick: clicked on: " + imageNames.get(position));
                //Toast.makeText(mContext, EgypteGod.get(position).getName(),Toast.LENGTH_SHORT).show();
                controlleur.onItemClicked(egypteGod.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return egypteGod.size();
    }

    @Override
    public Filter getFilter() {
        return egypteGodFilter;
    }

    private final Filter egypteGodFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<EgypteGod> listeFilter = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                listeFilter.addAll(egypteGodFull);
            } else {
                String filt = constraint.toString().toLowerCase().trim();
                for (EgypteGod item : egypteGodFull) {
                    if (item.getName().toLowerCase().contains(filt)) {
                        listeFilter.add(item);
                    }
                }
            }
            FilterResults result = new FilterResults();
            result.values = listeFilter;
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            egypteGod.clear();
            for(int repetition = 0; repetition < ((List)results.values).size();repetition++){
                egypteGod.add((EgypteGod)((List)results.values).get(repetition));
            }
            notifyDataSetChanged();
        }
    };

    class ViewHolder extends RecyclerView.ViewHolder{


        ImageView image;
        TextView image_name;
        RelativeLayout parentLayout;
        TextView image_divinite;

        ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            image_name = itemView.findViewById(R.id.image_name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            image_divinite = itemView.findViewById(R.id.image_divinite);
        }
    }
}
