package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class WelcomeView {
	View view;
	public final Activity activity;
	public Button button;

	public WelcomeView(View view, final Activity activity) {

		// store in the class the reference to the Android View
		this.view = view;
		this.activity = activity;

		// Setup the rest of the view layout
		
		button = (Button) activity.findViewById(R.id.start_button);

	}
	
}
