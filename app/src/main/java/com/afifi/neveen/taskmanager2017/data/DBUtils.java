package com.afifi.neveen.taskmanager2017.data;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by user on 16/08/2017.
 */

public class DBUtils
{
    public  static FirebaseDatabase database=FirebaseDatabase.getInstance();
    public  static DatabaseReference myUserRef=database.getReference(MyUser.class.getSimpleName());
    public  static DatabaseReference myTaskRef=database.getReference(MyTasks.class.getSimpleName());
    public  static DatabaseReference myGroupsRef=database.getReference(MyGroup.class.getSimpleName());
    public static FirebaseAuth auth=FirebaseAuth.getInstance();
}

