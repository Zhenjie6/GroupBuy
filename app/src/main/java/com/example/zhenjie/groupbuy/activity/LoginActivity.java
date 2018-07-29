package com.example.zhenjie.groupbuy.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.zhenjie.groupbuy.R;

public class LoginActivity extends AppCompatActivity {
    private Button loginButton;
    private EditText editTextUsrName, eidtTextPwd;
    private TextView registerTextView;
    private String userName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login_activity);
        initView();
        setListener();
        Intent intent = getIntent();
        userName = intent.getStringExtra("usrname");
        editTextUsrName.setText(userName);
    }

    protected void initView() {
        loginButton = findViewById(R.id.button_login);
        editTextUsrName = findViewById(R.id.edit_text_login_usr_name);
        eidtTextPwd = findViewById(R.id.editText_login_pwd);
        registerTextView = findViewById(R.id.textView_register);
        loginButton = findViewById(R.id.button_login);
    }

    private void setListener() {
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainFunctionActivity.class);
                startActivity(intent);
            }
        });
    }


}
