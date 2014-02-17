package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MenuHeaderView {
	View view;
	EditText numOfGuestsField;
	TextView costField;
	final DinnerModel model;

	public MenuHeaderView(View view, final DinnerModel model, Activity activity) {

		// store in the class the reference to the Android View
		this.view = view;
		this.model = model;

		// Setup the rest of the view layout
		numOfGuestsField = (EditText) activity.findViewById(R.id.number_of_guests);
		costField = (TextView) activity.findViewById(R.id.menu_total_cost_label);
		
		numOfGuestsField.addTextChangedListener(new TextWatcher(){
			
			@Override
			public void afterTextChanged(Editable s) {
				//Wow. Such code.
				try{
					model.setNumberOfGuests(Integer.parseInt(s.toString()));
					costField.setText(Float.toString(model.getTotalMenuPrice()*model.getNumberOfGuests()));
				} catch(Exception e){
					model.setNumberOfGuests(0);
				}

				
			}
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}

		});
		
	}
	
	/**
	 * To be able to set the value of the total cost field from dialog view
	 * (When user chooses a dish)
	 * @param value
	 */
	public void setTotalCostField(Float value){
		costField.setText(Float.toString(value));
	}

}
