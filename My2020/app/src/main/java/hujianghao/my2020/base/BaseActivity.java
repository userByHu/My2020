package hujianghao.my2020.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import hujianghao.my2020.mvp.view.LifeCircleMvpActivity;

public abstract class BaseActivity extends LifeCircleMvpActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if(annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if(mainlayoutid > 0){
                setContentView(mainlayoutid);
                bindView();
                afterBindView();

            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation is n ull");
        }
    }

    protected abstract void afterBindView();

    private void bindView() {
        ButterKnife.bind(this);
    }
}
