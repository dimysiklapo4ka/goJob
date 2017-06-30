package com.example.dev.gojob.vacancy.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dev.gojob.R;
import com.example.dev.gojob.serverUtils.mapServer.ParsedJsonUtils;
import com.example.dev.gojob.vacancy.adapter.RecyclerVievAdapter;
import com.example.dev.gojob.vacancy.models.ModelsVacancy;

import java.util.ArrayList;



/**
 * Created by d1mys1klapo4ka on 01.06.2017.
 */

public class MainFragment extends Fragment {

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

    private void jamalaChat(View view){

        rvChat = (RecyclerView)view.findViewById(R.id.rv_chat);
        rvChat.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvChat.setHasFixedSize(true);
        rvChat.setAdapter(new RecyclerVievAdapter(getActivity(), modelChat()));
    }

    private ArrayList<ModelsVacancy> modelChat(){

        ArrayList<ModelsVacancy> modelChats = new ArrayList<>();

        for (int i = 0; i < ParsedJsonUtils.getNameAgencies().size(); i++) {
            modelChats.add(new ModelsVacancy(ParsedJsonUtils.getNameAgencies().get(i),
                    ParsedJsonUtils.getAddressAgencies().get(i), ParsedJsonUtils.getPhoneAgencies().get(i),
                    ParsedJsonUtils.getPriceAgencies().get(i)));
        }

        return modelChats;

    }
}
