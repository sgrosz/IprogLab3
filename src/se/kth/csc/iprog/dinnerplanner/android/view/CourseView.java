package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseView {
	View view;
	DinnerModel model;
	int dishType;
	MenuHeaderView menuHeaderView;

	public CourseView(View view, final DinnerModel model, int dishType,
			final Activity activity) {
		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		this.dishType = dishType;
		
		// Create the header view, which needs to be controlled from the dialog view as well
		menuHeaderView = new MenuHeaderView(activity.findViewById(R.layout.menu_header_view), model, activity);

		// Setup the rest of the view layout
		TextView header = (TextView) view.findViewById(R.id.course_type_header);
		header.setText(Dish.getTypeString(dishType));
		Set<Dish> dishes = model.getDishesOfType(dishType);
		LinearLayout container = (LinearLayout) view
				.findViewById(R.id.course_container);
		for (Dish dish : dishes) {
			LinearLayout courseElement = (LinearLayout) View.inflate(
					activity.getBaseContext(), R.layout.course_element, null);
			container.addView(courseElement, 0);
			final ImageView image = (ImageView) view
					.findViewById(R.id.course_image);
			final Dish dishForDialog = dish;
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

			image.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					DialogView dialogView = new DialogView(activity
							.findViewById(R.layout.dialog_view), activity,
							model, dishForDialog, menuHeaderView);
				}
			});
			TextView name = (TextView) view.findViewById(R.id.course_name);
			image.setImageResource(dish.getImage());
			name.setText(dish.getName());
		}
	}
}
