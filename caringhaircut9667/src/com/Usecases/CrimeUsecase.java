package com.Usecases;

import java.util.Scanner;
import com.Dao.CrimeDao;
import com.Dao.CrimeDaoImpl;
import com.Main.UserActivity;
import com.Model.Crime;


public class CrimeUsecase {

	public static void addNewCrime() {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		Crime crime = new Crime();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Crime details - ");

		System.out.println("Enter Crime id : - ");
		int CrimeId = scan.nextInt();
		
		System.out.println("Enter Crime date");
		String date = scan.next();
		
		System.out.println("Enter Crime place");
		String place = scan.next();
		
		System.out.println("Enter Crime Description");
		String description = scan.next();
		
		System.out.println("Enter Crime suspects");
		String suspects = scan.next();
		
		System.out.println("Enter Crime status");
		String status = scan.next();
		
		crime.setCrimeId(CrimeId);
		crime.setDate(date);
		crime.setPlace(place);
		crime.setDescription(description);
		crime.setSuspects(suspects);
		crime.setStatus(status);
		
		
		
		try {
			
			String result = dao.addNewCrime(crime);
			
			System.out.println(result);
		
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			
			System.out.println("\nTry again...");
			
			UserActivity.adminOptions();
		}
		
	}
	
	public static void updateStaus() {
		
	}
	
	public static void viewAllCrimes() {
		
	}
}
