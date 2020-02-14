package hujianghao.my2020.main;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.OnClick;
import hujianghao.my2020.R;
import hujianghao.my2020.base.BaseActivity;
import hujianghao.my2020.base.ViewInject;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity implements IMainContract.IView {

    @BindView(R.id.shanghai_rb)
    RadioButton shanghaiRb;
    @BindView(R.id.hangzhou_rb)
    RadioButton hangzhouRb;
    @BindView(R.id.main_top_rg)
    RadioGroup mainTopRg;
    @BindView(R.id.beijing_rb)
    RadioButton beijingRb;
    @BindView(R.id.shenzhen_rb)
    RadioButton shenzhenRb;
    @BindView(R.id.main_bottom_rg)
    RadioGroup mainBottomRg;
    @BindView(R.id.main_bottom_fl)
    FrameLayout mainBottomFl;
    @BindView(R.id.change_fa)
    FloatingActionButton changeFa;


    private boolean mIsChangeTopOrBottom;
    private IMainContract.Presenter mPresenter;

    @Override
    protected void afterBindView() {
        initPresenter();
        initFragment();
        changeAnime(mainBottomRg, mainTopRg);
        initCheckListener();
    }

    private void initPresenter() {
        mPresenter = new MainActivityPresenter(this);
    }


    /**
     * 初始化Fragment
     */
    private void initFragment() {
        mPresenter.initFragment();
    }

    private void initCheckListener() {
//        shanghaiRb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (shanghaiRb.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
//            }
//        });
//
//        hangzhouRb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (hangzhouRb.getId() == mPresenter.getCurrentCheckedId()) {
//                    return;
//                }
//                mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
//            }
//        });

        mainTopRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.shanghai_rb:
                        mPresenter.replaceFragment(MainConstantTool.SHANGHAI);
                        break;
                    case R.id.hangzhou_rb:
                        mPresenter.replaceFragment(MainConstantTool.HANGZHOU);
                        break;
                }
            }
        });

        mainBottomRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == mPresenter.getCurrentCheckedId()) {
                    return;
                }
                switch (checkedId) {
                    case R.id.beijing_rb:
                        mPresenter.replaceFragment(MainConstantTool.BEIJING);
                        break;
                    case R.id.shenzhen_rb:
                        mPresenter.replaceFragment(MainConstantTool.SHENZHEN);
                        break;
                }
            }
        });
    }

    @OnClick(R.id.change_fa)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_fa:
                mIsChangeTopOrBottom = !mIsChangeTopOrBottom;
                if (mIsChangeTopOrBottom) {
                    changeAnime(mainTopRg, mainBottomRg);
                    handleTopPosition();
                } else {
                    changeAnime(mainBottomRg, mainTopRg);
                    handleBottomPosition();
                }
                break;
            default:
                break;

        }
    }

    /**
     * 北京 深圳
     */
    private void handleBottomPosition() {
        if (mPresenter.getTopPosition() != 1) {
            mPresenter.replaceFragment(0);
            shanghaiRb.setChecked(true);
        }else {
            mPresenter.replaceFragment(1);
            hangzhouRb.setChecked(true);
        }
    }

    /**
     * 上海 杭州
     */
    private void handleTopPosition() {
        if (mPresenter.getBottomPosition() != 3) {
            mPresenter.replaceFragment(2);
            beijingRb.setChecked(true);
        }else {
            mPresenter.replaceFragment(3);
            shenzhenRb.setChecked(true);
        }
    }

    private void changeAnime(RadioGroup gone, RadioGroup show) {
        // 消失的动画
        gone.clearAnimation();
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.main_gone_anim);
        gone.startAnimation(animation);
        gone.setVisibility(View.GONE);

        // 显示的动画
        show.clearAnimation();
        animation = AnimationUtils.loadAnimation(this, R.anim.main_show_anim);
        show.startAnimation(animation);
        show.setVisibility(View.VISIBLE);
    }


    @Override
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().add(R.id.main_top_fl, fragment).commit();
    }

    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().show(fragment).commit();
    }

    @Override
    public void hideFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().hide(fragment).commit();
    }
}
