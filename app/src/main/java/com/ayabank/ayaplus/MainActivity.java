package com.ayabank.ayaplus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText mTextUsername;
EditText mTextPassword;
Button mButtonlogin;
TextView mTextViewRegister;
DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        mTextUsername=(EditText)findViewById(R.id.edittext_username);
        mTextPassword=(EditText)findViewById(R.id.edittext_password);
        mButtonlogin=(Button)findViewById(R.id.button_login);
        mTextViewRegister=(TextView)findViewById(R.id.textview_register);
        mTextViewRegister.setOnClickListener(new View.OnClickListener(){
            public  void onClick(View view){
                Intent registerIntent=new Intent(MainActivity.this,RegisterActivity.class);
           startActivity(registerIntent);
            }
        });
      //  mButtonlogin.setOnClickListener(new View.OnClickListener(){
          //  public  void  onClick(View view1){
               // Intent loginIntent=new Intent(MainActivity.this,HomeActivity.class);
             //   startActivity(loginIntent);
            //}
        //});
        mButtonlogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String user=mTextUsername.getText().toString().trim();
                String pwd=mTextPassword.getText().toString().trim();
                Boolean res=db.checkUser(user,pwd);
              //  Toast.makeText(MainActivity.this," Res" + res,Toast.LENGTH_SHORT).show();
                if (res==true){
                    Intent HomePage=new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(HomePage);
                  //  Toast.makeText(MainActivity.this,"Successfully Logged In",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this," Logged In Error",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}