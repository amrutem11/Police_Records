package com.Usecases;

import java.util.List;
import java.util.Scanner;

import com.Dao.CriminalsDao;
import com.Dao.CriminalsDaoImpl;
import com.Exceptions.CriminalException;
import com.Main.UserActivity;
import com.Model.Criminal;

public class CriminalsUsecase {

		
	public static void addNewCriminal() {
		
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
		
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			
			System.out.println("\nTry again...");
			
			UserActivity.criminalsOptions();
		}
		
	}
	
	public static void viewAllCriminals() {
		
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
	
	public static void deleteCriminalRecord() {
		
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
		
		
		
		
	}

	
}
