package BusReservation;

import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	int busNo;
	Date date;
	int passengerAge;
	
	
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("To Book your travel please enter following details");
				
	
			System.out.println("Enter name of passenger: ");
			passengerName = scanner.next();
			System.out.println("Enter bus no: ");
			busNo = scanner.nextInt();
			System.out.println("Enter date dd-mm-yyyy");
			String dateInput = scanner.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			System.out.println("Enter age of passenger: ");
			passengerAge=scanner.nextInt();
			
			
			try {
				date = dateFormat.parse(dateInput);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	
	
	public boolean isAvailable()  throws SQLException{
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);

		int booked = bookingdao.getBookedCount(busNo,date);
		
		
		
		return booked<capacity;
		
	}
public void bookingInfo() throws SQLException {
		
		String query =  "SELECT *from bookingInfo where passenger_name=? order by booking_id desc";

		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, passengerName);
		ResultSet rs = pst.executeQuery();
		rs.next();
		System.out.println("Your Booking Id : "+rs.getInt(1));
		System.out.println("Your name : "+rs.getString(2));
		System.out.println("Your busno: "+rs.getInt(3));
		System.out.println("Your Booking date : "+rs.getDate(4));
		
		System.out.println("------------------------------------------");
	}
	


	
}