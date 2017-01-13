package com.stone.verticalslide.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.stone.verticalslide.R;

import java.util.ArrayList;

/**
 * Created by liyanan on 2017/1/13.
 */

public class DragDownViewPagerFragment extends Fragment {
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private TextView tv_listView;
    private TextView tv_webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_drag_down_viewpager, null);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tv_listView = (TextView) view.findViewById(R.id.tv_listView);
        tv_webView = (TextView) view.findViewById(R.id.tv_webView);
        initViewPager();
        initListener();
        return view;
    }

    private void initListener() {
        tv_listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        tv_webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
    }

    private void initViewPager() {
        fragments = new ArrayList<>();
        fragments.add(new DragDownListViewFragment());
        fragments.add(new DragDownWebViewFragment());
        titles = new ArrayList<>();
        titles.add("listView");
        titles.add("webView");
        viewPager.setAdapter(new PagerAdapter(getActivity().getSupportFragmentManager()));
    }

    public void initData() {
        DragDownWebViewFragment fragment = (DragDownWebViewFragment) fragments.get(1);
        fragment.initView();
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }


        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public long getItemId(int position) {
            return super.getItemId(position);
        }
    }

}