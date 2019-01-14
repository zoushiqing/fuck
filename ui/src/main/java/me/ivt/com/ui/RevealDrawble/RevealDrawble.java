package me.ivt.com.ui.RevealDrawble;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

/**
 * desc:
 */
public class RevealDrawble extends Drawable {
    Drawable mUnSlectedDrawble;
    Drawable mSlectedDrawble;
    private  int oritation;
    
    public RevealDrawble(Drawable unSlectedDrawble, Drawable slectedDrawble, int oritation) {
        mUnSlectedDrawble = unSlectedDrawble;
        mSlectedDrawble = slectedDrawble;
        this.oritation = oritation;
    }
    
    @Override
    public void draw(Canvas canvas) {
        int level = getLevel();
        
    
        //得到当前drawble自身的rect
        Rect bounds = getBounds();
        
        //得到左边的矩形区域
        Rect rectLeft=new Rect();
        Gravity.apply(Gravity.LEFT,bounds.width()/2,bounds.height(),bounds,rectLeft);//int gravity, int w, int h, Rect container, Rect outRect
        //得到右边的矩形区域
        Rect rectRight=new Rect();
        Gravity.apply(Gravity.RIGHT,bounds.width()/2,bounds.height(),bounds,rectRight);//int gravity, int w, int h, Rect container, Rect outRect
        
        canvas.save();
        canvas.clipRect(rectLeft);
        mUnSlectedDrawble.draw(canvas);
        canvas.restore();
    
        canvas.save();
        canvas.clipRect(rectRight);
        mSlectedDrawble.draw(canvas);
        canvas.restore();
        
        
    }
    
    @Override
    protected boolean onLevelChange(int level) {
        //level ：0~10000
        invalidateSelf();
        
        return true;
    }
    
    @Override
    protected void onBoundsChange(Rect bounds) {
        //定好两个drawable图片的宽高
        mUnSlectedDrawble.setBounds(bounds);
        mSlectedDrawble.setBounds(bounds);
    }
    
    @Override
    public void setAlpha(int alpha) {
        
    }
    
    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        
    }
    
    @SuppressLint("WrongConstant")
    @Override
    public int getOpacity() {
        return 0;
    }
}
