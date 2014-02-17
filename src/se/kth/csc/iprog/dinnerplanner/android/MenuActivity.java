package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.CourseView;
import se.kth.csc.iprog.dinnerplanner.android.view.CreateButtonView;
import se.kth.csc.iprog.dinnerplanner.android.view.MenuHeaderView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.os.Bundle;

public class MenuActivity extends Activity {
	MenuHeaderView menuHeaderView;
	CreateButtonView createButtonView;
	DinnerModel model;
	CourseView courseView1;
	CourseView courseView2;
	CourseView courseView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		model = ((DinnerPlannerApplication) this.getApplication()).getModel();

		// Create the view instances
		createButtonView = new CreateButtonView(
				findViewById(R.layout.create_button_view), model, this);
		courseView1 = new CourseView(findViewById(R.id.course_view_1), model,
				Dish.STARTER, this);
		courseView2 = new CourseView(findViewById(R.id.course_view_2), model,
				Dish.MAIN, this);
		courseView3 = new CourseView(findViewById(R.id.course_view_3), model,
				Dish.DESSERT, this);
	}

}
