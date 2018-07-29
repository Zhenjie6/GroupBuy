package com.example.zhenjie.groupbuy.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.example.zhenjie.groupbuy.R;
import com.example.zhenjie.groupbuy.fragment.CityFragment;
import com.example.zhenjie.groupbuy.fragment.HomeFragment;
import com.example.zhenjie.groupbuy.fragment.MeFragment;
import com.example.zhenjie.groupbuy.fragment.ShopFragment;

public class MainFunctionActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButtonMain;
    private Fragment cityFragment, homeFragment, meFragment, shopFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_function);
        initView();
        cityFragment = new CityFragment();
        homeFragment = new HomeFragment();
        meFragment = new MeFragment();
        shopFragment = new ShopFragment();
        //添加碎片
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.linearLayout_fragment,homeFragment)
                .commit();
        radioButtonMain.setChecked(true);
        setListener();
    }

    private void setListener() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction = getSupportFragmentManager()
                        .beginTransaction();
                switch (checkedId){
                    case R.id.radioButton_main:
                        Log.d("radio button","main");
                                transaction.replace(R.id.linearLayout_fragment,homeFragment);
                                break;
                    case R.id.radioButton_shop:
                        Log.d("radio button","shop");
                                transaction.replace(R.id.linearLayout_fragment,shopFragment);
                                break;
                    case R.id.radioButton_user:
                        Log.d("radio button","user");
                                transaction.replace(R.id.linearLayout_fragment,meFragment);
                                break;
                }
                transaction.commit();
            }
        });
    }

    private void initView() {
        radioGroup = findViewById(R.id.radioGroup);
        radioButtonMain = findViewById(R.id.radioButton_main);
    }

    //返回按钮和城市列表实现切换fragment的方法
    public void switchFragment(int page){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (page){
            case 1:
                transaction.replace(R.id.linearLayout_fragment,homeFragment);
                transaction.commit();
                break;
            case 2:
                transaction.replace(R.id.linearLayout_fragment,cityFragment);
                transaction.commit();
                break;
        }
    }
}