package com.example.dev.gojob.vacancy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dev.gojob.R;
import com.example.dev.gojob.activity.MainActivity;
import com.example.dev.gojob.serverUtils.api.AgencyInterface;
import com.example.dev.gojob.serverUtils.api.RetrofitClient;
import com.example.dev.gojob.serverUtils.api.VacanciesInterface;
import com.example.dev.gojob.serverUtils.mapServer.ParsedJsonUtils;
import com.example.dev.gojob.serverUtils.retrofitModel.AgencyList;
import com.example.dev.gojob.vacancy.adapter.RecyclerVievAdapter;
import com.example.dev.gojob.vacancy.models.ModelsVacancy;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by d1mys1klapo4ka on 01.06.2017.
 */

public class MainFragment extends Fragment {

    ArrayList<ModelsVacancy> modelChats = new ArrayList<>();

    RecyclerView rvChat;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        jamalaChat(view);
        return view;
    }

    private void jamalaChat(View view) {

        rvChat = (RecyclerView) view.findViewById(R.id.rv_chat);
        rvChat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvChat.setHasFixedSize(true);
        rvChat.setAdapter(new RecyclerVievAdapter(getActivity(), modelChat()));
    }

    private ArrayList<ModelsVacancy> modelChat() {
        ArrayList<ModelsVacancy> modelChats = new ArrayList<>();

        modelChats.add(new ModelsVacancy("Директор 1", "2222 EUR", "Категория 1", "Специальность Энергетик"));
        modelChats.add(new ModelsVacancy("Директор 2", "2543 EUR", "Категория 1", "Специальность Бариста"));
        modelChats.add(new ModelsVacancy("Директор 3", "3421 EUR", "Категория 2", "Специальность Сантехник"));
        modelChats.add(new ModelsVacancy("Директор 4", "1456 EUR", "Категория 3", "Специальность Монтажник"));
        modelChats.add(new ModelsVacancy("Директор 5", "6189 EUR", "Категория 3", "Специальность Слесарь"));
        modelChats.add(new ModelsVacancy("Директор 6", "2987 EUR", "Категория 2", "Специальность Муж на час"));
        modelChats.add(new ModelsVacancy("Director1", "2345 EUR", "Category 1", "Actor"));

        return modelChats;
    }

}

                //        for (int i = 0; i < ParsedJsonUtils.getNameAgencies().size(); i++) {
//            modelChats.add(new ModelsVacancy(ParsedJsonUtils.getNameAgencies().get(i),
//                    ParsedJsonUtils.getAddressAgencies().get(i), ParsedJsonUtils.getPhoneAgencies().get(i),
//                    ParsedJsonUtils.getPriceAgencies().get(i)));
//        }