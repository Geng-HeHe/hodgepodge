package com.hehe.hodgepodge.ultraonboarding;


import com.hehe.base.mvp.BasePresenter;

public class OnboardingPresenter extends BasePresenter<UltraOnboardingView,OnboardingModel,OnboardingContract.Presenter> {
    @Override
    public OnboardingContract.Presenter getContract() {
        return new OnboardingContract.Presenter() {
            @Override
            public void requestAM() {
                try {
                    m.getContract().executeAM();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(Integer integer) {
                getView().getContract().handlerResult(integer);
            }

            @Override
            public void requestModelColseAM() {
                m.getContract().executeColseAM();
            }
        };
    }

    @Override
    public OnboardingModel getModel() {
        return new OnboardingModel(this);
    }
}
