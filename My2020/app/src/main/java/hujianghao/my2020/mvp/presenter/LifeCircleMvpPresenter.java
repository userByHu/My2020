package hujianghao.my2020.mvp.presenter;


import java.lang.ref.WeakReference;

import hujianghao.my2020.mvp.ILifeCircle;
import hujianghao.my2020.mvp.IMvpView;
import hujianghao.my2020.mvp.MvpControler;

public abstract class LifeCircleMvpPresenter<T extends IMvpView> implements ILifeCircle {


    private WeakReference<T> weakReference;

    public LifeCircleMvpPresenter() {
        super();
    }

    public LifeCircleMvpPresenter(IMvpView iMvpView) {
        super();
        attachView(iMvpView);
        MvpControler mvpControler = iMvpView.getMvpControler();
        mvpControler.savePresenter(this);
    }

    @Override
    public void attachView(IMvpView iMvpView) {
        if (weakReference == null) {
            weakReference = new WeakReference(iMvpView);
        } else {
            T view = (T) weakReference.get();
            if (view != iMvpView) {
                weakReference = new WeakReference(iMvpView);
            }
        }
    }

    @Override
    public void onDestroy() {
        weakReference = null;
    }

    protected T getView() {
        T view = weakReference != null ? weakReference.get() : null;
        if(view == null) {
            return getEmptyView();
        }

        return view;
    }

    protected abstract T getEmptyView();
}
