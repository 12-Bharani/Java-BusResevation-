package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Cancel {
	String passengerName;
	int bookingId;
	
	
		
		
		

	public void  cancel(int id)throws SQLException {
		
	
		
		
		String query = "delete from bookingInfo where booking_id="+id;
		
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		 int rows=st.executeUpdate(query);
		 
	
		
		System.out.println("No of rows affected: "+ rows);
		
		if(rows==1) {
			System.out.println("your booking was canceled....");
			
			
		}
		con.close();
	}

}
