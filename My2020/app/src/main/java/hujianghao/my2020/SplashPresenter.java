package hujianghao.my2020;

import hujianghao.my2020.mvp.base.BaseMvpPresenter;

public class SplashPresenter extends BaseMvpPresenter<ISplashContract.IView> implements ISplashContract.Presenter{


    private CustomCountDownTimer mCustomCountDownTimer;


    public SplashPresenter(ISplashContract.IView view) {
        super(view);
    }

    @Override
    public void initCountDownTimer() {
        mCustomCountDownTimer = new CustomCountDownTimer(3, new CustomCountDownTimer.Callback() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimerText(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimerText("跳过");
            }
        });

        mCustomCountDownTimer.start();
    }

    public void cancelTimer() {
        mCustomCountDownTimer.cancel();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancelTimer();
    }


    /**
     * 防止 空指针异常
     */
    @Override
    protected ISplashContract.IView getEmptyView() {
        return ISplashContract.emptyView;
    }
}
