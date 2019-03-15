package me.ivt.com.ui.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import me.ivt.com.ui.R;

/**
 * desc:
 */
public class MaskFilterView extends View {
    public MaskFilterView(Context context) {
        super(context);
    }
    
    public MaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
//        
//        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
//        paint.setColor(Color.RED);
//        Rect rect = new Rect(0, 0, 300, 300);
        /**模糊遮罩滤镜效果
         * BlurMaskFilter.Blur.SOLID
         * BlurMaskFilter.Blur.INNER
         * BlurMaskFilter.Blur.NORMAL
         * BlurMaskFilter.Blur.OUTER
         */
//        paint.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.SOLID));//float radius, Blur style
        /**
         * 浮雕滤镜效果(实现凸起的立体效果)
         * direction:指定长度xx的数组标量[x,y,z]用来指定光源的位置
         * ambient:指定周边背景光源(0~1)
         * specular:镜面反射系数
         * blurRadius:指定模糊半径
         */
//        paint.setMaskFilter(new EmbossMaskFilter(new float[]{30,30,30},0.5f,10,20));//float[] direction, float ambient, float specular, float blurRadius
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon2);
//        
////        canvas.drawRect(rect, paint);
//        canvas.drawBitmap(bitmap,100,300,paint);//Bitmap bitmap, float left, float top, Paint paint

//        ============================================================================================
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 400, 400 * bitmap.getHeight() / bitmap.getWidth()), paint);
        canvas.translate(400, 0);
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                0, 0, 0, 0, 0,
//                0, 1, 0, 0, 200,
//                0, 0, 1, 0, 0,
//                0, 0, 0, 1, 0,
//        });
        //反相效果
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                -1, 0, 0, 0, 255,
//                0, -1, 0, 0, 255,
//                0, 0, -1, 0, 255,
//                0, 0, 0, 1, 0,
//        });
        //颜色增强
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1.4f, 0, 0, 0, 0,
//                0, 1.4f, 0, 0, 0,
//                0, 0, 1.4f, 0, 0,
//                0, 0, 0, 1.4f, 0,
//        });
        //处理图片为黑白图片(图像学：三色素加起来=1)
        
        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0.213f, 0.715f, 0.072f, 0, 0,
                0, 0, 0, 1, 0,
        });
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 400, 400 * bitmap.getHeight() / bitmap.getWidth()), paint);
    }
}
