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


public class CrimeUsecase {

	
	// to add a new crime record;	
	
	public static void addNewCrime() throws AdminException, CrimeException, CriminalException {
		
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
		
		System.out.println("Enter Crime Victims");
		String Victims = scan.next();
		
		
		System.out.println("Enter Crime DetailDescription");
		String DetailDescription  = scan.next();
		
		System.out.println("Enter Crime suspects");
		String suspects = scan.next();
		
		System.out.println("Enter Crime status");
		String status = scan.next();
		
		crime.setCrimeId(CrimeId);
		
		crime.setDate(date);
		
		crime.setPlace(place);
		
		crime.setDescription(description);
		
		crime.setVictims(Victims);
		
		crime.setDetailDescription(DetailDescription);
		
		crime.setSuspects(suspects);
		
		crime.setStatus(status);
		
		
		
		try {
			
			String result = dao.addNewCrime(crime);
			
			System.out.println(result);
			
			UserActivity.crimeOptions();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
			
			System.out.println("\nTry again...");
			
			UserActivity.adminOptions();
		}
		
	}
	
	
	// to update status of a crime
	
	public static void updateStatus() throws CrimeException, AdminException, CriminalException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter CrimeID whose status is to change");
		int CrimeId = scan.nextInt();
		
		System.out.println("Enter new Status to be updated");
		String status = scan.next();
		
		CrimeDao dao  = new CrimeDaoImpl();
		
		Crime crime = new Crime();
		
		crime.setCrimeId(CrimeId);
		crime.setStatus(status);
		
		String result = dao.updateCrimeStatus(crime);
		
		System.out.println(result);
		
		UserActivity.crimeOptions();
	}
	
	
	// to view all crimes records;
	
	public static void viewAllCrimes() throws CrimeException, AdminException, CriminalException {
		
		CrimeDao dao = new CrimeDaoImpl();
		
		List<Crime> crimes = dao.viewAllCrimes();

		crimes.forEach(c -> {

			System.out.println("Crime id : " + c.getCrimeId());
			System.out.println("crime date   : " + c.getDate());
			System.out.println("Crime place  : " + c.getPlace());
			System.out.println("Crime description : " + c.getDescription());
			System.out.println("Crime victim    : " + c.getVictims());
			System.out.println("Crime detail description : " + c.getDetailDescription());
			System.out.println("Crime suspect   : " + c.getSuspects());
			System.out.println("Crime status    : " + c.getStatus());
			

			System.out.println("==================================");
		});

		UserActivity.crimeOptions();
	}

	
	//To search a crime based on id;
	
	
	public static void searchCrimeBasedOnId() throws CrimeException, AdminException, CriminalException {
		
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter Crime Id to search ");
		int CrimeId = scan.nextInt();
		
		CrimeDao dao = new CrimeDaoImpl();
		
		Crime crime = dao.searchCrimebasedOnId(CrimeId);
		
		if(crime != null) {
			
			System.out.println("Crime Id is : - " + crime.getCrimeId());
			System.out.println("Crime Date : - " + crime.getDate());
			System.out.println("Crime place is : - " + crime.getPlace());
			System.out.println("Crime Description is : - " + crime.getDescription());
			System.out.println("Crime Victim is : - " + crime.getVictims());
			System.out.println("Crime detail description  is : - " + crime.getDetailDescription());
			System.out.println("Crime suspect  is : - " + crime.getSuspects());
			System.out.println("Crime status is : - " + crime.getStatus());
			
			UserActivity.crimeOptions();
		}
		else {
			System.out.println("Sorry ! Crime details Not Found...");
		}
		
	}
	
	
	// to view all crimes areaWise
	
	public static void areaWiseCrime() throws CrimeException, AdminException, CriminalException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter area to search for crimes");
		String area = scan.next();
		
		CrimeDao dao = new CrimeDaoImpl();
		
		List<Crime> crimes = dao.getCrimeAreaWise(area);
		
		crimes.forEach(c -> {

			System.out.println("Crime id : " + c.getCrimeId());
			System.out.println("crime date   : " + c.getDate());
			System.out.println("Crime place  : " + c.getPlace());
			System.out.println("Crime description : " + c.getDescription());
			System.out.println("Crime victim    : " + c.getVictims());
			System.out.println("Crime detail description : " + c.getDetailDescription());
			System.out.println("Crime suspect   : " + c.getSuspects());
			System.out.println("Crime status    : " + c.getStatus());
			

			System.out.println("==================================");
		});

		UserActivity.crimeOptions();
		
		
	}
	
	
	// To show the number of solved and notsolved crime;
	
	public static void crimeStatistics() throws CrimeException, AdminException, CriminalException {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter status");
		
		String status = scan.next();
		
		CrimeDao dao = new CrimeDaoImpl();
		
		List<Crime> crimes = dao.crimeStats(status);
		

		
		
		UserActivity.crimeOptions();
	}
	
	
	
	// to show the number of crimes recorded in current month;
	
	
	public static void crimeRecordedInCurrentMonth() throws CrimeException, AdminException, CriminalException {
		
		
		
		CrimeDao dao = new CrimeDaoImpl();
		
		List<Crime> crimes = dao.crimeRecordedInCurrentMonth();
		
		UserActivity.crimeOptions();
	}
	
}
