package com.hehe.hodgepodge.ultraonboarding;

//将Model层， View层、Presenter层协商的共同业务，封装成接口
//契约、合同
class OnboardingContract {

    interface Model{
        //Model层子类完成方法的具体实现
        void executeAM() throws Exception;
        void executeColseAM();
    }

    interface View<T extends Integer>{
        //根据返回值刷新UI界面
        void handlerResult(T t);
    }

    interface Presenter<T extends Integer>{
        //发起动画请求（接收到View层指令，可以自己做，也可以让Model层去执行）----------1
        void requestAM();

        //结果相应（接收到Model层处理完的结果，通知View刷新）---------------3
        void responseResult(T t);
        //关闭定时器
        void requestModelColseAM();
    }
}
