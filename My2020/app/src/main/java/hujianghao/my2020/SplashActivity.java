package hujianghao.my2020;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import hujianghao.my2020.mvp.view.LifeCircleMvpActivity;

@ViewInject(mainlayoutid = R.layout.activity_splash)
public class SplashActivity extends LifeCircleMvpActivity implements ISplashContract.IView {

    @BindView(R.id.play_vv)
    FullScreenVideoView mPlayVv;
    @BindView(R.id.ignore_tv)
    TextView mIgnoreTv;

    private ISplashContract.Presenter mSplashPresenter;


    @Override
    protected void afterBindView() {
        initTimerPresenter();
        initVideoView();
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
