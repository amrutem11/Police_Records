package com.Usecases;

import java.util.List;
import java.util.Scanner;

import com.Dao.CrimeDao;
import com.Dao.CrimeDaoImpl;
import com.Dao.CriminalsDao;
import com.Dao.CriminalsDaoImpl;
import com.Exceptions.AdminException;
import com.Exceptions.CrimeException;
import com.Exceptions.CriminalException;
import com.Main.UserActivity;
import com.Model.Crime;
import com.Model.Criminal;

public class CriminalsUsecase {

		//to add new criminal;
	
	public static void addNewCriminal() throws CrimeException, AdminException, CriminalException {
		
		CriminalsDao dao = new CriminalsDaoImpl();
		
		Criminal criminal = new Criminal();
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Criminal's details - ");

		System.out.println("Enter Criminal name");
		String name = scan.next();
		
		System.out.println("Enter Criminal's age");
		int age = scan.nextInt();
		
		System.out.println("Enter Criminal's gender");
		String gender = scan.next();
		
		System.out.println("Enter Criminal's address");
		String address = scan.next();
		
		System.out.println("Enter Criminal's Identifying mark");
		String identifyingMark = scan.next();
		
		System.out.println("Enter Criminal's arrested area");
		String AreaofArrest = scan.next();
		
		System.out.println("Enter Criminal's attatched crime");
		String AttatchedCrime = scan.next();
		
		criminal.setName(name);
		criminal.setAge(age);
		criminal.setGender(gender);
		criminal.setAddress(address);
		criminal.setIdentifyingMark(identifyingMark);
		criminal.setAreaOfArrest(AreaofArrest);
		criminal.setAttatchedCrime(AttatchedCrime);
		
		
		try {
			
			String result = dao.addNewCriminal(criminal);
			
			System.out.println(result);
			
			UserActivity.criminalsOptions();
		
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			
			System.out.println("\nTry again...");
			
			UserActivity.criminalsOptions();
		}
		
	}
	
	
	//to search criminal by name;
	
	public static void searchCriminalbyName () throws CrimeException, AdminException, CriminalException {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter name to search ");
		String name = scan.next();
		
		CriminalsDao dao = new CriminalsDaoImpl();
		
		Criminal criminal = dao.searchcriminalByName(name);
		
		if(criminal != null) {
			
			System.out.println("Criminal's Name is : - " + criminal.getName());
			System.out.println("Criminal's age is : - " + criminal.getAge());
			System.out.println("Criminal's gender is : - " + criminal.getGender());
			System.out.println("Criminal's address is : - " + criminal.getAddress());
			System.out.println("Criminal's identifying mark is : - " + criminal.getIdentifyingMark());
			System.out.println("Criminal's area of arrest is : - " + criminal.getAreaOfArrest());
			System.out.println("Criminal's attatched crime  is : - " + criminal.getAttatchedCrime());
			
		}
		else {
			System.out.println("Sorry ! Criminal details Not Found...");
		}
		
		UserActivity.criminalsOptions();
	}
	
	
	//to view all criminal records
	
	public static void viewAllCriminals() throws CrimeException, AdminException, CriminalException {
		
		CriminalsDao dao = new CriminalsDaoImpl();
		
		try {

			List<Criminal> criminals = dao.viewAllCriminals();

			criminals.forEach(c -> {

				System.out.println("Criminal Name : " + c.getName());
				System.out.println("criminal age  : " + c.getAge());
				System.out.println("Criminal gender  : " + c.getGender());
				System.out.println("Criminal address  : " + c.getAddress());
				System.out.println("Criminal identifyingMark   : " + c.getIdentifyingMark());
				System.out.println("Criminal areaOfArrest  : " + c.getAreaOfArrest());
				System.out.println("Criminal attatchedCrime  : " + c.getAttatchedCrime());

				System.out.println("==================================");
			});

		} catch (CriminalException e) {
			System.out.println(e.getMessage());

			System.out.println();
			System.out.println("Try again...");
			UserActivity.criminalsOptions();

		}

		UserActivity.criminalsOptions();
	}
	
	
	//to delete criminal record;
	
	public static void deleteCriminalRecord() throws CrimeException, AdminException, CriminalException {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		
		System.out.println(" Enter name");
		String name  = scan.next();
		
		CriminalsDao dao = new CriminalsDaoImpl();
		
		Criminal criminal = new Criminal();
		
		criminal.setName(name);
		
		
		try {
			String message = dao.deleteCriminalByName(criminal);
			System.out.println(message);
			
		} catch (CriminalException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		UserActivity.criminalsOptions();
		
	}


	public static void viewAllCriminalsAreaWise() throws CriminalException, AdminException, CrimeException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter area to search for criminals");
		String area = scan.next();
		
		CriminalsDao dao = new CriminalsDaoImpl();
		
		List<Criminal> criminals = dao.getCriminalsAreaWise(area);
		
		criminals.forEach(c -> {

			System.out.println("Criminal Name : " + c.getName());
			System.out.println("crimanal age   : " + c.getAge());
			System.out.println("Criminal  gender  : " + c.getGender());
			System.out.println("Criminal address : " + c.getAddress());
			System.out.println("Criminal Identyfying mark : " + c.getIdentifyingMark());
			System.out.println("Criminal area of arrest  : " + c.getAreaOfArrest());
			System.out.println("Criminal attatched crime  : " + c.getAttatchedCrime());
			
			

			System.out.println("==================================");
		});

		UserActivity.criminalsOptions();
	}

	
}
