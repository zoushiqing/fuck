package me.ivt.com.ui.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * desc:
 */
public class MyView extends View {
    public MyView(Context context) {
        super(context);
    }
    
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
    
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制直线
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(15);
//        canvas.drawLine(0,0,100,100,paint);//float startX, float startY, float stopX, float stopY,@NonNull Paint paint

//        float pts[]={0,0,100,100,100,100,200,300};
//        canvas.drawLines(pts,paint);//float[] pts,  Paint paint

//        canvas.drawPoint(500,500,paint);//float x, float y,  Paint paint

//        canvas.drawPoints();//float[] pts, @NonNull Paint paint

//        RectF rect = new RectF(100, 100, 200, 300);
//        canvas.drawRect(rect,paint);//float型：RectF rect, @NonNull Paint paint 或者 int型：Rect rect, @NonNull Paint paint
        
        //圆角矩形
//        canvas.drawRoundRect(rect,30,30,paint);//RectF rect, float rx, float ry, @NonNull Paint paint

//        canvas.drawCircle(300,300,200,paint);//float cx, float cy, float radius, @NonNull Paint paint

//        canvas.drawOval(rect,paint);//RectF oval, @NonNull Paint paint

//        canvas.drawArc(rect,0,90,true,paint);//RectF oval, float startAngle 起始角度, float sweepAngle 画多少度, boolean useCenter 是否链接起来 true会闭合,@NonNull Paint paint

//        Path path = new Path();
//        path.moveTo(100, 100);
//        path.lineTo(200, 100);
//        path.lineTo(200, 200);
//        path.lineTo(100, 200);
//        path.close();
//        canvas.drawPath(path, paint);

//        float radii[]={10,10,10,10,10,10,50,60};
//        path.addRoundRect(rect,radii,Path.Direction.CW);//RectF rect, float[] radii, Direction dir
//        canvas.drawPath(path,paint);

//        Region region = new Region(100, 100, 200, 200);//创建一块矩形区域
//        RegionIterator regionIterator = new RegionIterator(region);
//        Rect rect = new Rect();
//        while (regionIterator.next(rect)) {
//            canvas.drawRect(rect, paint);
//        }
        
        //1.平移translate
//        RectF rectF = new RectF(0, 0, 400, 500);
//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        canvas.translate(50, 50);
//        //a.会建一个新的画布 来画
//        canvas.drawRect(rectF, paint);
//        //b.任然会沿用平移之后的画布
//        paint.setColor(Color.RED);
//        paint.setStrokeWidth(3);
//        canvas.drawRect(rectF, paint);
        
        // 2.缩放Scale
//        RectF rectF = new RectF(0, 0, 400, 500);
//        canvas.drawRect(rectF, paint);
//        paint.setColor(Color.BLUE);
//        //a.画布的缩放 会导致里面所有的东西都会缩放
//        canvas.scale(0.5f,1);//float sx:x方向的缩放系数, float sy, float px, float py
//        canvas.drawRect(rectF,paint);
        //3.旋转Rotate
        RectF rectF = new RectF(0, 0, 400, 500);
        canvas.drawRect(rectF, paint);
        paint.setColor(Color.BLUE);
        canvas.rotate(60);
        canvas.drawRect(rectF, paint);
        //4.斜拉画布Skew
        //5.裁剪画布Clip
    }
    Drawable mDrawable;
}
