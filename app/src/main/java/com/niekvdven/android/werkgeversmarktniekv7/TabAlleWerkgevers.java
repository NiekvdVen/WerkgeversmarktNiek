package com.niekvdven.android.werkgeversmarktniekv7;


import android.os.Bundle;
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
public class TabAlleWerkgevers extends Fragment {
    private ArrayList<Model> mModelList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    public TabAlleWerkgevers() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_alle_werkgevers, container, false);

        // create recycler view
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);
        // give recycler view a layout manager
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        // create an adapter with the recycler view
        mAdapter = new ListAdapter(getListData());
        // connect the adapter with the recycler view
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;
    }

    private ArrayList<Model> getListData() {
        mModelList = new ArrayList<>();
        List<String> mCompanyList = Arrays.asList(getResources().getStringArray(R.array.company_list));

        for (int i = 0; i < mCompanyList.size();i++) {
            mModelList.add(new Model(mCompanyList.get(i)));
        }

        return mModelList;
    }
}
