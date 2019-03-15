package me.ivt.com.ui.high_cus_view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import me.ivt.com.ui.R;

/**
 * desc:
 */
public class ZoomImageview extends View {
    
    private Bitmap mBitmap;
    private static final int FACTOR = 3;
    private static final int BOUNDS = 100;
    private ShapeDrawable mShapeDrawable;
    
    public ZoomImageview(Context context) {
        super(context);
        setEnabled(true);
        setClickable(true);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon2);
        Bitmap bmp = mBitmap;
        //放大后的图片
        bmp = Bitmap.createScaledBitmap(bmp, bmp.getWidth() * 3, bmp.getHeight() * 3, true);
    
        BitmapShader bitmapShader = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    
        mShapeDrawable = new ShapeDrawable(new OvalShape());
        mShapeDrawable.getPaint().setShader(bitmapShader);
        mShapeDrawable.setBounds(0, 0, BOUNDS * 2, BOUNDS * 2);
    }
    
    public ZoomImageview(Context context, AttributeSet attrs) {
        super(context, attrs);
      
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, null);
        mShapeDrawable.draw(canvas);
        super.onDraw(canvas);
    }
    
    Matrix mMatrix = new Matrix();
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                int x = (int) event.getX()-200;
                int y = (int) event.getY()-200;
                mMatrix.setTranslate(BOUNDS - x * FACTOR, BOUNDS - y * FACTOR);
                mShapeDrawable.getPaint().getShader().setLocalMatrix(mMatrix);
                mShapeDrawable.setBounds(x - BOUNDS, y - BOUNDS, x + BOUNDS, y + BOUNDS);
                invalidate();
                break;
        }
        return super.onTouchEvent(event);
    }
}
