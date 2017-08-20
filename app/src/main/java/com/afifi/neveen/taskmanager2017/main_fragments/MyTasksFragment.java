package com.afifi.neveen.taskmanager2017.main_fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.afifi.neveen.taskmanager2017.R;
import com.afifi.neveen.taskmanager2017.data.DBUtils;
import com.afifi.neveen.taskmanager2017.data.MyTasks;
import com.afifi.neveen.taskmanager2017.data.TasksAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyTasksFragment extends Fragment implements TitleAble {

    private ListView lstMyTasks;
    private TasksAdapter tasksAdapter;

    public MyTasksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_my_tasks, container, false);
        lstMyTasks=(ListView)view.findViewById(R.id.lstVTasks);
        //TODO connect the listView to the data source by adapter

        initListview();
        return view;
    }

    private void initListview() {

        if (tasksAdapter==null)
        {
            tasksAdapter=new TasksAdapter(getActivity(),R.layout.itm_task);

            //TODO get the data source and set it to the adapter

            DBUtils.myTaskRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    tasksAdapter.clear();

                    for (DataSnapshot ds:dataSnapshot.getChildren())
                    {
                        MyTasks myTasks=ds.getValue(MyTasks.class);
                        tasksAdapter.add(myTasks);

                    }
                    lstMyTasks.setAdapter(tasksAdapter);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }
    }


    @Override
    public String getTilte() {
        return "My Tasks";
    }
}
