package com.vast.dao;

import java.util.Set;

import com.vast.vo.Food;

public interface IFoodDao {
	
	Set<Food> getAllVegFood();
	Set<Food> getAllNonVegFood();

}
