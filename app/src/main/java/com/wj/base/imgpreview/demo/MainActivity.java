package com.wj.base.imgpreview.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wj.base.intent.PhotoPreviewIntent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        PhotoPreviewIntent intent = new PhotoPreviewIntent(MainActivity.this);
        intent.setCurrentItem(2);
        List<String> list = new ArrayList<>();
        list.add("http://gss0.baidu.com/-vo3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/8435e5dde71190ef3bee9ce4cc1b9d16fdfa60f7.jpg");
        list.add("http://img18.3lian.com/d/file/201709/21/59e94ba7e662f397788f7d101fad511c.jpg");
        list.add("http://img02.tooopen.com/images/20160413/tooopen_sy_159215748672.jpg");
        list.add("http://pic2.16pic.com/00/37/26/16pic_3726508_b.jpg");
        intent.setPhotoPaths(list);
        startActivity(intent);
    }
}
