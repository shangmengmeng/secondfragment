package com.example.secondfragment.fragment;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.secondfragment.R;
import com.example.secondfragment.activty.MainActivity;


/**
 * Created by starry on 2016/11/16.
 */

public class Fragment1 extends Fragment {
    private MainActivity mainActivity;
    //fragment 被添加到Activity中时会被调用，且被调用一次
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mainActivity = (MainActivity) context;
    }

    //创建fragment时会被调用，且被调用一次
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    //创建fragment之后会创建View组件
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1,container,false);
        return view;
    }
    //在activity启动之后会被调用之后
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("------","kakkkpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("------","kakkkonStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("------","kakkkononDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    Log.e("kankan","llllll");
    }

    private void initView() {
    }


}
