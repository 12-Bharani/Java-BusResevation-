package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class BusInfo {
	String passengerName;
	int id;
	BusInfo(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id: ");
		id = scanner.nextInt();
		
	}
	public void bookingInfo() throws SQLException {
		
		String query =  "SELECT * from booking where booking_id="+id;

	Connection con = DbConnection.getConnection();
	Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		System.out.println("Your Booking Id : "+rs.getInt(1));
		System.out.println("Your name : "+rs.getString(2));
		System.out.println("Your busno: "+rs.getInt(3));
		System.out.println("Your Booking date : "+rs.getDate(4));
		
	}
	

}
