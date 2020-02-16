package com.hu.myknowage.animation;

import android.animation.TypeEvaluator;

public class CharEvaluator implements TypeEvaluator<Character> {

    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int start =  (int)startValue;
        int end =  (int) endValue;
        int curInt = (int) (start + fraction * (end - start));
        char result = (char) curInt;

        return result;
    }
}
