package se.kth.csc.iprog.dinnerplanner.android.controller;

import se.kth.csc.iprog.dinnerplanner.android.DialogActivity;
import se.kth.csc.iprog.dinnerplanner.android.view.CourseView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class CourseViewController implements OnClickListener{
	
	DinnerModel model;
	CourseView view;
	ImageView image;
	
	public CourseViewController(DinnerModel model, CourseView view){
		this.model = model;
		this.view = view;
		
		for(final ImageView image : view.dishImages.keySet()){
			// Only creates visual feedback when tapping the image.
			image.setOnTouchListener(new OnTouchListener() {

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						image.setColorFilter(Color.parseColor("#EDEDCC"),
								Mode.SCREEN);
						break;
					case MotionEvent.ACTION_UP:
						image.clearColorFilter();
						break;
					case MotionEvent.ACTION_CANCEL:
						image.clearColorFilter();
						break;
					}
					return false;
				}
			});
			image.setOnClickListener(this);
		}
	}

	@Override
	public void onClick(View v) {
		image = (ImageView) v;
		Dish dish = view.dishImages.get(image);
		model.setClickedDish(dish);
		
		Intent intent = new Intent(view.activity, DialogActivity.class);
		view.activity.startActivity(intent);
	}

}
