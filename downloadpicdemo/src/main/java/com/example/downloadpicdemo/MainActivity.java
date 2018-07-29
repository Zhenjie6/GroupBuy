package com.example.downloadpicdemo;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    final int MINE_PERMISSION_REQUEST_CODE = 10000012;
    protected Button requestButton;
    protected ImageView imageView;
    protected Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
            }
        };
    }

    //绑定控件
    private void initView() {
        requestButton = findViewById(R.id.request_button);
        imageView = findViewById(R.id.result_imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.request_button:
                getPic();
                break;
        }
    }

    //点击按钮后实现的逻辑
    private void getPic() {
        //运行时权限处理
        boolean isAllGranted = checkPermissionAllGranted(new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        });
        //判断是否拥有所需要的全部权限
        if (isAllGranted) {
            //如果有权限，启动线程执行下载并显示图片
            downloadPic();
        } else {
            //如果没有权限，请求需要的权限
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, MINE_PERMISSION_REQUEST_CODE);
        }
    }


    private boolean checkPermissionAllGranted(String[] strings) {
        for (String permission : strings) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED)
                return false;
        }
        return true;
    }

    class GetPicThread implements Runnable {

        @Override
        public void run() {
            try {
                URL url = new URL("https://img2.mukewang.com/5adfee7f0001cbb906000338-240-135.jpg");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                //获取输入流
                InputStream inputStream = connection.getInputStream();
                String downloadFolder = Environment.getExternalStorageDirectory() + File.separator + "myPic" + File.separator;
                String fileName = "My Picture";
                File file = new File(downloadFolder);
                if (!file.exists()) {
                    file.mkdir();
                }
                File picFile = new File(downloadFolder + fileName);
                if (picFile.exists()) {
                    picFile.delete();
                }
                byte[] bytes = new byte[1024];
                FileOutputStream outputStream = new FileOutputStream(downloadFolder + fileName);
                int length;
                while ((length = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, length);

                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MINE_PERMISSION_REQUEST_CODE) {
            boolean isAllGranted = true;
            for (int grantResult : grantResults) {
                if (grantResult == PackageManager.PERMISSION_DENIED)
                    isAllGranted = false;
                break;
            }
            if (isAllGranted) {
                downloadPic();
            }
        }
    }

    private void downloadPic() {
        GetPicThread thread = new GetPicThread();
        new Thread(thread).start();
    }
}
