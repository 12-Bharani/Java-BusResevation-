package BusReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddBusDetails {
	int busNo;
	String driverName;
	String boardingStation;
	String destination;
	String duration;
	String busType;
	boolean ac;
	int capacity;
	
	
		AddBusDetails()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter busNo: ");
			busNo=scanner.nextInt();
			System.out.println("Enter driverName: ");
			driverName=scanner.next();
			System.out.println("Enter boarding station: ");
			boardingStation=scanner.next();
			System.out.println("Enter destination: ");
			destination=scanner.next();
			System.out.println("Enter duration: ");
			duration=scanner.next();
			System.out.println("Enter bus type: ");
			busType=scanner.next();
			System.out.println("Enter capacity: ");
			capacity=scanner.nextInt();
			System.out.println("Enter Ac or not: ");
			ac=scanner.nextBoolean();
			
			
		}
		
		public void addDetails() throws SQLException {
			String query = "Insert into bus(Bus_no,Driver_name,Boarding_Station,Destination,Duration,capacity,Bus_type,Ac) values(?,?,?,?,?,?,?,?)";
			Connection con = DbConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, busNo);
			pst.setString(2, driverName);
			pst.setString(3, boardingStation);
			pst.setString(4, destination);
			pst.setString(5, duration);
			pst.setInt(6, capacity);
			pst.setString(7, busType);
			pst.setBoolean(8, ac);
			pst.executeUpdate();
			con.close(); 
			
			
			System.out.println("Sucessfully data inserted........");
		}
		
		
		
		


}
