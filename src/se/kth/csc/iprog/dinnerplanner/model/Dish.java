package se.kth.csc.iprog.dinnerplanner.model;

import java.util.HashSet;
import java.util.Set;

public class Dish {

	public static final int STARTER = 1;
	public static final int MAIN = 2;
	public static final int DESSERT = 3;

	String name;
	int type; // starter (1), main (2) or desert (3)
	int imageID;
	String description;

	Set<Ingredient> ingredients = new HashSet<Ingredient>();

	public Dish(String name, int type, int image, String description) {
		this.name = name;
		this.type = type;
		this.imageID = image;
		this.description = description;
	}

	public static final String getTypeString(int type) {
		String typeString = "";
		switch (type) {
		case STARTER:
			typeString = "Starter";
			break;
		case MAIN:
			typeString = "Main course";
			break;
		case DESSERT:
			typeString = "Dessert";
			break;

		default:
			break;
		}
		return typeString;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getImage() {
		return imageID;
	}

	public void setImage(int image) {
		this.imageID = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void addIngredient(Ingredient ing) {
		ingredients.add(ing);
	}

	public void removeIngredient(Ingredient ing) {
		ingredients.remove(ing);
	}

	public boolean contains(String filter) {
		if (name.toLowerCase().contains(filter.toLowerCase())) {
			return true;
		}
		for (Ingredient i : ingredients) {
			if (i.getName().toLowerCase().contains(filter.toLowerCase())) {
				return true;
			}
		}
		return false;
	}

}
