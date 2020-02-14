package hujianghao.my2020.splash;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable{


    private  int time;
    private final Callback callback;

    private Handler handler;
    private boolean isRun;

    public CustomCountDownTimer(int time, Callback callback) {
        this.time = time;
        this.callback = callback;


        handler = new Handler();
    }

    public void start() {
        if(callback == null){
            return;
        }
        isRun = true;
        handler.post(this);
    }

    public void cancel() {
        isRun = false;
        handler.removeCallbacks(this);
    }

    @Override
    public void run() {
        if(isRun){
            callback.onTicker(time);

            if(time == 0){
                callback.onFinish();
            }else {
                time--;
                handler.postDelayed(this,1000);
            }
        }
    }

    interface Callback {

        // 时时回调
        void  onTicker(int time);

        // 回调结束
        void onFinish();
    }


}
