package com.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.Usecases.AdminUsecase;
import com.Usecases.CrimeUsecase;
import com.Usecases.CriminalsUsecase;

public class UserActivity {
	
	public static void selectUser() {
		

		Scanner scan = new Scanner(System.in);		
		System.out
				.println("\nChoose an options - \n" + "1. Admin Login\n"  + "2. Exit ");

		System.out.println("\nEnter any number from above: ");
		
		
		int choice = 0;
		
		try {
			choice = scan.nextInt();
			
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			UserActivity.selectUser();
		}
		
		
		
		switch (choice) {
		
		case 1 :
			AdminUsecase.adminLogin();
			
		case 2 :
			System.out.println("Thank you!");
			break;
			
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			UserActivity.selectUser();
		}
		
	}

	public static void adminOptions() {
		
		System.out.println("\nChoose an options - ");
		System.out.println("1. Crime Records (Create,Update,View)\r\n" + "2. Criminals (Create,Update,View)\r\n"+ "3. Exit (Admin Logout)");

		System.out.println("\nEnter any number from above");

		Scanner scan = new Scanner(System.in);
		
		int choice = scan.nextInt();
		
		switch (choice) {
		
		
		case 1 : {
			UserActivity.crimeOptions();
			break;
		}
		
		case 2 : {
			UserActivity.criminalsOptions();
			break;
		}

		case 3 : {
			AdminUsecase.adminLogout();
			break;
		}
		
		default :
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			UserActivity.adminOptions();
	}
}

	@SuppressWarnings({  "resource", "unused" })
	
	
	public static void criminalsOptions() {
		System.out.println("\nAdd,Delete, View Crime");
		System.out.println("----------------------------------");

		System.out.println("\nChoose an options - \r\n" + "1. Add New Criminal\r\n"
				+ "3. View All Criminals\r\n" + "4. Delete Criminal by Name\r\n" + "5. Exit (Get Admin Options)");

		Scanner scan = new Scanner(System.in);

		System.out.println("\nEnter any number from above:");

		int choice = 0;
		
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			UserActivity.criminalsOptions();
		}
		
		switch (choice) {
		
		case 1 :
			CriminalsUsecase.addNewCriminal();
			break;
			
	
		case 2 :
			CriminalsUsecase.viewAllCriminals();
			break;
			
		case 3 :
			CriminalsUsecase.deleteCriminalRecord();
			break;
			
		case 4 :
			UserActivity.adminOptions();
			break;
			
		default :
			System.out.println("Invalid choice!");
			
			System.out.println();

			System.out.println("Try again...");
			
			UserActivity.criminalsOptions();
		}
		
	}

	@SuppressWarnings({ "unused", "resource" })
	
	private static void crimeOptions() {
		
		System.out.println("\nAdd, Update, View Crime Record");
		System.out.println("----------------------------------");

		System.out.println("\nChoose an options - \r\n" + "1. Add New Crime \r\n" + "2. Update Crime Status\r\n"
				+ "3. View All Crime Records\r\n" + "4. Exit (Get Admin Options)");

		Scanner scan = new Scanner(System.in);

		System.out.println("\nEnter any number from above:");

		int choice = 0;
		
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {

			System.out.println("Invalid input!");

			System.out.println();
			System.out.println("Try again...");

			UserActivity.crimeOptions();
		}
		
		switch (choice) {
		
		case 1 :
			CrimeUsecase.addNewCrime();
			break;
			
		case 2 :
			CrimeUsecase.updateStaus();
			break;
			
		case 3 :
			CrimeUsecase.viewAllCrimes();
			break;
			
		
			
		case 4 :
			UserActivity.adminOptions();
			break;
			
		default :
			System.out.println("Invalid choice!");
			
			System.out.println();

			System.out.println("Try again...");
			
			UserActivity.criminalsOptions();
		}
	}
}