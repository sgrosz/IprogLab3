package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.CreateButtonView;
import se.kth.csc.iprog.dinnerplanner.android.view.DialogView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.os.Bundle;

public class DialogActivity extends Activity {
	DinnerModel model;
	DialogView dialogView;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);

		model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		dialogView = new DialogView(
				findViewById(R.layout.dialog_view), this, model);
	}
}
