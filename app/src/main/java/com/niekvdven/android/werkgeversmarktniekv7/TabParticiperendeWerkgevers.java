package com.niekvdven.android.werkgeversmarktniekv7;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.niekvdven.android.werkgeversmarktniekv7.ListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class TabParticiperendeWerkgevers extends Fragment {
    private List<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private ArrayList<Model> participerend;


    public TabParticiperendeWerkgevers() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_participerende_werkgevers, container, false);

        // create recycler view
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview_participerend);
        // give recycler view a layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // create an adapter with the recycler view
        Bundle bundle=getArguments();
        if(bundle!=null){
            participerend=bundle.getParcelableArrayList("key");
        }

//        ArrayList<Model> participerend = (ArrayList<Model>)bundle.getParcelableArrayList("key");
        mAdapter = new ListAdapter(participerend);
        // connect the adapter with the recycler view
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

}

