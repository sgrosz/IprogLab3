package se.kth.csc.iprog.dinnerplanner.android.controller;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import se.kth.csc.iprog.dinnerplanner.android.MenuActivity;
import se.kth.csc.iprog.dinnerplanner.android.view.WelcomeView;

public class WelcomeViewController implements OnClickListener{
	WelcomeView view;
	public WelcomeViewController(WelcomeView view){
		this.view = view;
		view.button.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent intent = new Intent(view.activity, MenuActivity.class);
		view.activity.startActivity(intent);
		
	}
	
}
