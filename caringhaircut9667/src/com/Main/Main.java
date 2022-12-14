package com.Main;

import com.Exceptions.CrimeException;
import com.Exceptions.CriminalException;

public class Main {

	

	public static void main(String[] args) throws CrimeException, CriminalException {
		
		System.out.println("\n====================================");
		System.out.println("Welcome to Crime Information Management System");
		System.out.println("====================================");
		
		UserActivity.selectUser();
		
		
	}


}
