package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exceptions.CriminalException;
import com.Model.Criminal;
import com.Util.DBUtil;

public class CriminalsDaoImpl implements CriminalsDao{

	@Override
	public String addNewCriminal(Criminal criminal) throws Exception {
		
		String message = "Sorry ! Criminal's Details not added";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("insert into criminals values (?,?,?,?,?,?,?)");
			
			ps.setString(1, criminal.getName());
			ps.setInt(2, criminal.getAge());
			ps.setString(3, criminal.getGender());
			ps.setString(4, criminal.getAddress());
			ps.setString(5, criminal.getIdentifyingMark());
			ps.setString(6, criminal.getAreaOfArrest());
			ps.setString(7, criminal.getAttatchedCrime());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Criminal details added Successfully...!";
			}
		} catch (SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		return message;
	}

	public List<Criminal> viewAllCriminals() throws CriminalException {
		
		List<Criminal> criminals = new ArrayList<Criminal>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("select * from Criminals");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String n = rs.getString("name");
				int a = rs.getInt("age");
				String g = rs.getString("gender");
				String ad = rs.getString("address");
				String im = rs.getString("identifyingMark");
				String aa = rs.getString("areaOfArrest");
				String ac = rs.getString("AttatchedCrime");
				
				Criminal criminal = new Criminal();
				
				criminal.setName(n);
				criminal.setAge(a);
				criminal.setGender(g);
				criminal.setAddress(ad);
				criminal.setIdentifyingMark(im);
				criminal.setAreaOfArrest(aa);
				criminal.setAttatchedCrime(ac);
				
				criminals.add(criminal);
			}
			
			
			
			
		} catch (SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		if(criminals.size() == 0) {
			
			throw new CriminalException("Criminals database is Empty...!");
		}
		return criminals;
	}

	@Override
	public String deleteCriminalByName(Criminal criminal) throws CriminalException {
		
		String message = " Sorry ! Record not deleted...!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("DELETE from Criminals where name = ?");
			
			ps.setString(1, criminal.getName());
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Criminal details deleted Successfully...!";
			}
			
		} catch (SQLException e) {
			message = e.getMessage();
		}
		
		return message;
	}

	
	

	

}
