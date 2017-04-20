package com.zhongyang.cn.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.SimpleAdapter;

import com.zhongyang.cn.actionbar.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTabTest extends AppCompatActivity implements ActionBar.OnNavigationListener {
    private List<Fragment> list = new ArrayList<>();
    private List<Map<String, String>> list_map = new ArrayList();
    private String[] colors = {"blue", "red", "green"};
    private ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        bar = getSupportActionBar();

        list.add(new Tab1());
        list.add(new Tab2());
        list.add(new Tab3());

        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);//图标模式list的形式
        for (int i = 0; i < colors.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("name", colors[i]);
            list_map.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(ListTabTest.this, list_map, R.layout.item, new String[]{"name"}, new int[]{R.id.tv_item});

        bar.setListNavigationCallbacks(adapter, this);
    }

    @Override
    public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fg, list.get(itemPosition));
        transaction.commit();
        return true;
    }
}
