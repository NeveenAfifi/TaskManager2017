package com.afifi.neveen.taskmanager2017;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.afifi.neveen.taskmanager2017.data.MyGroup;
import com.afifi.neveen.taskmanager2017.data.MyTasks;
import com.afifi.neveen.taskmanager2017.data.MyUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInActivity extends AppCompatActivity {
    private EditText etEmail,etPassward;
    private Button btnSignIn,btnSignUp;
    //1.
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        //2.
        auth=FirebaseAuth.getInstance();
        //5.bdeka if the user is signIn
        if(auth.getCurrentUser()!=null)
        {
            Intent i=new Intent(getBaseContext(),MainActivity.class);
            startActivity(i);
        }

        etEmail=(EditText)findViewById(R.id.etEmail);
        etPassward=(EditText)findViewById(R.id.etPassward);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

        eventHandler();


    }
    private  void eventHandler()
    {
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datahandler();
            }

        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent i=new Intent(getBaseContext(),SignUpActivity.class);
                startActivity(i);
            }
        });

    }

    private void datahandler()
    {
      //TODO SignIn by fireBase
        //kletat netoneem
        String stEmail=etEmail.getText().toString();
        String stPassward=etPassward.getText().toString();
        boolean isok=true;

        if (stEmail.indexOf('@')<1)
        {
            isok=false;
            etEmail.setError("Wrong email");

        }
        if (isok)
        {
            logIn( stEmail, stPassward);
        }
    }

    private void logIn(String stEmail, String stPassward)
    {
        final ProgressDialog progressDialog=ProgressDialog.show(this,"Wait","Signning in",true,true);
        progressDialog.show();
       //3.
        auth.signInWithEmailAndPassword(stEmail,stPassward).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                progressDialog.dismiss();//lhaaleem
                if(task.isSuccessful())
                {
                    //4.
                    Intent i=new Intent(getBaseContext(),MainActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(LogInActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
