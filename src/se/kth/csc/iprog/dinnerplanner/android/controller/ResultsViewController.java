package se.kth.csc.iprog.dinnerplanner.android.controller;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.view.ResultsView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class ResultsViewController implements OnClickListener{
	ImageView image;
	DinnerModel model;
	ResultsView view;

	public ResultsViewController(DinnerModel model, final ResultsView view){
		this.model = model;
		this.view = view;
		
		// Set onClickListeners for the entire view
		view.ingredients.setOnTouchListener(new mOnTouchListener());
		view.ingredients.setOnClickListener(this);
		if(view.starterD != null){
			view.starter.setOnClickListener(this);
			view.starter.setOnTouchListener(new mOnTouchListener());
		}
		if(view.mainD != null){
			view.main.setOnClickListener(this);
			view.main.setOnTouchListener(new mOnTouchListener());
		}
		if(view.dessertD != null){
			view.dessert.setOnClickListener(this);
			view.dessert.setOnTouchListener(new mOnTouchListener());
		}
		view.backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				view.activity.finish();

			}
		});
	}

	@Override
	public void onClick(View v) {
		image = (ImageView) v;
		StringBuilder sb = new StringBuilder();

		switch (image.getId()){
		case R.id.ingredients_image_view:
			view.instructionHeader.setText(R.string.ingredients);
			sb.append(model.getNumberOfGuests() + " attendees\n");
			sb.append("\n");
			Set<Ingredient> ingredientSet = model.getAllIngredients();
			for(Ingredient ing: ingredientSet){
				sb.append(ing.getName() + " " + ing.getQuantity() + " " + ing.getUnit() + "\n");
			}
			view.instructionView.setText(sb.toString());
			break;

		case R.id.results_starter_image:
			view.instructionHeader.setText(R.string.starter);
			if (view.starterD!= null)
				view.instructionView.setText("\n"+ view.starterD.getDescription());
			break;

		case R.id.results_main_image:
			view.instructionHeader.setText(R.string.main_course);
			if (view.mainD!= null)
				view.instructionView.setText("\n"+ view.mainD.getDescription());
			break;

		case R.id.results_dessert_image:
			view.instructionHeader.setText(R.string.dessert);
			if (view.dessertD!= null)
				view.instructionView.setText("\n"+ view.dessertD.getDescription());
			break;

		default:
			break;

		}

	}
	/**
	 * Private class to set new OnTouchListeners to each of the four images
	 * in this class. This is only for visual effects; it does not do anything
	 * controller-wise.
	 */
	private class mOnTouchListener implements OnTouchListener{
		ImageView image;
		@Override
		public boolean onTouch(View v, MotionEvent event) {
			// Cast the view as an ImageView as this is the only view using this
			image = (ImageView) v;

			switch (event.getAction()) {
			case MotionEvent.ACTION_DOWN:
				image.setColorFilter(Color.parseColor("#EDEDCC"),
						Mode.SCREEN);
				break;
			case MotionEvent.ACTION_UP:
				image.clearColorFilter();
				break;
			case MotionEvent.ACTION_CANCEL:
				image.clearColorFilter();
			}
			return false;
		}
	}

}

