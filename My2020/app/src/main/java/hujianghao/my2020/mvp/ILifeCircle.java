package hujianghao.my2020.mvp;

import android.content.Intent;
import android.os.Bundle;

public interface ILifeCircle {

    void onCreate(Bundle savedInstanceState, Intent intent,Bundle getArguments);

    void onActivityCreated(Bundle savedInstanceState, Intent intent, Bundle getArguments);

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void destroyView();

    void onViewDestroy();

    void onDestroy();

    void onNewIntent(Intent intent);

    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onSaveInstanceState(Bundle bundle);

}
