package hujianghao.my2020;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class SplashActivity extends AppCompatActivity {

    private VideoView mPlayVv;
    private TextView mIgnoreTv;
    private CustomCountDownTimer mCustomCountDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mPlayVv = findViewById(R.id.play_vv);

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


        mIgnoreTv = findViewById(R.id.ignore_tv);
        mIgnoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.equals(mIgnoreTv.getText(),"完成")){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                    finish();
                }else {
                    Toast.makeText(SplashActivity.this,"不可点击",Toast.LENGTH_LONG).show();
                }

            }
        });

        mCustomCountDownTimer = new CustomCountDownTimer(3, new CustomCountDownTimer.Callback() {
            @Override
            public void onTicker(int time) {
                mIgnoreTv.setText(time + "秒");
            }

            @Override
            public void onFinish() {
                mIgnoreTv.setText( "完成");
            }
        });

        mCustomCountDownTimer.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCustomCountDownTimer.cancel();
    }
}
