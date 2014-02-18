package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

import android.util.Log;
import se.kth.csc.iprog.dinnerplanner.android.R;

public class DinnerModel extends Observable implements IDinnerModel {

	int numberOfGuests;
	Set<Dish> selectedDishes = new HashSet<Dish>();
	Set<Dish> dishes = new HashSet<Dish>();

	/**
	 * The constructor of the overall model. Set the default values here
	 */
	public DinnerModel() {

		// Adding some example data, you can add more
		Dish dish1 = new Dish(
				"French toast",
				Dish.STARTER,
				R.drawable.toast,
				"In a large mixing bowl, beat the eggs. Add the milk, brown sugar and nutmeg; stir well to combine. Soak bread slices in the egg mixture until saturated. Heat a lightly oiled griddle or frying pan over medium high heat. Brown slices on both sides, sprinkle with cinnamon and serve hot.");
		Ingredient dish1ing1 = new Ingredient("eggs", 0.5, "", 1);
		Ingredient dish1ing2 = new Ingredient("milk", 30, "ml", 6);
		Ingredient dish1ing3 = new Ingredient("brown sugar", 7, "g", 1);
		Ingredient dish1ing4 = new Ingredient("ground nutmeg", 0.5, "g", 12);
		Ingredient dish1ing5 = new Ingredient("white bread", 2, "slices", 2);
		dish1.addIngredient(dish1ing1);
		dish1.addIngredient(dish1ing2);
		dish1.addIngredient(dish1ing3);
		dish1.addIngredient(dish1ing4);
		dish1.addIngredient(dish1ing5);
		dishes.add(dish1);

		Dish dish2 = new Dish(
				"Meatballs",
				Dish.MAIN,
				R.drawable.meatballs,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		Ingredient dish2ing1 = new Ingredient("extra lean ground beef", 115,
				"g", 20);
		Ingredient dish2ing2 = new Ingredient("sea salt", 0.7, "g", 3);
		Ingredient dish2ing3 = new Ingredient("small onion, diced", 0.25, "", 2);
		Ingredient dish2ing4 = new Ingredient("garlic salt", 0.6, "g", 3);
		Ingredient dish2ing5 = new Ingredient("Italian seasoning", 0.3, "g", 3);
		Ingredient dish2ing6 = new Ingredient("dried oregano", 0.3, "g", 3);
		Ingredient dish2ing7 = new Ingredient("crushed red pepper flakes", 0.6,
				"g", 3);
		Ingredient dish2ing8 = new Ingredient("Worcestershire sauce", 16, "ml",
				7);
		Ingredient dish2ing9 = new Ingredient("milk", 20, "ml", 4);
		Ingredient dish2ing10 = new Ingredient("grated Parmesan cheese", 5,
				"g", 8);
		Ingredient dish2ing11 = new Ingredient("seasoned bread crumbs", 115,
				"g", 4);
		dish2.addIngredient(dish2ing1);
		dish2.addIngredient(dish2ing2);
		dish2.addIngredient(dish2ing3);
		dish2.addIngredient(dish2ing4);
		dish2.addIngredient(dish2ing5);
		dish2.addIngredient(dish2ing6);
		dish2.addIngredient(dish2ing7);
		dish2.addIngredient(dish2ing8);
		dish2.addIngredient(dish2ing9);
		dish2.addIngredient(dish2ing10);
		dish2.addIngredient(dish2ing11);
		dishes.add(dish2);

		Dish dish3 = new Dish(
				"Meatballs2",
				Dish.MAIN,
				R.drawable.meatballs,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dish3.addIngredient(dish2ing1);
		dish3.addIngredient(dish2ing2);
		dish3.addIngredient(dish2ing3);
		dish3.addIngredient(dish2ing4);
		dish3.addIngredient(dish2ing5);
		dish3.addIngredient(dish2ing6);
		dish3.addIngredient(dish2ing7);
		dish3.addIngredient(dish2ing8);
		dish3.addIngredient(dish2ing9);
		dish3.addIngredient(dish2ing10);
		dish3.addIngredient(dish2ing11);
		dishes.add(dish3);

		Dish dish4 = new Dish(
				"Meatballs3",
				Dish.MAIN,
				R.drawable.meatballs,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish4);

		Dish dish5 = new Dish(
				"Meatballs4",
				Dish.MAIN,
				R.drawable.meatballs,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish5);

		Dish dish6 = new Dish(
				"Ice cream",
				Dish.DESSERT,
				R.drawable.icecream,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish6);

		Dish dish7 = new Dish(
				"Ice cream",
				Dish.DESSERT,
				R.drawable.icecream,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish7);

		Dish dish8 = new Dish(
				"Sour dough",
				Dish.DESSERT,
				R.drawable.sourdough,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish8);

		Dish dish9 = new Dish(
				"Sour dough",
				Dish.DESSERT,
				R.drawable.sourdough,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish9);

		Dish dish10 = new Dish(
				"French toast 2",
				Dish.STARTER,
				R.drawable.toast,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish10);

		Dish dish11 = new Dish(
				"French toast 3",
				Dish.STARTER,
				R.drawable.toast,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish11);

		Dish dish12 = new Dish(
				"French toast 4",
				Dish.STARTER,
				R.drawable.toast,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish12);

		Dish dish13 = new Dish(
				"French toast 5",
				Dish.STARTER,
				R.drawable.toast,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish13);

		Dish dish14 = new Dish(
				"French toast 6",
				Dish.STARTER,
				R.drawable.toast,
				"Preheat an oven to 400 degrees F (200 degrees C). Place the beef into a mixing bowl, and season with salt, onion, garlic salt, Italian seasoning, oregano, red pepper flakes, hot pepper sauce, and Worcestershire sauce; mix well. Add the milk, Parmesan cheese, and bread crumbs. Mix until evenly blended, then form into 1 1/2-inch meatballs, and place onto a baking sheet. Bake in the preheated oven until no longer pink in the center, 20 to 25 minutes.");
		dishes.add(dish14);

		dish4.addIngredient(dish2ing2);
		dish5.addIngredient(dish2ing2);
		dish6.addIngredient(dish2ing2);
		dish7.addIngredient(dish2ing2);
		dish8.addIngredient(dish2ing2);
		dish9.addIngredient(dish2ing2);
		dish10.addIngredient(dish2ing2);
		dish11.addIngredient(dish2ing2);
		dish12.addIngredient(dish2ing2);
		dish13.addIngredient(dish2ing2);
		dish14.addIngredient(dish2ing2);


	}

	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 =
	 * dessert).
	 */
	public Set<Dish> getDishes() {
		return dishes;
	}

	/**
	 * Returns the set of dishes of specific type. (1 = starter, 2 = main, 3 =
	 * dessert).
	 */
	public Set<Dish> getDishesOfType(int type) {
		Set<Dish> result = new HashSet<Dish>();
		for (Dish d : dishes) {
			if (d.getType() == type) {
				result.add(d);
			}
		}
		return result;
	}

	/**
	 * Returns the set of dishes of specific type, that contain filter in their
	 * name or name of any ingredient.
	 */
	public Set<Dish> filterDishesOfType(int type, String filter) {
		Set<Dish> result = new HashSet<Dish>();
		for (Dish d : dishes) {
			if (d.getType() == type && d.contains(filter)) {
				result.add(d);
			}
		}
		return result;
	}

	@Override
	public int getNumberOfGuests() {
		return numberOfGuests;
	}

	@Override
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
		setChanged();
		notifyObservers("guestsChanged");
	}

	@Override
	public Dish getSelectedDish(int type) {
		for (Dish d : selectedDishes) {
			if (d.getType() == type) {
				return d;
			}
		}
		return null;
	}

	@Override
	public Set<Dish> getFullMenu() {
		return selectedDishes;
	}

	@Override
	public Set<Ingredient> getAllIngredients() {
		Set<Ingredient> ingredients = new HashSet<Ingredient>();
		for (Dish d : selectedDishes) {
			ingredients.addAll(d.getIngredients());
		}
		return ingredients;
	}

	@Override
	public float getTotalMenuPrice() {
		Set<Ingredient> ingredients = getAllIngredients();
		float totalPrice = 0;
		for (Ingredient ingredient : ingredients) {
			totalPrice += ingredient.getPrice();
		}
		return totalPrice;
	}
	
	public void addSelectedDish(Dish dish){
		if(getSelectedDish(dish.type) != null){
			selectedDishes.remove(getSelectedDish(dish.type));
		}
		selectedDishes.add(dish);
		setChanged();
		notifyObservers("dishAdded");
	}
}
