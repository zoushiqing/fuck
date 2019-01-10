package me.ivt.com.ui.filter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import me.ivt.com.ui.R;

public class FilterActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvPhoto;
    private GridLayout mMatrixLayout;
    private Button mBtnChange;
    private Button mBtnReset;
    
    
    private Bitmap bitmap;
    int mEditTextWidth;
    int mEditTextHight;
    private EditText[] mEdts = new EditText[20];
    private float[] mColorMatrix = new float[20];
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.icon2);
        mIvPhoto = (ImageView) findViewById(R.id.iv_photo);
        mMatrixLayout = (GridLayout) findViewById(R.id.matrix_layout);
        mBtnChange = (Button) findViewById(R.id.btn_change);
        mBtnReset = (Button) findViewById(R.id.btn_reset);
        mBtnChange.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);
        mIvPhoto.setImageBitmap(bitmap);
        //我们无法在onCreate方法中获取视图的宽高，所以通过View 的post方法 在视图创建完毕后获得其宽高值
        mMatrixLayout.post(new Runnable() {
            @Override
            public void run() {
                mEditTextWidth = mMatrixLayout.getWidth() / 5;
                mEditTextHight = mMatrixLayout.getHeight() / 4;
                addEdts();
                initMatrix();
            }
        });
    }
    
    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mEdts[i].setText(String.valueOf(1));
            } else {
                mEdts[i].setText(String.valueOf(0));
            }
        }
    }
    
    private void addEdts() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(this);
            editText.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_DECIMAL);
            mEdts[i] = editText;
            mMatrixLayout.addView(editText, mEditTextWidth, mEditTextHight);
        }
    }
    
    private void getMatrix() {
        for (int i = 0; i < 20; i++) {
            String matrix = mEdts[i].getText().toString();
            boolean isNone = null == matrix || "".equals(matrix);
            mColorMatrix[i] = isNone ? 0.0f : Float.valueOf(matrix);
            if (isNone) {
                mEdts[i].setText("0");
            }
        }
    }
    
    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        ColorMatrix colorMatrix = new ColorMatrix();
        
        colorMatrix.set(mColorMatrix);//设置矩阵值
//        colorMatrix.setRotate();//设置色调
//        colorMatrix.setSaturation();//设置饱和度
//        colorMatrix.setScale();//设置亮度
        
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        
        mIvPhoto.setImageBitmap(bmp);
    }
    
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_change:
                break;
            case R.id.btn_reset:
                initMatrix();
                break;
        }
        getMatrix();
        setImageMatrix();
    }
}
