package com.stone.verticalslide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

import com.stone.verticalslide.fragment.DragDownWebViewFragment;
import com.stone.verticalslide.fragment.DragTopFragment;
import com.stone.verticalslide.view.DragLayout;
import com.stone.verticalslide.view.DragLayout.ShowNextPageNotifier;

public class MainActivity extends AppCompatActivity {

    private DragTopFragment fragment1;
    private DragDownWebViewFragment fragment3;
    private DragLayout draglayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化View
     */
    private void initView() {
        fragment1 = new DragTopFragment();
        fragment3 = new DragDownWebViewFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.first, fragment1).add(R.id.second, fragment3)
                .commit();

        ShowNextPageNotifier nextIntf = new ShowNextPageNotifier() {
            @Override
            public void onDragNext() {
                fragment3.initView();
            }
        };
        draglayout = (DragLayout) findViewById(R.id.draglayout);
        draglayout.setNextPageListener(nextIntf);
    }

}
