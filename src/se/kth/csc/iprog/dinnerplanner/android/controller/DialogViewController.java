package se.kth.csc.iprog.dinnerplanner.android.controller;

import se.kth.csc.iprog.dinnerplanner.android.view.DialogView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.View.OnClickListener;

public class DialogViewController implements OnClickListener{

	private DinnerModel model;
	private DialogView view;

	public DialogViewController(DinnerModel model, DialogView view) {
		this.model = model;
		this.view = view;
		
		view.chooseButton.setOnClickListener(this);
		view.cancelButton.setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		Dish dish = model.getClickedDish();
		// TODO Auto-generated method stub
		if (v.equals(view.chooseButton)) {
			model.addSelectedDish(dish);
			view.activity.finish();
		}
		
		if (v.equals(view.cancelButton)) {
			view.activity.finish();
		}
	}

}
