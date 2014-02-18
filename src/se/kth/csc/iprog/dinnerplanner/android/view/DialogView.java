package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.Set;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.android.controller.DialogViewController;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DialogView {
	View view;
	DinnerModel model;
	Activity activity;
	Context context;
	TextView totalCost;
	Dish dish;
	public Button chooseButton;
	public Button cancelButton;
	public AlertDialog alertDialogReference;

	public DialogView(View view, final Activity activity, final DinnerModel model) {
		// store in the class the reference to the Android View
		this.view = view;
		this.activity = activity;
		this.model = model;
		this.context = activity;
		chooseButton = (Button) activity.findViewById(R.id.choose_button);
		cancelButton = (Button) activity.findViewById(R.id.cancel_button);
		totalCost = (TextView) activity.findViewById(R.id.menu_total_cost_label);
		dish = model.dish1;
		
		Set<Ingredient> ingredients = dish.getIngredients();
		int costPerPerson = 0;
		//Calculate cost per person
		for(Ingredient ingredient: ingredients){
			costPerPerson += ingredient.getPrice();
		}

		LayoutInflater inflater = LayoutInflater.from(context);

		LinearLayout dialogLayout = (LinearLayout) inflater.inflate(
				R.layout.dialog_view, null);
		ImageView image = (ImageView) dialogLayout
				.findViewById(R.id.dialog_picture);
		image.setImageResource(dish.getImage());
		TextView head = (TextView) dialogLayout.findViewById(R.id.dialog_head);
		head.setText(dish.getName());
		TextView cost = (TextView) dialogLayout
				.findViewById(R.id.dialog_total_cost);
		//Total cost for all guests
		cost.setText(Integer.toString(costPerPerson*model.getNumberOfGuests()));
		TextView perPersoncost = (TextView) dialogLayout
				.findViewById(R.id.dialog_cost_per_person);
		perPersoncost.setText(Integer.toString(costPerPerson));//Cost per person
		
	}
}
