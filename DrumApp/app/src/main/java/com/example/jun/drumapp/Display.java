package com.example.jun.drumapp;

import android.content.Context;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

import android.view.View;

import com.example.rico.drumapp.R;

public class Display extends View {
    public Display(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setBackground(ContextCompat.getDrawable(context, R.drawable.drumimag));
    }

    private PointF getSpecialPoint() {
        return new PointF(getWidth()/5f,getHeight()/2f);
    }

    public Position getPosition(float x, float y){
        if(x<getSpecialPoint().x && y <getSpecialPoint().y){
            return Position.CRASH_LEFT;
        }else if (x<getSpecialPoint().x && y >getSpecialPoint().y){
            return  Position.HI_HAT;
        }else if (x<getSpecialPoint().x*2 && x>getSpecialPoint().x && y>getSpecialPoint().y){
            return  Position.SNARE;

        }
        else {
            return  Position.KICK;
        }
    }
}
