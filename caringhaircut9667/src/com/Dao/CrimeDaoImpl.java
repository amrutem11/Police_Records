package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Exceptions.CrimeException;
import com.Exceptions.CriminalException;
import com.Model.Crime;
import com.Model.Criminal;
import com.Util.DBUtil;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public String addNewCrime(Crime crime) throws Exception {
		
		String message = "Sorry ! Crime Details not added";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("insert into crime values (?,?,?,?,?,?,?,?)");
			ps.setInt(1, crime.getCrimeId());
			ps.setString(2, crime.getDate());
			ps.setString(3, crime.getPlace());
			ps.setString(4, crime.getDescription());
			ps.setString(5, crime.getVictims());
			ps.setString(6, crime.getDetailDescription());
			ps.setString(7, crime.getSuspects());	
			ps.setString(8, crime.getStatus());
			

			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Crime details added Successfully...!";
			}
		}catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return message;
		
	}

	@Override
	public Crime searchCrimebasedOnId(int crimeId) {
		
		Crime crime = null;
		
		try (Connection conn = DBUtil.provideConnection()){
			
		PreparedStatement ps =	conn.prepareStatement("select * from crime where crimeId = ?");
		
		ps.setInt(1, crimeId);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			
			int ci = rs.getInt("crimeId");
			String d = rs.getString("Date"); 
			String p = rs.getString("place");
			String desc = rs.getString("Description");
			String v = rs.getString("victims");
			String dd = rs.getString("DetailDescription");
			String s = rs.getString("Suspects");
			String St = rs.getString("Status");
					
			
			crime = new Crime();
			
			crime.setCrimeId(ci);
			crime.setDate(d);
			crime.setPlace(p);
			crime.setDescription(desc);
			crime.setVictims(v);
			crime.setDetailDescription(dd);
			crime.setSuspects(s);
			crime.setStatus(St);
			
		}
				
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return crime;
		
	}
	
	
	@Override
	public String updateCrimeStatus(Crime crime) {


		String message = "Status not updated...";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update crime set Status = ? where CrimeId = ?");
			
			ps.setString(1,crime.getStatus());
			ps.setInt(2,crime.getCrimeId() );
			
			
			int x = ps.executeUpdate();
			
			if(x > 0) {
				
				message = "Status updated successfully";
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message = e.getMessage();
		}
		
		
		return message;
	}


	
	//to view all crime records;
	
	@Override
	public List<Crime> viewAllCrimes() throws CrimeException {
		
		List<Crime> crimes = new ArrayList<Crime>();
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("select * from Crime");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ci = rs.getInt("CrimeId");
				String  d = rs.getString("Date");
				String p = rs.getString("Place");
				String ds = rs.getString("Description");
				String v = rs.getString("Victims");
				String dd = rs.getString("DetailDescription");
				String s = rs.getString("Suspects");
				String st = rs.getString("Status");
				
				Crime crime = new Crime();
				
				crime.setCrimeId(ci);
				crime.setDate(d);
				crime.setPlace(p);
				crime.setDescription(ds);
				crime.setVictims(v);
				crime.setDetailDescription(dd);
				crime.setSuspects(s);
				crime.setStatus(st);
				
				
				crimes.add(crime);
			}
			
			
			
			
		} catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		if(crimes.size() == 0) {
			
			throw new CrimeException("Crime database is Empty...!");
		}
		return crimes;
	}

	// to view all crimes areaWise
	
	@Override
	public List<Crime> getCrimeAreaWise(String place) {
	
		
		List<Crime> crimes = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from crime where Place = ?");
			
			ps.setString(1,place);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ci = rs.getInt("CrimeId");				
				String d = rs.getString("date");
				String p = rs.getString("Place");
				String ds = rs.getString("Description");
				String v = rs.getString("Victims");
				String dd = rs.getString("DetailDescription");
				String s = rs.getString("suspects");
				String st = rs.getString("Status");
				
			
				Crime crime = new Crime();
				
				crime.setCrimeId(ci);
				crime.setDate(d);
				crime.setPlace(p);
				crime.setDescription(ds);
				crime.setVictims(v);
				crime.setDetailDescription(dd);
				crime.setSuspects(s);
				crime.setStatus(st);
				
				
				crimes.add(crime);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		
		return crimes;
		
	}

	
	
	// To show the number of solved and notsolved crime;
	
	
	@Override
	public List<Crime> crimeStats(String status) {
		
		List<Crime> crimes = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from crime where Status = ?");
			
			ps.setString(1,status);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ci = rs.getInt("CrimeId");				
				String d = rs.getString("date");
				String p = rs.getString("Place");
				String ds = rs.getString("Description");
				String v = rs.getString("Victims");
				String dd = rs.getString("DetailDescription");
				String s = rs.getString("suspects");
				String st = rs.getString("Status");
				
			
				Crime crime = new Crime();
				
				crime.setCrimeId(ci);
				crime.setDate(d);
				crime.setPlace(p);
				crime.setDescription(ds);
				crime.setVictims(v);
				crime.setDetailDescription(dd);
				crime.setSuspects(s);
				crime.setStatus(st);
				
				
				crimes.add(crime);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		int count = crimes.size();
		
		System.out.println("Number of "+ status +  " crime is : " + count);
		
		return crimes;
		
		
	}

	
	////to show the number of crimes recorded in current month;
	
	@Override
	public List<Crime> crimeRecordedInCurrentMonth() {
		
		
		List<Crime> crimes = new ArrayList<>();
		
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("select * from crime where Month(Date) = Month(SYSDATE())");
			
		
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int ci = rs.getInt("CrimeId");				
				String d = rs.getString("date");
				String p = rs.getString("Place");
				String ds = rs.getString("Description");
				String v = rs.getString("Victims");
				String dd = rs.getString("DetailDescription");
				String s = rs.getString("suspects");
				String st = rs.getString("Status");
				
			
				Crime crime = new Crime();
				
				crime.setCrimeId(ci);
				crime.setDate(d);
				crime.setPlace(p);
				crime.setDescription(ds);
				crime.setVictims(v);
				crime.setDetailDescription(dd);
				crime.setSuspects(s);
				crime.setStatus(st);
				
				
				crimes.add(crime);
			}
			
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		int count = crimes.size();
		
		System.out.println("Number of crime recorded in current month is : " + count);
		
		return crimes;
	}


	
}

	
