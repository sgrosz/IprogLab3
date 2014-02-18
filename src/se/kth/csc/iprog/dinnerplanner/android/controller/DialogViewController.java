package se.kth.csc.iprog.dinnerplanner.android.controller;

import se.kth.csc.iprog.dinnerplanner.android.view.DialogView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.view.View.OnClickListener;

public class DialogViewController implements OnClickListener{

	private DinnerModel model;
	private DialogView view;

	public DialogViewController(DinnerModel model, DialogView view) {
		this.model = model;
		this.view = view;
		
		
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
