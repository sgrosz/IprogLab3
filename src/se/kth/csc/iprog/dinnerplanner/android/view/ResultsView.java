package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.controller.ResultsViewController;
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

public class ResultsView implements Observer {
	View view;
	DinnerModel model;
	public final Activity activity;
	public Button backButton;
	public TextView instructionHeader, instructionView, totalCost;
	public ImageView ingredients, starter, main, dessert;
	public Dish starterD, mainD, dessertD;

	public ResultsView(View view, final Activity activity, DinnerModel model) {
		// store in the class the reference to the Android View
		this.view = view;
		this.activity = activity;
		this.model = model;
		model.addObserver(this);

		starterD = model.getSelectedDish(1);
		mainD = model.getSelectedDish(2);
		dessertD = model.getSelectedDish(3);
		
		// The text views
		instructionHeader = (TextView) activity.findViewById(R.id.results_instruction_header);
		instructionView = (TextView) activity.findViewById(R.id.results_instructions_text);
		totalCost = (TextView) activity.findViewById(R.id.results_total_cost_label);

		// The four images for ingredients, starter, main course, and dessert
		ingredients = (ImageView) activity.findViewById(R.id.ingredients_image_view);
		starter = (ImageView) activity.findViewById(R.id.results_starter_image);
		main = (ImageView) activity.findViewById(R.id.results_main_image);
		dessert = (ImageView) activity.findViewById(R.id.results_dessert_image);
		if(starterD != null)
			starter.setImageResource(starterD.getImage());
		if(mainD != null)
			main.setImageResource(mainD.getImage());
		if(dessertD != null)
			dessert.setImageResource(dessertD.getImage());

		// Setup the rest of the view layout
		backButton = (Button) activity.findViewById(R.id.back_button);

		
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



	@Override
	public void update(Observable observable, Object data) {
		// Either way, the total cost field must be updated
		totalCost.setText(Float.toString(model.getTotalMenuPrice()*model.getNumberOfGuests()));
		// But if the dishes have changed, we need to update the view
		if(data == "dishChanged"){
			starterD = model.getSelectedDish(1);
			mainD = model.getSelectedDish(2);
			dessertD = model.getSelectedDish(3);
			if(starterD != null)
				starter.setImageResource(starterD.getImage());
			if(mainD != null)
				main.setImageResource(mainD.getImage());
			if(dessertD != null)
				dessert.setImageResource(dessertD.getImage());
		}
		
	}
}
