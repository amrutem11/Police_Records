package com.Dao;

import java.util.List;

import com.Exceptions.CrimeException;
import com.Model.Crime;

public interface CrimeDao {
	
	//to add a new crime record;
	
	public String addNewCrime(Crime crime) throws Exception;
	
	//to search a crime record based on crime id;
	
	public Crime searchCrimebasedOnId(int crimeId);
		
	
	//to update crime status
	
	public String updateCrimeStatus(Crime crime);
	
	
	//to view all crime records;
	
	public List<Crime> viewAllCrimes() throws CrimeException;
	
	
	// to view all crimes areaWise
	
	public List<Crime> getCrimeAreaWise(String place);
	
	
}
