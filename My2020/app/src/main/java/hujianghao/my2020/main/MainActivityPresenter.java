package hujianghao.my2020.main;

import androidx.fragment.app.Fragment;
import hujianghao.my2020.R;
import hujianghao.my2020.main.beijing.BeijingFragment;
import hujianghao.my2020.main.hangzhou.HangzhouFragment;
import hujianghao.my2020.main.shanghai.ShanghaiFragment;
import hujianghao.my2020.main.shenzhen.ShenzhenFragment;
import hujianghao.my2020.mvp.base.BaseMvpPresenter;

public class MainActivityPresenter extends BaseMvpPresenter<IMainContract.IView> implements IMainContract.Presenter {

    private int mCurrentFragmentIndex;
    private Fragment[] mFragments = new Fragment[4];
    private int mCheckedId;
    private int mTopPosition;
    private int mBottomPositon;


    public MainActivityPresenter(IMainContract.IView view) {
        super(view);
    }


    @Override
    protected IMainContract.IView getEmptyView() {
        return IMainContract.emptyView;
    }

    @Override
    public void initFragment() {
        mCurrentFragmentIndex = 0;
        replaceFragment(mCurrentFragmentIndex);

    }

    @Override
    public int getCurrentCheckedId() {
        return mCheckedId;
    }


    @Override
    public int getCurFragmentIndex() {
        return mCurrentFragmentIndex;
    }

    @Override
    public int getTopPosition() {
        return mTopPosition;
    }

    @Override
    public int getBottomPosition() {
        return mBottomPositon;
    }

    @Override
    public void replaceFragment(int fragmentIndex) {
        setCurrentChecked(fragmentIndex);
        for (int i = 0; i < mFragments.length; i++) {
            if (fragmentIndex != i) {
                if (mFragments[i] != null) {
                    // 隐藏
                    hideFragment(mFragments[i]);
                }
            }
        }

        Fragment fragment = mFragments[fragmentIndex];
        if (fragment != null) {
            addAndShowFragment(fragment);
        } else {
            newCurrentFragment(fragmentIndex);
        }
    }

    /**
     * 记录当前 角标
     */
    private void setCurrentChecked(int currentFragment) {
        mCurrentFragmentIndex = currentFragment;
        switch (currentFragment){
            case 0:
                mCheckedId = R.id.shanghai_rb;
                mTopPosition = 0;
                break;
            case 1:
                mCheckedId = R.id.hangzhou_rb;
                mTopPosition = 1;
                break;
            case 2:
                mCheckedId = R.id.beijing_rb;
                mBottomPositon = 2;
                break;
            case 3:
                mCheckedId = R.id.shenzhen_rb;
                mBottomPositon = 3;
                break;
        }

    }

    /**
     * 创建当前  Fragemnt
     */
    private void newCurrentFragment(int currentFragmentIndex) {
        Fragment fragment = null;
        switch (currentFragmentIndex) {
            case 0:
                fragment = new ShanghaiFragment();
                break;
            case 1:
                fragment = new HangzhouFragment();
                break;
            case 2:
                fragment = new BeijingFragment();
                break;
            case 3:
                fragment = new ShenzhenFragment();
                break;
            default:
                break;
        }
        mFragments[mCurrentFragmentIndex] = fragment;
        addAndShowFragment(fragment);
    }

    /**
     * 显示 Fragment
     */
    private void addAndShowFragment(Fragment fragment) {
        if(fragment.isAdded()){
            getView().showFragment(fragment);
        }else {
            getView().addFragment(fragment);
        }
    }

    /**
     * 隐藏 Fragment
     */
    private void hideFragment(Fragment fragment) {
        if(fragment != null && fragment.isVisible()){
            getView().hideFragment(fragment);
        }
    }
}
