package com.hehe.hodgepodge.ultraonboarding;

import android.view.View;

import androidx.appcompat.app.ActionBar;

import com.hehe.base.mvp.BaseView;


public class UltraOnboardingView extends BaseView<OnboardingPresenter,OnboardingContract.View> {
    private ActionBar mActionBar;

    @Override
    public void initActionBar() {
        mActionBar = getSupportActionBar();
        mActionBar.hide(); //隐藏ActionBar
    }

    @Override
    protected int getLayoutId() {
        return 0;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {
    }

    @Override
    public void initData() {

    }

    @Override
    protected void processClick(View v) {
        switch (v.getId()) {
        }
    }

    @Override
    public OnboardingContract.View getContract() {
        return new OnboardingContract.View<Integer>() {
            @Override
            public void handlerResult(Integer integer) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                    }
                });
                         }
        };
    }

    @Override
    public OnboardingPresenter getPresenter() {
        return new OnboardingPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        p.getContract().requestModelColseAM();
    }
}
