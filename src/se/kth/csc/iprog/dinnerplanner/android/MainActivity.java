package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.WelcomeView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	WelcomeView welcomeView;
	DinnerModel model;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// Default call to load previous state
		super.onCreate(savedInstanceState);

		model = ((DinnerPlannerApplication) this.getApplication()).getModel();

		// Set the view for the main activity screen
		// it must come before any call to findViewById method
		setContentView(R.layout.activity_main);
		// Creating the menu header instance
		welcomeView = new WelcomeView(findViewById(R.layout.welcome_view), this);
	}

}
