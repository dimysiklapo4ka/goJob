package com.example.dev.gojob.vacancy.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dev.gojob.R;
import com.example.dev.gojob.vacancy.models.ModelsVacancy;

import java.util.ArrayList;


/**
 * Created by d1mys1klapo4ka on 01.06.2017.
 */

public class RecyclerVievAdapter extends RecyclerView.Adapter<RecyclerVievAdapter.ViewHolderForVacancy> {

    private ArrayList<ModelsVacancy> modelsVacancyList;
    private Context context;

    public RecyclerVievAdapter(Context context, ArrayList<ModelsVacancy> modelsVacancyList){

        this.context = context;
        this.modelsVacancyList = modelsVacancyList;
    }

    @Override
    public ViewHolderForVacancy onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_card,parent,false);

        return new ViewHolderForVacancy(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderForVacancy holder, int position) {

        ModelsVacancy modelsVacancy = modelsVacancyList.get(position);

        holder.tvName.setText(modelsVacancy.getName());
        holder.tvAddress.setText(modelsVacancy.getAddress());
        holder.tvPhone.setText(modelsVacancy.getPhone());
        holder.tvPrice.setText(modelsVacancy.getPrice());
    }

    @Override
    public int getItemCount() {
        return modelsVacancyList.size();
    }


    public class ViewHolderForVacancy extends RecyclerView.ViewHolder{

        TextView tvName, tvAddress, tvPhone, tvPrice;

        public ViewHolderForVacancy(View itemView) {
            super(itemView);

            tvName = (TextView)itemView.findViewById(R.id.tv_name);
            tvAddress = (TextView)itemView.findViewById(R.id.tv_address);
            tvPhone = (TextView)itemView.findViewById(R.id.tv_phone);
            tvPrice = (TextView)itemView.findViewById(R.id.tv_price);
        }
    }
}
