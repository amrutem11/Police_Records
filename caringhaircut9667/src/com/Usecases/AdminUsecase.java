package com.Usecases;

import java.util.Scanner;

import com.Dao.AdminDao;
import com.Dao.AdminDaoImpl;
import com.Exceptions.AdminException;
import com.Exceptions.CrimeException;
import com.Exceptions.CriminalException;
import com.Main.UserActivity;
import com.Model.Admin;

public class AdminUsecase {

	
	public static void adminLogin() throws CrimeException, CriminalException {
		
		Scanner scan = new Scanner(System.in);

		System.out.println("\nEnter admin details -");
		
		System.out.println("-----------------------------------");
		
		System.out.println("Enter Username : ");
		
		String username = scan.next();

		System.out.println("Enter Password : ");
		String password = scan.next();	
		
		
		try {
			AdminDao dao =  new AdminDaoImpl();
			
			Admin admin = dao.loginAdmin(username, password);
			
			
			System.out.println("\nWelcome! Login Successful..."+admin.getUsername());
			UserActivity.adminOptions();
			

		} catch (AdminException e) {
			System.out.println(e.getMessage());			
			
			System.out.println("\nTry again...");
			UserActivity.selectUser();
		}
	}
	
	
	
public static void adminLogout() throws CrimeException, AdminException, CriminalException {
		
		System.out.println("Are you sure? y/n");
		
		Scanner scan = new Scanner(System.in);
		
		String choice = scan.next();
		
		if(choice.equalsIgnoreCase("y")) {
			
			try {
				new AdminDaoImpl().logoutAdmin();
			}
			catch (AdminException e) {				
				System.out.println(e.getMessage());
			}
			
		}
		else {
			
			System.out.println("\nTry again...");
			System.out.println();
			
			UserActivity.adminOptions();
		}
		
	}
}
