package hujianghao.my2020.splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import hujianghao.my2020.base.BaseActivity;
import hujianghao.my2020.main.MainActivity;
import hujianghao.my2020.R;
import hujianghao.my2020.base.ViewInject;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends BaseActivity implements ISplashContract.IView {

    @BindView(R.id.play_vv)
    FullScreenVideoView mPlayVv;
    @BindView(R.id.ignore_tv)
    TextView mIgnoreTv;

    private ISplashContract.Presenter mSplashPresenter;


    @Override
    protected void afterBindView() {
        initTimerPresenter();
        initVideoView();
        Log.e("test git","111111111");
    }

    private void initTimerPresenter() {
        mSplashPresenter = new SplashPresenter(this);
        mSplashPresenter.initCountDownTimer();
    }


    private void initVideoView() {
        mPlayVv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + File.separator + R.raw.splash));
        mPlayVv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mPlayVv.start();
            }
        });

        mPlayVv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                mPlayVv.start();
            }
        });
    }


    @OnClick(R.id.ignore_tv)
    public void onViewClicked() {
        if (TextUtils.equals(mIgnoreTv.getText(), "跳过")) {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(SplashActivity.this, "不可点击", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void setTvTimerText(String s) {
        mIgnoreTv.setText(s);
    }
}
