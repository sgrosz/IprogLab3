package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.MenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.R;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class WelcomeView {
	View view;
	final Activity activity;

	public WelcomeView(View view, final Activity activity) {

		// store in the class the reference to the Android View
		this.view = view;
		this.activity = activity;

		// Setup the rest of the view layout
		
		Button button = (Button) activity.findViewById(R.id.start_button);
		//TODO: Set the onClickListener here or in XML file that is passed along in the Main Activity?
		button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(activity, MenuActivity.class);
				activity.startActivity(intent);
				
			}
		});
	}
	
}
