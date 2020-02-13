package hujianghao.my2020;

import hujianghao.my2020.mvp.ILifeCircle;
import hujianghao.my2020.mvp.IMvpView;
import hujianghao.my2020.mvp.MvpControler;

public interface ISplashContract {

    interface IView extends IMvpView{
        void setTvTimerText(String s);
    }

    interface Presenter extends ILifeCircle {
        void initCountDownTimer();
    }

    IView emptyView = new IView() {
        @Override
        public void setTvTimerText(String s) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
