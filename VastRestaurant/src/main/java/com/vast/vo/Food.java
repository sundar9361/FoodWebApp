package com.vast.vo;

public class Food {
	private int foodId;
	private String foodName;
	private double foodPrice;
	private double foodRating;
	private String foodType;

	public Food() {
		super();
	}

	public Food(int foodId, String foodName, double foodPrice, double foodRating, String foodType) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodRating = foodRating;
		this.foodType = foodType;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	public double getFoodRating() {
		return foodRating;
	}

	public void setFoodRating(double foodRating) {
		this.foodRating = foodRating;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", foodPrice=" + foodPrice + ", foodRating="
				+ foodRating + ", foodType=" + foodType + "]";
	}
	

}
