package com.zhongyang.cn.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhongyang.cn.actionbar.R;

/**
 * Created by Administrator on 2016/7/4.
 */
public class Tab3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view3, container, false);
        return rootView;
    }
}
