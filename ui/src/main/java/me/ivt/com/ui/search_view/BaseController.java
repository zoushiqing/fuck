package me.ivt.com.ui.search_view;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.LinearInterpolator;
import android.widget.SearchView;

/**
 * desc:
 */
public abstract class BaseController {
    public abstract void draw(Canvas canvas, Paint paint);
    
    private float mpro = -1;
    
    public void startAnim() {
    }
    
    public void resetAnim() {
    }
    
    SearchView mSearchView;
    
    public void setSearchView(SearchView searchView) {
        mSearchView = searchView;
    }
    
    public ValueAnimator startValueAnimator() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(800);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mpro = (float) animation.getAnimatedValue();
                mSearchView.invalidate();
            }
        });
        valueAnimator.start();
        mpro = 0;
        return valueAnimator;
    }
}
