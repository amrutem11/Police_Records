package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.Exceptions.CrimeException;
import com.Model.Crime;
import com.Util.DBUtil;

public class CrimeDaoImpl implements CrimeDao {

	@Override
	public String addNewCrime(Crime crime) throws Exception {
		
		String message = "Sorry ! Crime Details not added";
		
		try(Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement  ps = conn.prepareStatement("insert into crime values (?,?,?,?,?,?)");
			ps.setInt(1, crime.getCrimeId());
			ps.setString(2, crime.getDate());
			ps.setString(3, crime.getPlace());
			ps.setString(4, crime.getDescription());
			ps.setString(5, crime.getSuspects());
			ps.setString(6, crime.getStatus());
			

			int x = ps.executeUpdate();
			
			if(x > 0) {
				message = "Crime details added Successfully...!";
			}
		}catch (SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		
		return message;
		
	}

}
