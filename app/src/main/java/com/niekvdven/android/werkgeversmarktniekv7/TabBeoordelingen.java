package com.niekvdven.android.werkgeversmarktniekv7;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabBeoordelingen extends Fragment {
    private ArrayList<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;


    public TabBeoordelingen() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tab_beoordelingen, container, false);
        // FAB
        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), Beoordeling.class);
                startActivity(intent);
            }
        });
        // Recyclerview
        // create recycler view
//        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
//        // give recycler view a layout manager
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        // create an adapter with the recycler view
//        mAdapter = new ListAdapter(getListData());
//        // connect the adapter with the recycler view
//        mRecyclerView.setAdapter(mAdapter);
//
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return rootView;
    }

//    private ArrayList<Model> getListData() {
//        mModelList = new ArrayList<>();
//
//        return mModelList;
//    }
}