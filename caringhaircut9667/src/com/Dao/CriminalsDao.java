package com.Dao;

import java.util.List;

import com.Exceptions.CriminalException;
import com.Model.Criminal;

public interface CriminalsDao {
	
	public String addNewCriminal(Criminal criminal) throws Exception;
	
	public List<Criminal> viewAllCriminals()throws CriminalException;
	
	//public String deleteCriminalByName(String name) throws CriminalException;

	public String deleteCriminalByName(Criminal criminal) throws CriminalException;
}
