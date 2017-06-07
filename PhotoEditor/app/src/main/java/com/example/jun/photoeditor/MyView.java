package com.example.jun.photoeditor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MyView extends View {

    Bitmap image;
    Paint paint;
    private ArrayList<PointF> points;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint();
        paint.setColor(Color.BLACK);

    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setPoints(ArrayList<PointF> points) {
        this.points = points;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        if (image != null) {
            int width = image.getWidth();
            int height = image.getHeight();
            float ratioBitmap = (float) width / (float) height;
            float ratioMax = (float) canvas.getWidth() / (float) canvas.getHeight();

            int finalWidth = canvas.getWidth();
            int finalHeight = canvas.getHeight();
            if (ratioMax > 1) {
                finalWidth = (int) ((float)canvas.getHeight() * ratioBitmap);
            } else {
                finalHeight = (int) ((float)canvas.getWidth() / ratioBitmap);
            }
            image = Bitmap.createScaledBitmap(image, finalWidth, finalHeight, true);
            canvas.drawBitmap(image, (canvas.getWidth() / 2 - finalWidth / 2),
                    (canvas.getHeight() / 2 - finalHeight / 2), null);
        }

        if (points != null) {
            for (PointF point : points) {
                RectF rect = new RectF(point.x, point.y, point.x + 10, point.y + 10);
                canvas.drawRect(rect, paint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }
}
