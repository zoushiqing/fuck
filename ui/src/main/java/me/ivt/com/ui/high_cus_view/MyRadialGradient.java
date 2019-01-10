package me.ivt.com.ui.high_cus_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc:
 */
public class MyRadialGradient extends View {
    
    private Paint mPaint;
    
    public MyRadialGradient(Context context) {
        super(context);
        init();
    }
    
    public MyRadialGradient(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    
    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
    }
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        RadialGradient radialGradient=new RadialGradient(w/2,h/2,100,0xffff0000,0xff00ff00, Shader.TileMode.REPEAT);
        mPaint.setShader(radialGradient);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth()/2,getHeight()/2,100,mPaint);
    }
}
