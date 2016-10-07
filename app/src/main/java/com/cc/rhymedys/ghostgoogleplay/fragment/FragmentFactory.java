package com.cc.rhymedys.ghostgoogleplay.fragment;


import android.support.v4.app.Fragment;

import java.util.HashMap;

/**
 * 生成Fragment的工厂
 * Created by Rhymedys on 2016/10/7.
 */

public class FragmentFactory {

    private static HashMap<Integer, BaseFragment> myBaseFragmentMap = new HashMap<Integer, BaseFragment>();

    public static BaseFragment createFragment(int position) {
        BaseFragment fragment = myBaseFragmentMap.get(position);
        if (fragment == null) {
            switch (position) {
                case 0:
                    fragment = new HomeFragment();
                    break;
                case 1:
                    fragment = new AppFragment();
                    break;
                case 2:
                    fragment = new GameFragment();
                    break;
                case 3:
                    fragment = new SubjectFragment();
                    break;
                case 4:
                    fragment = new RecommandFragment();
                    break;
                case 5:
                    fragment = new CatagoryFragment();
                    break;
                case 6:
                    fragment = new HotFragment();
                    break;
                default:
                    break;

            }
        }
        myBaseFragmentMap.put(position, fragment);
        return fragment;
    }
}
