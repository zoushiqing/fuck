package me.ivt.com.ui.RevealDrawble;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import me.ivt.com.ui.R;

public class RevealDrawbleActivity extends AppCompatActivity {
    
    private int[] mImgIds = new int[] { //7个
            R.drawable.avft,
            R.drawable.box_stack,
            R.drawable.bubble_frame,
            R.drawable.bubbles,
            R.drawable.bullseye,
            R.drawable.circle_filled,
            R.drawable.circle_outline,
            
            R.drawable.avft,
            R.drawable.box_stack,
            R.drawable.bubble_frame,
            R.drawable.bubbles,
            R.drawable.bullseye,
            R.drawable.circle_filled,
            R.drawable.circle_outline
    };
    private int[] mImgIds_active = new int[] {
            R.drawable.avft_active, R.drawable.box_stack_active, R.drawable.bubble_frame_active,
            R.drawable.bubbles_active, R.drawable.bullseye_active, R.drawable.circle_filled_active,
            R.drawable.circle_outline_active,
            R.drawable.avft_active, R.drawable.box_stack_active, R.drawable.bubble_frame_active,
            R.drawable.bubbles_active, R.drawable.bullseye_active, R.drawable.circle_filled_active,
            R.drawable.circle_outline_active
    };
    public Drawable[] revealDrawables;
    protected int level = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ImageView imageView = new ImageView(this);
        Drawable unSelected = getResources().getDrawable(R.drawable.avft);
        Drawable selected = getResources().getDrawable(R.drawable.avft_active);
        imageView.setImageDrawable(new RevealDrawble(unSelected, selected, 1));
        setContentView(imageView);
        imageView.setImageDrawable(revealDrawables[0]);
        imageView.setImageLevel(level);
        imageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				level -= 1000;
                imageView.getDrawable().setLevel(level );
			}
		});
    }
}
