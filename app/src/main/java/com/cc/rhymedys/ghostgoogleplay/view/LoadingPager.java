package com.cc.rhymedys.ghostgoogleplay.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

import com.cc.rhymedys.ghostgoogleplay.R;
import com.cc.rhymedys.ghostgoogleplay.utils.UIUtils;

/**
 * 根据状态来显示不同的页面的FrameLayout
 * Created by Rhymedys on 2016/10/7.
 */

public abstract class LoadingPager extends FrameLayout {

    private static final int STATE_LOAD_UNDO = 1;
    private static final int STATE_LOAD_LOADING = 2;
    private static final int STATE_LOAD_ERROR = 3;
    private static final int STATE_LOAD_EMPTY = 4;
    private static final int STATE_LOAD_SUCCESS = 5;

    private int myCurrentState = STATE_LOAD_UNDO;
    private View mLoadingPager;
    private View mErrorPager;
    private View mEmptyPager;
    private View mSuccessPager;

    public LoadingPager(Context context) {
        super(context);
        initView();
    }

    public LoadingPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LoadingPager(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {
        //init Loading View
        if (mLoadingPager == null) {
            mLoadingPager = UIUtils.inflate(R.layout.pager_loading);
            addView(mLoadingPager);
        }
        //init Error View
        if (mErrorPager == null) {
            mErrorPager = UIUtils.inflate(R.layout.pager_error);
            addView(mErrorPager);
        }
        //init Empty View
        if (mEmptyPager == null) {
            mEmptyPager = UIUtils.inflate(R.layout.pager_empty);
            addView(mEmptyPager);
        }

        showRightPager();
    }

    private void showRightPager() {
        if (myCurrentState == STATE_LOAD_LOADING || myCurrentState == STATE_LOAD_UNDO) {
            mLoadingPager.setVisibility(View.VISIBLE);
        } else {
            mLoadingPager.setVisibility(View.GONE);
        }

        if (myCurrentState == STATE_LOAD_ERROR) {
            mErrorPager.setVisibility(View.VISIBLE);
        } else {
            mErrorPager.setVisibility(View.GONE);
        }
        if (myCurrentState == STATE_LOAD_EMPTY) {
            mEmptyPager.setVisibility(View.VISIBLE);
        } else {
            mEmptyPager.setVisibility(View.GONE);
        }
        if (mSuccessPager == null && myCurrentState == STATE_LOAD_SUCCESS) {
            mSuccessPager = onCreateSuccessView();
            if (mSuccessPager != null) {
                addView(mSuccessPager);
            }
        }

    }

    public abstract View onCreateSuccessView();
}
