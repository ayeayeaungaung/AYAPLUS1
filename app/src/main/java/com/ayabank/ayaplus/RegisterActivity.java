package com.ayabank.ayaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText mTextUsername;
    EditText mTextPassword;
    Button mButtonregister;
    EditText mTextCnfPassword;
    TextView mTextViewLogin;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        mTextUsername=(EditText)findViewById(R.id.edittext_username);
        mTextCnfPassword=(EditText)findViewById(R.id.conf_password);
        mTextPassword=(EditText)findViewById(R.id.edittext_password);
        mButtonregister=(Button)findViewById(R.id.button_register);
        mTextViewLogin=(TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent LoginIntent=new Intent(RegisterActivity.this,MainActivity.class);

            startActivity(LoginIntent);
            }
        });

        mButtonregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
String user=mTextUsername.getText().toString().trim();
String pwd=mTextPassword.getText().toString().trim();
String cnf_pwd=mTextCnfPassword.getText().toString().trim();
                if (pwd.equals(cnf_pwd)){
                    long val=db.addUser(user,pwd);
                    if(val>0){
                        Toast.makeText(RegisterActivity.this,"You have registered",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin=new Intent(RegisterActivity.this,MainActivity.class);
                        startActivity(moveToLogin);
                    }else { Toast.makeText(RegisterActivity.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(RegisterActivity.this,"Password is not matching",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }


}
