package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.controller.CourseViewController;

import se.kth.csc.iprog.dinnerplanner.android.controller.CreateButtonViewController;
import se.kth.csc.iprog.dinnerplanner.android.controller.MenuHeaderViewController;
import se.kth.csc.iprog.dinnerplanner.android.view.CourseView;
import se.kth.csc.iprog.dinnerplanner.android.view.CreateButtonView;
import se.kth.csc.iprog.dinnerplanner.android.view.MenuHeaderView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.app.Activity;
import android.os.Bundle;

public class MenuActivity extends Activity {
	MenuHeaderView menuHeaderView;
	MenuHeaderViewController mhvc;
	CreateButtonView createButtonView;
	CreateButtonViewController cbvc;
	DinnerModel model;
	CourseView courseView1;
	CourseView courseView2;
	CourseView courseView3;
	CourseViewController controller1;
	CourseViewController controller2;
	CourseViewController controller3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		model = ((DinnerPlannerApplication) this.getApplication()).getModel();

		// Create the view instances
		createButtonView = new CreateButtonView(
				findViewById(R.layout.create_button_view), model, this);
		cbvc = new CreateButtonViewController(createButtonView);
		courseView1 = new CourseView(findViewById(R.id.course_view_1), model,
				Dish.STARTER, this);
		controller1 = new CourseViewController(model, courseView1);
		courseView2 = new CourseView(findViewById(R.id.course_view_2), model,
				Dish.MAIN, this);
		controller2 = new CourseViewController(model, courseView2);
		courseView3 = new CourseView(findViewById(R.id.course_view_3), model,
				Dish.DESSERT, this);
		controller3 = new CourseViewController(model, courseView3);
		menuHeaderView = new MenuHeaderView(findViewById(R.layout.menu_header_view), model, this);
		mhvc = new MenuHeaderViewController(model, menuHeaderView);
	}

}
