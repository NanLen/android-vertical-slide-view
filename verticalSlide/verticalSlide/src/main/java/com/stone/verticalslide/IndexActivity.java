package com.stone.verticalslide;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by liyanan on 2017/1/13.
 */

public class IndexActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_listView;
    private Button btn_webView;
    private Button btn_viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        initView();
        addListener();
    }

    private void initView() {
        btn_listView = (Button) findViewById(R.id.btn_listView);
        btn_webView = (Button) findViewById(R.id.btn_webView);
        btn_viewPager = (Button) findViewById(R.id.btn_viewPager);
    }

    private void addListener() {
        btn_listView.setOnClickListener(this);
        btn_webView.setOnClickListener(this);
        btn_viewPager.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_listView:
                startActivity(new Intent(this, DragListViewActivity.class));
                break;
            case R.id.btn_webView:
                startActivity(new Intent(this, DragWebViewActivity.class));
                break;
            case R.id.btn_viewPager:
                startActivity(new Intent(this, DragViewPagerActivity.class));
                break;
        }

    }
}
