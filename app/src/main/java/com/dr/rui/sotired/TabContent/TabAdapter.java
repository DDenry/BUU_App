package com.dr.rui.sotired.TabContent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by rui on 2015/5/15.
 */
public class TabAdapter extends FragmentPagerAdapter {
    public static String[] TITLES = new String[]{"演奏方式", "乐队配置", "发声原理"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(final int position) {
        TabFragment tabFragment = new TabFragment(position);
        return tabFragment;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

}
