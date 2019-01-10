package me.ivt.com.ui.qq_sliding_menu;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class SlidingMenu extends HorizontalScrollView {

	private int mScreenWidth;
	private ViewGroup mMenu;
	private ViewGroup mMain;
	private int mMenuRightPadding = 100;
	private int mMenuWidth;
	private boolean isOnce;

	public SlidingMenu(Context context, AttributeSet attrs) {
		super(context, attrs);
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		DisplayMetrics outMetrics = new DisplayMetrics();
		wm.getDefaultDisplay().getMetrics(outMetrics );
		mScreenWidth = outMetrics.widthPixels;
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// 
		if(!isOnce){
			LinearLayout wrapper = (LinearLayout) getChildAt(0);
			mMenu = (ViewGroup) wrapper.getChildAt(0);
			mMain = (ViewGroup) wrapper.getChildAt(1);
			
			mMenuWidth = mScreenWidth - mMenuRightPadding;
			mMenu.getLayoutParams().width = mMenuWidth;
			mMain.getLayoutParams().width = mScreenWidth;
		}
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}
	
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		//
		if(changed){
			this.scrollTo(mMenuWidth, 0);
			isOnce = true;
		}
		super.onLayout(changed, l, t, r, b);
	}
	
	float downX;
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		int action = ev.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			downX = ev.getX();
			break;
		case MotionEvent.ACTION_UP:
			float dx = ev.getX() - downX;
			if(dx<mScreenWidth/3){
				this.smoothScrollTo(mMenuWidth, 0);
			}else{
				this.smoothScrollTo(0, 0);
			}
			return true;

		default:
			break;
		}
		
		return super.onTouchEvent(ev);
	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		// TODO Auto-generated method stub
		super.onScrollChanged(l, t, oldl, oldt);
		
	}
	
}
