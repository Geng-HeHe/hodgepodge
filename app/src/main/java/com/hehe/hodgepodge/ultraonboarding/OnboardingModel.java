package com.hehe.hodgepodge.ultraonboarding;


import com.hehe.base.mvp.BaseModel;

import java.util.Timer;
import java.util.TimerTask;

public class OnboardingModel extends BaseModel<OnboardingPresenter,OnboardingContract.Model> {

    private int count_am=0;

    public OnboardingModel(OnboardingPresenter onboardingPresenter) {
        super(onboardingPresenter);
    }



    @Override
    public OnboardingContract.Model getContract() {
        return new OnboardingContract.Model() {
            @Override
            public void executeAM() throws Exception {
                //p.getContract().responseResult(1);


            }

            @Override
            public void executeColseAM() {
            }
        };
    }


}

