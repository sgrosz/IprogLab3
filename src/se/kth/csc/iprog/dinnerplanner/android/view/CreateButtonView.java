package se.kth.csc.iprog.dinnerplanner.android.view;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class CreateButtonView {
	View view;
	public final Activity activity;
	DinnerModel model;
	MenuHeaderView menuHeaderView;
	public Button createButton;

	public CreateButtonView(View view, final DinnerModel model, final Activity activity){
		this.view = view;
		this.activity = activity;
		this.model = model;


		// Setup the rest of the view layout, with an onClickListener for the create button
		createButton = (Button) activity.findViewById(R.id.create_button);
	}
}
