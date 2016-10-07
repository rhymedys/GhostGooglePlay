package com.cc.rhymedys.ghostgoogleplay.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cc.rhymedys.ghostgoogleplay.utils.UIUtils;
import com.cc.rhymedys.ghostgoogleplay.view.LoadingPager;

/**
 * Created by Rhymedys on 2016/10/7.
 */

public abstract class BaseFragment extends Fragment {

    private LoadingPager mLoadingPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //示例
        mLoadingPager = new LoadingPager(UIUtils.getContext()) {
            @Override
            public View onCreateSuccessView() {
                return BaseFragment.this.onCreateSuccessView();
            }
        };
        return mLoadingPager;
    }

    public abstract View onCreateSuccessView();
}
