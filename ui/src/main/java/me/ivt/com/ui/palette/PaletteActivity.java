package me.ivt.com.ui.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.TextView;

import me.ivt.com.ui.R;

public class PaletteActivity extends AppCompatActivity {
    private ImageView mImgv;
    private TextView mTitle;
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;
    private TextView mTv5;
    private TextView mTv6;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palette);
        mImgv = (ImageView) findViewById(R.id.imgv);
        mTitle = (TextView) findViewById(R.id.title);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTv3 = (TextView) findViewById(R.id.tv3);
        mTv4 = (TextView) findViewById(R.id.tv4);
        mTv5 = (TextView) findViewById(R.id.tv5);
        mTv6 = (TextView) findViewById(R.id.tv6);
        
        BitmapDrawable bitmapDrawable = (BitmapDrawable) mImgv.getDrawable();
        Bitmap bitmap = bitmapDrawable.getBitmap();
        //得到bitmap里面的一些色彩信息----通过palette类分析出来的
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                if (palette == null) {
                    return;
                }
                //亮 柔和
                int lightMutedColor = palette.getLightMutedColor(Color.YELLOW);
                //暗 柔和
                int darkMutedColor = palette.getDarkMutedColor(Color.YELLOW);
                
                //亮 鲜艳
                int lightVibrantColor = palette.getLightVibrantColor(Color.YELLOW);
                //暗 鲜艳
                int darkVibrantColor = palette.getDarkVibrantColor(Color.YELLOW);
                
                //柔和
                int mutedColor = palette.getMutedColor(Color.YELLOW);
                //鲜艳
                int vibrantColor = palette.getVibrantColor(Color.YELLOW);
                
                Palette.Swatch vibrantSwatch = palette.getVibrantSwatch();
                int rgb = vibrantSwatch.getRgb();//主色调
                int red = Color.red(rgb);
                System.out.println("red = " + red);
                int green = Color.green(rgb);
                System.out.println("green = " + green);
                int blue = Color.blue(rgb);
                System.out.println("blue = " + blue);
    
                int bodyTextColor = vibrantSwatch.getBodyTextColor();//图片中间文字的推荐颜色
                vibrantSwatch.getTitleTextColor();//作为标题的推荐颜色
                
                int population = vibrantSwatch.getPopulation();//分析该颜色在图片中的像素值是多少
    
                float[] hsl = vibrantSwatch.getHsl();//颜色向量
                
                mTitle.setTextColor(bodyTextColor);
                mTitle.setBackgroundColor(getTranslationsColor(0.5f, rgb));
                
                
                mTv1.setText("亮 柔和lightMutedColor");
                mTv1.setBackgroundColor(lightMutedColor);
                mTv2.setText("暗 柔和darkMutedColor");
                mTv2.setBackgroundColor(darkMutedColor);
                
                mTv3.setText("亮 鲜艳lightVibrantColor");
                mTv3.setBackgroundColor(lightVibrantColor);
                mTv4.setText("暗 鲜艳darkVibrantColor");
                mTv4.setBackgroundColor(darkVibrantColor);
                
                mTv5.setText("柔和mutedColor");
                mTv5.setBackgroundColor(mutedColor);
                mTv6.setText("鲜艳vibrantColor");
                mTv6.setBackgroundColor(vibrantColor);
            }
        });
    }
    
    private int getTranslationsColor(float percent, int rgb) {
//        int blue = Color.blue(rgb);
//        int green = Color.green(rgb);
//        int red = Color.red(rgb);
//        int alpha = Color.alpha(rgb);
        
        int b = rgb & 0xff;
        int g = rgb >> 8 & 0xff;
        int r = rgb >> 16 & 0xff;
        int a = rgb >>> 24;
        a = Math.round(percent * a);
        return Color.argb(a, r, g, b);
    }
}
