package com.stone.verticalslide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.stone.verticalslide.fragment.DragDownViewPagerFragment;
import com.stone.verticalslide.fragment.DragDownWebViewFragment;
import com.stone.verticalslide.fragment.DragTopFragment;
import com.stone.verticalslide.view.DragLayout;

/**
 * Created by liyanan on 2017/1/13.
 */

public class DragViewPagerActivity extends AppCompatActivity {
    private DragTopFragment fragment1;
    private DragDownViewPagerFragment fragment2;
    private DragLayout draglayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        fragment1 = new DragTopFragment();
        fragment2 = new DragDownViewPagerFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first, fragment1).add(R.id.second, fragment2)
                .commit();

        DragLayout.ShowNextPageNotifier nextIntf = new DragLayout.ShowNextPageNotifier() {
            @Override
            public void onDragNext() {
                fragment2.initData();
            }
        };
        draglayout = (DragLayout) findViewById(R.id.draglayout);
        draglayout.setNextPageListener(nextIntf);
    }
}
