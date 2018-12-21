package com.fuck.demo;

import android.view.MotionEvent;

/**
 * 必须实现 onFling
 * 
 * @author Chuanhang.Gu
 * 
 */
public class OnGestureListener implements
		android.view.GestureDetector.OnGestureListener {
	final int FLING_MIN_DISTANCE = 50;
	final float FLING_MIN_VELOCITY = 50;

	@Override
	public boolean onDown(MotionEvent e) {
		// 修改为return true， 否者onFling不调用
		// 否则：需要在activity中添加setOnLongclick(true);
		// PS:鄙人理解：存在事件拦截冲突
		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

}
