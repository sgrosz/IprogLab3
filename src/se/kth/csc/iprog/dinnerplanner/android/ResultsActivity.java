package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.controller.ResultsViewController;
import se.kth.csc.iprog.dinnerplanner.android.view.ResultsView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.os.Bundle;

public class ResultsActivity extends Activity {
	ResultsView resultsView;
	ResultsViewController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);
		
		DinnerModel model = ((DinnerPlannerApplication) this.getApplication()).getModel();
		
		resultsView = new ResultsView(findViewById(R.layout.activity_results), this, model);
		controller = new ResultsViewController(model, resultsView);

	}
	
	

}
