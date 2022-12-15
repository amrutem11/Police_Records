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


public  class CriminalsDaoImpl implements CriminalsDao{

	// to add new criminal;
	
	@Override
	public String addNewCriminal(Criminal criminal) throws Exception {
		
		String message = "Sorry ! Criminal's Details not added";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("insert into criminals values (?,?,?,?,?,?,?,?)");
			
			ps.setInt(1, criminal.getAssCrimeId());
			
			ps.setString(2, criminal.getName());
			
			ps.setInt(3, criminal.getAge());
			
			ps.setString(4, criminal.getGender());
			
			ps.setString(5, criminal.getAddress());
			
			ps.setString(6, criminal.getIdentifyingMark());
			
			ps.setString(7, criminal.getAreaOfArrest());
			
			ps.setString(8, criminal.getAttatchedCrime());
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				message = "Criminal details added Successfully...!";
			}
			
		} catch (SQLException e) {
			
			throw new CriminalException(e.getMessage());
		}
		
		return message;
	}

	// to view all criminals;
	
	public List<Criminal> viewAllCriminals() throws CriminalException {
		
		List<Criminal> criminals = new ArrayList<Criminal>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("select * from Criminals");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int c = rs.getInt("AssCrimeId");
				
				String n = rs.getString("name");
				
				int a = rs.getInt("age");
				
				String g = rs.getString("gender");
				
				String ad = rs.getString("address");
				
				String im = rs.getString("identifyingMark");
				
				String aa = rs.getString("areaOfArrest");
				
				String ac = rs.getString("AttatchedCrime");
				
				Criminal criminal = new Criminal();
				
				criminal.setAssCrimeId(c);
				
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

	
	
	// to delete criminals by name;
	
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

	// to search criminal by name;
	
	@Override
	public Criminal searchcriminalByName(String Name) {
			
		Criminal criminal = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement  ps =	conn.prepareStatement("select * from criminals where Name = ?");
		
		ps.setString(1, Name);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			int c = rs.getInt("AssCrimeId");
			
			String n = rs.getString("Name");
			
			int a = rs.getInt("Age");
			
			String g = rs.getString("Gender");
			
			String ad = rs.getString("Address");
			
			String im = rs.getString("IdentifyingMark");
			
			String aa = rs.getString("AreaOfArrest");
			
			String ac = rs.getString("AttatchedCrime");
			
			 criminal = new Criminal();
			 
			 criminal.setAssCrimeId(c);
			 
			 criminal.setName(n);
			 
			 criminal.setAge(a);
			 
			 criminal.setGender(g);
			 
			 criminal.setAddress(ad);
			 
			 criminal.setIdentifyingMark(im);
			 
			 criminal.setAreaOfArrest(aa);
			 
			 criminal.setAttatchedCrime(ac);
			
		}

		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return criminal;
	}
	
	// To get criminals areawise;
	
	@Override
	public List<Criminal> getCriminalsAreaWise(String area) {
		
		List<Criminal> criminals = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from criminals where address = ? ");
			
			ps.setString(1,area);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int c = rs.getInt("AssCrimeId");
				
				String n = rs.getString("Name");	
				
				int a = rs.getInt("Age");
				
				String g = rs.getString("gender");
				
				String ad = rs.getString("address");
				
				String im = rs.getString("IdentifyingMark");
				
				String aa = rs.getString("AreaOfArrest");
				
				String ac = rs.getString("AttatchedCrime");
				
				
			
				Criminal criminal = new Criminal();
				
				criminal.setAssCrimeId(c);
				
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
			
			System.out.println(e.getMessage());
		}
			
		return criminals;
		
	}

}

	

	
	

	


