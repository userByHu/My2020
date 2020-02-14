package hujianghao.my2020.main;

import androidx.fragment.app.Fragment;
import hujianghao.my2020.mvp.ILifeCircle;
import hujianghao.my2020.mvp.IMvpView;
import hujianghao.my2020.mvp.MvpControler;

public interface IMainContract {

    interface IView extends IMvpView{

        void addFragment(Fragment fragment);

        void showFragment(Fragment fragment);

        void hideFragment(Fragment fragment);
    }

    interface Presenter extends ILifeCircle {

        void initFragment();

        int getCurrentCheckedId();

        void replaceFragment(int fragmentIndex);

        int getCurFragmentIndex();

        int getTopPosition();

        int getBottomPosition();
    }

    IView emptyView = new IView() {

        @Override
        public void addFragment(Fragment fragment) {

        }

        @Override
        public void showFragment(Fragment fragment) {

        }

        @Override
        public void hideFragment(Fragment fragment) {

        }

        @Override
        public MvpControler getMvpControler() {
            return null;
        }
    };
}
