package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.Exceptions.AdminException;
import com.Exceptions.CrimeException;
import com.Exceptions.CriminalException;
import com.Main.UserActivity;
import com.Model.Admin;
import com.Util.DBUtil;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin loginAdmin(String username, String password) throws AdminException {
		
		Admin admin = null ;
		
		try (Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps = conn.prepareStatement("select * from admin where username = ? AND password = ?");
		
		ps.setString(1, username);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			String user = rs.getString("username");
			
			String pass = rs.getString("password");
			
			admin = new Admin(user,pass);
		}
		else {
			throw new AdminException ("Invalid details");
		}
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return admin;
	}

	@Override
	public void logoutAdmin() throws AdminException, CriminalException {
		
		try {
			UserActivity.selectUser();
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
