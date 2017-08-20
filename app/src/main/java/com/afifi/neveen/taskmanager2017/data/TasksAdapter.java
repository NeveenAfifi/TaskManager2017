package com.afifi.neveen.taskmanager2017.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.afifi.neveen.taskmanager2017.R;
import com.google.android.gms.tasks.Task;

import java.util.Date;

/**
 * Created by user on 17/08/2017.
 */

public class TasksAdapter extends ArrayAdapter<MyTasks>
{
    public TasksAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.itm_task,parent,false);
        }
        MyTasks tasks=getItem(position);

        TextView tvtext= (TextView) convertView.findViewById(R.id.itmTvText);
        CheckBox cbIsCompleted= (CheckBox) convertView.findViewById(R.id.itmCBIscompleted);
        TextView tvCreatedAt= (TextView) convertView.findViewById(R.id.itemTvCreatedAt);
        TextView tvAdress= (TextView) convertView.findViewById(R.id.itmTvAdress);
        TextView tvUser= (TextView) convertView.findViewById(R.id.itmTvUser);
       Button btnGroup= (Button) convertView.findViewById(R.id.itmbtnGroup);

        tvtext.setText(tasks.getText());
        cbIsCompleted.setChecked(tasks.isCompleted());
        tvAdress.setText(tasks.getAddress());
        //TODO convert the key to real name
        tvUser.setText(tasks.getuKey());
        //TODO convert the key to real name
        btnGroup.setText(tasks.getgKey());

        Date date=new Date(tasks.getCreateAt());
        tvCreatedAt.setText(date.toString());


        return convertView;
    }
}
