package com.afifi.neveen.taskmanager2017.data;

import java.util.HashMap;

/**
 * Created by user on 12/07/2017.
 */

public class MyGroup
{
    private String gKey;
    private String mngrUKey;
    private String name;
    private HashMap<String, Object> usersKeys = new HashMap<>();
    private HashMap<String, Object> tasksKeys = new HashMap<>();

    public MyGroup()
    {

    }

    public String getgKey() {
        return gKey;
    }

    public String getMngrUKey() {
        return mngrUKey;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Object> getUsersKeys() {
        return usersKeys;
    }

    public HashMap<String, Object> getTasksKeys() {
        return tasksKeys;
    }

    public void setgKey(String gKey) {
        this.gKey = gKey;
    }

    public void setMngrUKey(String mngrUKey) {
        this.mngrUKey = mngrUKey;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsersKeys(HashMap<String, Object> usersKeys) {
        this.usersKeys = usersKeys;
    }

    public void setTasksKeys(HashMap<String, Object> tasksKeys) {
        this.tasksKeys = tasksKeys;
    }
    public void addTaskKey(String taskKey)
    {
        this.tasksKeys.put(taskKey,true);
    }
    public void addUserKey(String userKey)
    {
        this.usersKeys.put(userKey,true);
    }

    @Override
    public String toString() {
        return "MyGroup{" +
                "gKey='" + gKey + '\'' +
                ", mngrUKey='" + mngrUKey + '\'' +
                ", name='" + name + '\'' +
                ", usersKeys=" + usersKeys +
                ", tasksKeys=" + tasksKeys +
                '}';
    }
}
