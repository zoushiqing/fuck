package com.fuck.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import android.widget.Toast;

import com.fuck.R;

public class MiddleActivity extends Activity implements OnTouchListener {
	GestureDetector gd;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.main);
		TextView textView = new TextView(this);
		textView.setText("Middle");
		textView.setBackgroundColor(getResources().getColor(R.color.green));
		setContentView(textView);
		textView.setOnTouchListener(this);
		gd = new GestureDetector(this, mFlingListener);
	}

	OnGestureListener mFlingListener = new OnGestureListener() {

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			if (e1.getX() - e2.getX() > FLING_MIN_DISTANCE
					&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {
				Intent intent = new Intent(MiddleActivity.this,
						LeftActivity.class);
				startActivity(intent);
				Toast.makeText(MiddleActivity.this, "向左手势", Toast.LENGTH_SHORT)
						.show();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);

			} else if (e2.getX() - e1.getX() > FLING_MIN_DISTANCE
					&& Math.abs(velocityX) > FLING_MIN_VELOCITY) {

				// 切换Activity
				Intent intent = new Intent(MiddleActivity.this,
						RightActivity.class);
				startActivity(intent);
				Toast.makeText(MiddleActivity.this, "向右手势", Toast.LENGTH_SHORT)
						.show();
				overridePendingTransition(R.anim.in_from_left,
						R.anim.out_to_right);

			}

			return false;
		}

	};

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		v.performClick();
		return gd.onTouchEvent(event);
	}
}