package com.zhongyang.cn.usethree;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhongyang.cn.actionbar.R;
import com.zhongyang.cn.tab.Tab1;
import com.zhongyang.cn.tab.Tab2;
import com.zhongyang.cn.tab.Tab3;

import java.util.ArrayList;
import java.util.List;

public class DaoHang extends AppCompatActivity
        implements ActionBar.TabListener, ViewPager.OnPageChangeListener {
    private ActionBar bar;//标题栏
    private List<Fragment> list = new ArrayList<>();//viewpager数据源
    private ViewPager vp; //Viewpager对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dao_hang);
        initViewpager();//应用程序一启动，就触发onTabSelected（）监听，
        // 执行vp.setCurrentItem(tab.getPosition())，所以必须先初始化Viewpager
        initActionBar();
    }

    /**
     * viewpager操作
     * 初始化，添加布局，适配，监听
     */
    public void initViewpager() {
        //M
        list.add(new Tab1());
        list.add(new Tab2());
        list.add(new Tab3());
        //V
        vp = (ViewPager) findViewById(R.id.vp);
        //C
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager(), list);
        vp.setAdapter(new Myadapter(getSupportFragmentManager()));
        vp.setOnPageChangeListener(this);//监听
    }

    /**
     * ActionBar 操作
     * 获取ActionBar，设置为Tabs形式，添加数据，监听，标题栏不可见
     */
    public void initActionBar() {
        bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        bar.addTab(bar.newTab().setText("推荐").setTabListener(this));
        bar.addTab(bar.newTab().setText("娱乐").setTabListener(this));
        bar.addTab(bar.newTab().setText("新闻").setTabListener(this));
        bar.setDisplayShowTitleEnabled(false);//设置标题栏不可见
    }

    //tab监听
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        vp.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    //viewpager监听
    @Override
    public void onPageScrolled(int position, float positionOffset,
                               int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * ViewPager与Fragment联用适配器
     */
    class Myadapter extends FragmentPagerAdapter {
        public Myadapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
