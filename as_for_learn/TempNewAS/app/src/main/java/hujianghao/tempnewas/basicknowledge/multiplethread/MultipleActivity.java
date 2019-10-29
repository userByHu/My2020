package hujianghao.tempnewas.basicknowledge.multiplethread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import hujianghao.tempnewas.R;

public class MultipleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple);
    }

    private static void testStaticPartVar() {
        // static局部变量只被初始化一次，下一次依据上一次结果值

        public int num;
        private int a;
        propect int b;
        static int d;
        int c;
    }
}
