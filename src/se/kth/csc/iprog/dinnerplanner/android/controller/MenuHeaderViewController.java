package se.kth.csc.iprog.dinnerplanner.android.controller;

import se.kth.csc.iprog.dinnerplanner.android.view.MenuHeaderView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

public class MenuHeaderViewController implements TextWatcher{
	DinnerModel model;
	MenuHeaderView view;
	public MenuHeaderViewController(DinnerModel model, MenuHeaderView view){
		this.model = model;
		this.view = view;
		
		view.numOfGuestsField.addTextChangedListener(this);
	}
	@Override
	public void afterTextChanged(Editable s) {
		//Wow. Such code.
		try{
			model.setNumberOfGuests(Integer.parseInt(s.toString()));
		} catch(Exception e){
			model.setNumberOfGuests(0);
		}
		
	}
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// TODO Auto-generated method stub
		
	}
}
