package me.ivt.com.ui.search_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc:
 */
public class MySearchView extends View {
    
    private Paint mPaint;
    private BaseController mBaseController;
    
    
    public MySearchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStrokeWidth(5);
        
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mBaseController.draw(canvas, mPaint);
    }
    
    public void setBaseController(BaseController baseController) {
        mBaseController = baseController;
    }
    
    public void startAnimation() {
        if (mBaseController != null) {
            mBaseController.startAnim();
        }
    }
    
    public void resetAnimation() {
        if (mBaseController != null) {
            mBaseController.resetAnim();
        }
    }
    
}
