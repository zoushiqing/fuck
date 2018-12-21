package com.fuck.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

import com.fuck.R;

public class LeftActivity extends Activity implements OnTouchListener {
	GestureDetector gd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setText("Left");
		textView.setBackgroundColor(getResources().getColor(R.color.red));
		textView.setOnTouchListener(this);
		setContentView(textView);
		gd = new GestureDetector(this, mFlingListener);
	}

	OnGestureListener mFlingListener = new OnGestureListener() {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {

			if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
					&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
				// 切换Activity
				Intent intent = new Intent(LeftActivity.this,
						MiddleActivity.class);
				startActivity(intent);
				Toast.makeText(LeftActivity.this, "向右手势", Toast.LENGTH_SHORT)
						.show();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);

			}

			return false;
		}

	};

	public boolean onTouch(android.view.View v, MotionEvent event) {
		v.performClick();
		return gd.onTouchEvent(event);
	};

}
