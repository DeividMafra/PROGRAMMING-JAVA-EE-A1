package com.cartoons.controller;

import java.sql.SQLException;
import java.util.Scanner;

import com.cartoon.dao.CartoonDao;

public class cartoonsController {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

			
		CartoonDao obj = new CartoonDao();
		Scanner sc = new Scanner(System.in);
		
		int option;
		do {
			System.out.println("\nPlease choose the option from menu");
			System.out.println("1 - Select\n2 - Insert\n3 - Update\n4 - Delete");
			option = sc.nextInt();
			
			switch (option) {
			case 1:
				obj.diplayCartoons();
				break;
			case 2:
				obj.insertCartoon();
				break;
			case 3:
				obj.updateCartoon();
				break;
			case 4:
				obj.deleteCartoon();
				break;
			case 0:
				System.out.println("Exiting...\n");
				break;
			default:
				System.out.println("Invalid option!!!\n");
				break;
			}
			
		} while (option != 0);
		
				
	}
}
