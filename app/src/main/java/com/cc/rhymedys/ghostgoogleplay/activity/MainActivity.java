package com.cc.rhymedys.ghostgoogleplay.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.cc.rhymedys.ghostgoogleplay.R;
import com.cc.rhymedys.ghostgoogleplay.fragment.FragmentFactory;
import com.cc.rhymedys.ghostgoogleplay.utils.UIUtils;
import com.cc.rhymedys.ghostgoogleplay.view.PagerTab;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class MainActivity extends BaseActivity {

    @ViewInject(R.id.view_pager)
    private ViewPager myViewPager;
    @ViewInject(R.id.pager_tab)
    private PagerTab myPagerTab;
    private MyViewPagerAdapter myViewPagerAdapter;
    private String[] myTabNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);

        myTabNames = UIUtils.getStringArray(R.array.tab_names);

        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myViewPagerAdapter);
        myPagerTab.setViewPager(myViewPager);
    }

    class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return myTabNames[position];
        }

        @Override
        public Fragment getItem(int position) {
            return FragmentFactory.createFragment(position);
        }

        @Override
        public int getCount() {
            return myTabNames.length;
        }
    }
}
