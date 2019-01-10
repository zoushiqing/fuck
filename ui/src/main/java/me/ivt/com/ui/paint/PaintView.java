package me.ivt.com.ui.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc:
 */
public class PaintView extends View {
    
    private Paint mPaint;
    
    public PaintView(Context context) {
        super(context);
    }
    
    public PaintView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //重置
        mPaint.reset();
        mPaint.setColor(Color.RED);
//        mPaint.setAlpha(255);
        
//        mPaint.setStyle(Paint.Style.FILL);//填充  如果是个圆的话  会将里面填充起来
        mPaint.setStyle(Paint.Style.STROKE);//描边  
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);//填充并描边
        //画笔的宽度
        mPaint.setStrokeWidth(10);    
        
        //设置线帽
        mPaint.setStrokeCap(Paint.Cap.ROUND);//圆形
//        mPaint.setStrokeCap(Paint.Cap.BUTT);//没有
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);//方形
        
//        mPaint.setStrokeJoin(Paint.Join.MITER);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);
     
        //测试1
        Path path=new Path();
        path.moveTo(100,100);
        path.lineTo(300,100);
        path.lineTo(100,300);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path,mPaint);
    
        path.moveTo(100,400);
        path.lineTo(300,500);
        path.lineTo(100,700);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path,mPaint);
    
        path.moveTo(100,800);
        path.lineTo(300,800);
        path.lineTo(100,1100);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path,mPaint);
        
        String  str="老子就是邹世清Abcd";
        
        float measureText = mPaint.measureText(str);//获得额文本的宽度，是一个比较粗略的结果
        
        float[] mesauredWidth=new float[10];
        int textWidths = mPaint.getTextWidths(str, mesauredWidth);//获取文本的宽度， 是一个标记精准的结果
    
        Paint.FontMetrics fontMetrics=mPaint.getFontMetrics();
        float top = fontMetrics.top;
        float ascent = fontMetrics.ascent;
        float descent = fontMetrics.descent;
        float bottom = fontMetrics.bottom;
        
    
    }
}
