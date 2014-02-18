package se.kth.csc.iprog.dinnerplanner.android.controller;

import se.kth.csc.iprog.dinnerplanner.android.ResultsActivity;
import se.kth.csc.iprog.dinnerplanner.android.view.CreateButtonView;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class CreateButtonViewController implements OnClickListener {
	
	private CreateButtonView view;
	
	public CreateButtonViewController(CreateButtonView view) {
		this.view = view;
		
		view.createButton.setOnClickListener(this);
	}
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(view.activity, ResultsActivity.class);
		view.activity.startActivity(intent);
	}

}
