package hujianghao.my2020.mvp.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import hujianghao.my2020.BaseActivity;
import hujianghao.my2020.mvp.IMvpView;
import hujianghao.my2020.mvp.MvpControler;

public abstract class LifeCircleMvpActivity extends BaseActivity implements IMvpView {

    private MvpControler mMvpControler;

    @Override
    public MvpControler getMvpControler() {
        if(mMvpControler == null){
            mMvpControler = new MvpControler();
        }
        return mMvpControler;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = this.getIntent();
        if(intent==null){
            intent = new Intent();
        }

        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onCreate(savedInstanceState,intent,null);
            mvpControler.onActivityCreated(savedInstanceState,intent,null);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onNewIntent(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onStart();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onStart();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onDestroy();
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onSaveInstanceState(outState);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MvpControler mvpControler = getMvpControler();
        if(mvpControler != null){
            mvpControler.onActivityResult(requestCode,resultCode,data);
        }
    }
}