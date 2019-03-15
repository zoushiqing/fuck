package me.ivt.com.ui.paint;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import me.ivt.com.ui.R;

/**
 * desc:
 */
public class CustomProgressBar extends View {
    public CustomProgressBar(Context context) {
        super(context);
    }
    
    public CustomProgressBar(Context context,  AttributeSet attrs) {
        super(context, attrs);
        context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar);
        
    }
}
