package com.example.zhenjie.groupbuy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.zhenjie.groupbuy.R;

public class RegisterActivity extends AppCompatActivity {

    private Button registerButton;
    private EditText editTextRegisterUsrName,editTextRegisterPasswd;
    private String usrname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        setListener();
    }

    void initView(){
        registerButton = findViewById(R.id.button_register);
        editTextRegisterPasswd = findViewById(R.id.editText_login_pwd_register);
        editTextRegisterUsrName = findViewById(R.id.edit_text_login_usr_name_register);
    }

    private void setListener() {
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                usrname = editTextRegisterUsrName.getText().toString();
                intent.putExtra("usrname",usrname);
                startActivity(intent);
            }
        });
    }
}
