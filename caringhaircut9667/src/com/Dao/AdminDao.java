package com.Dao;

import com.Exceptions.AdminException;
import com.Exceptions.CriminalException;
import com.Model.Admin;

public interface AdminDao {
	
	//to login for admin account
	
		public Admin loginAdmin(String username,String password) throws  AdminException;
		
		
		//to logout from admin account
		
		public void logoutAdmin() throws AdminException, CriminalException;
}
