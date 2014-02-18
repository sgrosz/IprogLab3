package se.kth.csc.iprog.dinnerplanner.android.view;


import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenuHeaderView implements Observer{
	View view;
	public EditText numOfGuestsField;
	public TextView costField;
	final DinnerModel model;

	public MenuHeaderView(View view, final DinnerModel model, Activity activity) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;

		// Setup the rest of the view layout
		numOfGuestsField = (EditText) activity.findViewById(R.id.number_of_guests);
		costField = (TextView) activity.findViewById(R.id.menu_total_cost_label);
		// Add to models observer list
		model.addObserver(this);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// Either way, the total cost field must be updated
		costField.setText(Float.toString(model.getTotalMenuPrice()*model.getNumberOfGuests()));
		
	}

}
