package me.ivt.com.ui.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import me.ivt.com.ui.R;

/**
 * desc:
 */
public class MyFilter extends View {
    public MyFilter(Context context) {
        super(context);
    }
    
    public MyFilter(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon2);
        //需要关闭硬件加速，
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);//开启抗锯齿
        
    }
}
