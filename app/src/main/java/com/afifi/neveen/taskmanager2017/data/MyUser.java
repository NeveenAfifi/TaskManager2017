package com.afifi.neveen.taskmanager2017.data;

import java.util.HashMap;

/**
 * Created by user on 12/07/2017.
 */

public class MyUser {
    private String name;
    private String uKey_email;//key
    private String phone;
    private HashMap<String, Object> groupsKeys = new HashMap<>();
    private HashMap<String, Object> tasksKeys = new HashMap<>();

    public MyUser()
    {
        //constructor(no perameters)
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setuKey_email(String uKey_email) {
        this.uKey_email = uKey_email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGroupsKeys(HashMap<String, Object> groupsKeys) {
        this.groupsKeys = groupsKeys;
    }

    public void setTasksKeys(HashMap<String, Object> tasksKeys) {
        this.tasksKeys = tasksKeys;
    }

    public String getName() {
        return name;
    }

    public String getuKey_email()
    {
        return uKey_email.replace('.','*');
    }

    public String getPhone() {
        return phone;
    }

    public HashMap<String, Object> getGroupsKeys()
    {
        return groupsKeys;
    }

    public HashMap<String, Object> getTasksKeys() {
        return tasksKeys;
    }

    public void addTaskKey(String taskKey)
    {
        this.tasksKeys.put(taskKey,true);
    }
    public void addGroupKey(String groupKeys)
    {
        this.groupsKeys.put(groupKeys,true);
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "name='" + name + '\'' +
                ", uKey_email='" + uKey_email + '\'' +
                ", phone='" + phone + '\'' +
                ", groupsKeys=" + groupsKeys +
                ", tasksKeys=" + tasksKeys +
                '}';
    }
}


