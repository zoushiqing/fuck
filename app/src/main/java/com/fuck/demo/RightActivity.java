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

public class RightActivity extends Activity implements OnTouchListener {
	GestureDetector gd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
		textView.setBackgroundColor(getResources().getColor(R.color.blue));
		textView.setText("Right");
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
				Intent intent = new Intent(RightActivity.this,
						MiddleActivity.class);
				startActivity(intent);
				Toast.makeText(RightActivity.this, "向左手势", Toast.LENGTH_SHORT)
						.show();
				overridePendingTransition(R.anim.in_from_right,
						R.anim.out_to_left);
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
