package com.afifi.neveen.taskmanager2017;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afifi.neveen.taskmanager2017.data.DBUtils;
import com.afifi.neveen.taskmanager2017.data.MyUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {
    private EditText etEmail,etPassward,etRePassward,etName,etPhone;
    private Button btnSave;
    //1.
    private FirebaseAuth auth;
    //to write to database
    private  FirebaseDatabase database;
    private DatabaseReference myUsersRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassward=(EditText)findViewById(R.id.etPassward);
        etRePassward=(EditText)findViewById(R.id.etRePassward);
        etName=(EditText)findViewById(R.id.etName);
        etPhone=(EditText)findViewById(R.id.etPhone);
        btnSave=(Button)findViewById(R.id.btnSave);


        //2.
        auth=FirebaseAuth.getInstance();
        eventHandler();
    }

    private void eventHandler() {
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataHandler();
            }
        });
    }

    private void dataHandler()
    {
        //shlefat hanetoneem
        final String stEmail=etEmail.getText().toString();
        String stPassward=etPassward.getText().toString();
        String stRePassward=etRePassward.getText().toString();
        final String stName=etName.getText().toString();
        final String stPhone=etPhone.getText().toString();

        //bdekat tkenot
        boolean isOk=true;
        if (stEmail.length()<6 || stEmail.indexOf('@')<1)
        {
            etEmail.setError("wrong Email");
            isOk = false;
        }
        if (stName.length()==0)
        {
           etName.setError("Required Field");
            isOk = false;
        }
        //TODO complete the rest check.......

        if (isOk)
        {
            final ProgressDialog progressDialog=ProgressDialog.show(this,"WAIT...","Signing Up",true,true);
            progressDialog.show();
            //DBUtile

            auth.createUserWithEmailAndPassword(stEmail,stPassward).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    progressDialog.dismiss();//haalmat hadaialog
                    if(task.isSuccessful())
                    {
                        //TODO add new user to MyUsers databaase
                        MyUser myUser=new MyUser();
                        myUser.setName((stName));
                        myUser.setuKey_email(stEmail);
                        myUser.setPhone(stPhone);

                        DBUtils.myUserRef.child(myUser.getuKey_email()).setValue(myUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                progressDialog.dismiss();//haalmat hadaialog
                                if (task.isSuccessful())
                                {
                                    finish();
                                }

                            }
                        });

                    }
                    else
                    {
                        Toast.makeText(SignUpActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }

}
