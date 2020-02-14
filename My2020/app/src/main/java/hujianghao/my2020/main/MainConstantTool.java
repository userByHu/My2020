package hujianghao.my2020.main;


import androidx.annotation.IntDef;

/**
 * Created by anson on 2018/11/18.
 */
@IntDef({MainConstantTool.SHANGHAI, MainConstantTool.HANGZHOU, MainConstantTool.BEIJING, MainConstantTool.SHENZHEN})
public @interface MainConstantTool {
    int SHANGHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}
