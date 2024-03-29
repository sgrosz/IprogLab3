package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CourseView implements Observer {
	View view;
	DinnerModel model;
	int dishType;
	MenuHeaderView menuHeaderView;
	public Activity activity;
	public Map<ImageView, Dish> dishImages = new HashMap<ImageView, Dish>();

	public CourseView(View view, final DinnerModel model, int dishType,
			final Activity activity) {
		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;
		this.dishType = dishType;
		this.activity = activity;
		

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
			dishImages.put(image, dish);

			TextView name = (TextView) view.findViewById(R.id.course_name);
			image.setImageResource(dish.getImage());
			name.setText(dish.getName());
		}
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}
}
