package me.ivt.com.ui.RevealDrawble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc:
 */
public class MyView extends View {
    
    private Paint mPaint;
    
    public MyView(Context context) {
        super(context);
        mPaint = new Paint();
    }
    
    public MyView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLUE);
        //保存当前画布状态（保存到栈里面）
        canvas.save();
        canvas.clipRect(new Rect(100,100,800,800));
        canvas.drawColor(Color.RED);
        canvas.save();
        //恢复画布状态
        canvas.restore();
        Paint paint=new Paint();
        paint.setColor(Color.YELLOW);
        canvas.drawCircle(100,100,100,paint);
        
        canvas.restore();
        paint.setColor(Color.GREEN);
        canvas.drawCircle(150,150,100,paint);
    
    }
}
