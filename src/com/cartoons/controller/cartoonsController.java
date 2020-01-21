package com.cartoons.controller;

import java.sql.SQLException;
import com.cartoon.dao.CartoonDao;

public class cartoonsController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

			
		CartoonDao obj = new CartoonDao();
		obj.insertCartoon();					
	}

}
