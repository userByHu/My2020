package hujianghao.my2020;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.OnClick;


@ViewInject(mainlayoutid = R.layout.activity_main)
public class MainActivity extends BaseActivity {


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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeAnime(mainBottomRg, mainTopRg);
    }

    @OnClick(R.id.change_fa)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.change_fa:
                mIsChangeTopOrBottom = !mIsChangeTopOrBottom;
                if (mIsChangeTopOrBottom) {
                    changeAnime(mainTopRg, mainBottomRg);
                }else {
                    changeAnime(mainBottomRg, mainTopRg);
                }
                break;
            default:
                break;

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


}
