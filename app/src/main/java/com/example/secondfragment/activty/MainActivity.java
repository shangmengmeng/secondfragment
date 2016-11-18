package com.example.secondfragment.activty;

import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import com.example.secondfragment.Adapter.MyAdapter;
import com.example.secondfragment.R;
import com.example.secondfragment.fragment.Fragment1;
import com.example.secondfragment.fragment.Fragment2;
import com.example.secondfragment.fragment.Fragment3;
import com.example.secondfragment.fragment.MainFragment;
import android.support.design.widget.TabLayout;


import java.util.ArrayList;

public class MainActivity extends FragmentActivity {
    private FragmentTransaction ft;
    private MainFragment mainFragment;
    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private Fragment3 fragment3;
    private ArrayList<Fragment> fragments;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<String> titles;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.vp);

        //viewpager每次切换的时候， 会重新创建当前界面及左右界面三个界面，
        // 每次切换都要重新oncreate, 所以只要设置viewPager setOffscreenPageLimit即可避免这个问题。
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),fragments,titles));
        tabLayout.setupWithViewPager(viewPager);

    }


    public void getData() {
        fragments =new ArrayList<>();
        mainFragment = new MainFragment();
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();
        fragments.add(mainFragment);
        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);

        titles = new ArrayList<>();
        titles.add("第一话");
        titles.add("第二话");
        titles.add("第三话");
        titles.add("第四话");

    }
}
