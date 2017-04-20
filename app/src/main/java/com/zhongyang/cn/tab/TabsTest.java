package com.zhongyang.cn.tab;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhongyang.cn.actionbar.R;

public class TabsTest extends AppCompatActivity implements ActionBar.TabListener {
    private ActionBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        bar = getSupportActionBar();//获取ActionBar对象
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);//设置Action的形式为Tabs形式
        bar.addTab(bar.newTab().setText("推荐").setTabListener(this));//添加tab，设置文本，监听
        bar.addTab(bar.newTab().setText("娱乐").setTabListener(this));
        bar.addTab(bar.newTab().setText("新闻").setTabListener(this));

    }

    /**
     * @param fragment 碎片对象
     *                 为页面设置对应的碎片
     */
    private void setFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();//获取v4包下的碎片管理器
        FragmentTransaction transaction = manager.beginTransaction();//开启事务
        transaction.replace(R.id.fg, fragment).commit();//设置碎片的位置，并提交事务
    }

    /**
     * 对ActionBar的Tab进行监听
     *
     * @param tab
     * @param ft
     */
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        Log.e("Tag", ft.toString());
        switch (tab.getText().toString()) {
            case "推荐":
                Tab1 tab1 = new Tab1();
                setFragment(tab1);
                break;
            case "新闻":
                Tab2 tab2 = new Tab2();
                setFragment(tab2);
                break;
            case "娱乐":
                Tab3 tab3 = new Tab3();
                setFragment(tab3);
                break;
        }

    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }
}
