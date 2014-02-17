package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsView {
	View view;
	DinnerModel model;
	final Activity activity;
	Button backButton;
	TextView instructionHeader, instructionView, totalCost;
	ImageView ingredients, starter, main, dessert;
	Dish starterD, mainD, dessertD;

	public ResultsView(View view, final Activity activity, DinnerModel model){
		// store in the class the reference to the Android View
		this.view = view;
		this.activity = activity;
		this.model = model;

		starterD = model.getSelectedDish(1);
		mainD = model.getSelectedDish(2);
		dessertD = model.getSelectedDish(3);
		
		// The text views
		instructionHeader = (TextView) activity.findViewById(R.id.results_instruction_header);
		instructionView = (TextView) activity.findViewById(R.id.results_instructions_text);
		totalCost = (TextView) activity.findViewById(R.id.results_total_cost_label);

		// The four images for ingredients, starter, main course, and dessert
		ingredients = (ImageView) activity.findViewById(R.id.ingredients_image_view);
		ingredients.setOnTouchListener(new mOnTouchListener());
		ingredients.setOnClickListener(new mOnClickListener());

		starter = (ImageView) activity.findViewById(R.id.results_starter_image);
		if(starterD != null){
			starter.setOnTouchListener(new mOnTouchListener());
			starter.setOnClickListener(new mOnClickListener());
			starter.setImageResource(starterD.getImage());
		}


		main = (ImageView) activity.findViewById(R.id.results_main_image);
		if(mainD != null){
			main.setOnTouchListener(new mOnTouchListener());
			main.setOnClickListener(new mOnClickListener());
			main.setImageResource(mainD.getImage());
		}

		dessert = (ImageView) activity.findViewById(R.id.results_dessert_image);
		if(dessertD != null){
			dessert.setOnTouchListener(new mOnTouchListener());
			dessert.setOnClickListener(new mOnClickListener());
			dessert.setImageResource(dessertD.getImage());
		}

		// Setup the rest of the view layout
		backButton = (Button) activity.findViewById(R.id.back_button);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				activity.finish();

			}
		});
		
		// Show total cost for the hela kalaset
		totalCost.setText(Float.toString(model.getTotalMenuPrice()*model.getNumberOfGuests()));

		//Instantiate instructions field with ingredients
		StringBuilder sb = new StringBuilder();
		instructionHeader.setText(R.string.ingredients);
		sb.append(model.getNumberOfGuests() + " attendees\n");
		sb.append("\n");
		Set<Ingredient> ingredientSet = model.getAllIngredients();
		for(Ingredient ing: ingredientSet){
			sb.append(ing.getName() + " " + ing.getQuantity() + " " + ing.getUnit() + "\n");
		}
		instructionView.setText(sb.toString());

	}

	/**
	 * Private class to set new OnTouchListeners to each of the four images
	 * in this class
	 *
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

	/**
	 * Same, but for an OnClickListener and for the same reason
	 * 
	 */
	private class mOnClickListener implements OnClickListener{
		ImageView image;


		@Override
		public void onClick(View v) {
			image = (ImageView) v;
			StringBuilder sb = new StringBuilder();

			switch (image.getId()){
			case R.id.ingredients_image_view:
				instructionHeader.setText(R.string.ingredients);
				sb.append(model.getNumberOfGuests() + " attendees\n");
				sb.append("\n");
				Set<Ingredient> ingredientSet = model.getAllIngredients();
				for(Ingredient ing: ingredientSet){
					sb.append(ing.getName() + " " + ing.getQuantity() + " " + ing.getUnit() + "\n");
				}
				instructionView.setText(sb.toString());
				break;

			case R.id.results_starter_image:
				instructionHeader.setText(R.string.starter);
				if (starterD!= null)
					instructionView.setText("\n"+ starterD.getDescription());
				break;

			case R.id.results_main_image:
				instructionHeader.setText(R.string.main_course);
				if (mainD!= null)
					instructionView.setText("\n"+ mainD.getDescription());
				break;

			case R.id.results_dessert_image:
				instructionHeader.setText(R.string.dessert);
				if (dessertD!= null)
					instructionView.setText("\n"+ dessertD.getDescription());
				break;

			default:
				break;

			}

		}
	}
}
