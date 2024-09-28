package com.vast.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import org.apache.log4j.Logger;

import com.vast.vo.Food;

public class DbFoodDao implements IFoodDao {

	static Logger logger = Logger.getLogger("vast");
	static ResourceBundle rb = ResourceBundle.getBundle("vastjdbc");
	private static IFoodDao dao = new DbFoodDao();

	private DbFoodDao() {

	}

	public static IFoodDao getDaoInstance() {
		return dao;
	}

	static {
		try {
			Class.forName(rb.getString("driver"));
			logger.debug("Driver loaded successfully");
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage());
		}

	}

	@Override
	public Set<Food> getAllVegFood() {
		Set<Food> set = new HashSet<Food>();
		Connection con = null;
		Food food = null;
		try {
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pwd"));
			logger.debug("Connection established..");
			String sql = "select * from food where food_type=?";
			PreparedStatement pst = con.prepareStatement(sql);
			String ftype = "veg";
			pst.setString(1, ftype);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				food = new Food();
				food.setFoodId(rs.getInt("food_id"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getDouble("food_price"));
				food.setFoodRating(rs.getDouble("food_rating"));
				food.setFoodType(rs.getString("food_type"));
				set.add(food);
			}
			logger.info("Veg Food detials reterived from db");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {

			closeConnection(con);
		}

		return set;
	}

	@Override
	public Set<Food> getALlNonVegFood() {
		Set<Food> set = new HashSet<Food>();
		Connection con = null;
		Food food = null;
		try {
			con = DriverManager.getConnection(rb.getString("url"), rb.getString("user"), rb.getString("pwd"));
			logger.debug("Connection established..");
			String sql = "select * from food where food_type=?";
			PreparedStatement pst = con.prepareStatement(sql);
			String ftype = "non veg";
			pst.setString(1, ftype);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				food = new Food();
				food.setFoodId(rs.getInt("food_id"));
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getDouble("food_price"));
				food.setFoodRating(rs.getDouble("food_rating"));
				food.setFoodType(rs.getString("food_type"));
				set.add(food);
			}
			logger.info("Non veg Food detials reterived from db");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		} finally {

			closeConnection(con);
		}

		return set;
	}

	private void closeConnection(Connection con) {
		try {
			con.close();
			logger.debug("Connection Closed..");
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
	}

}
