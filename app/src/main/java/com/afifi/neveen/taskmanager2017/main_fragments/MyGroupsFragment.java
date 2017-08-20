package com.afifi.neveen.taskmanager2017.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afifi.neveen.taskmanager2017.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyGroupsFragment extends Fragment implements TitleAble {
    private ListView lstVGroups;


    public MyGroupsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_my_groups, container, false);
        lstVGroups= (ListView) view.findViewById(R.id.lstVGroups);
        //TODO connect the listView to the data source by adapter
        return view;

    }


    @Override
    public String getTilte() {

        {
            return "My Group";
        }
    }
}
