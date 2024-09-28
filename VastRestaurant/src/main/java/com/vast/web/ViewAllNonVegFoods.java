package com.vast.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vast.dao.DbFoodDao;
import com.vast.dao.IFoodDao;

public class ViewAllNonVegFoods implements Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		IFoodDao dao = DbFoodDao.getDaoInstance();
		request.setAttribute("nonvegfood", dao.getAllVegFood());
		return "AllNonVegFoods.jsp";
	}
	

}



