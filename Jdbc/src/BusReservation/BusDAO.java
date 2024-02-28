package BusReservation;

import java.sql.*;
import java.util.Scanner;

public class BusDAO {
	public void displayBusInfo() throws SQLException {
		String query = "Select * from bus";
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		
		while(rs.next()) {
			System.out.println("Bus No: " + rs.getInt(1));
			if(rs.getInt(8)==0)
				System.out.println("AC: no ");
			else
				System.out.println("AC: yes ");
			System.out.println("Driver name: " + rs.getString(2));
			System.out.println("Boarding Station: "+ rs.getString(3));
			System.out.println("Destination: "+ rs.getString(4));
			System.out.println("Duration: "+ rs.getString(5));
			System.out.println("Bus Type: "+ rs.getString(7));
			System.out.println("Capacity: " + rs.getInt(6));
			System.out.println("------------------------------------------");
			
		}
		
		System.out.println("------------------------------------------");
	}
	
	public int getCapacity(int id) throws SQLException {
		String query = "Select capacity from bus where bus_no=" + id;
		Connection con = DbConnection.getConnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	
	public void BusAvailability() throws SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the boardingStation.....");
		String boardingStation=scanner.next();
		System.out.println("Enter the Destination.....");
		String destination=scanner.next();
		String query = "Select * from bus where Boarding_Station=? and Destination=?";
		Connection con = DbConnection.getConnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1,boardingStation);
		pst.setString(2, destination);
		ResultSet rs=pst.executeQuery();
		
		while(rs.next()) {
			System.out.println("Bus No: " + rs.getInt(1));
			System.out.println("Driver name: " + rs.getString(2));
			System.out.println("Boarding Station: "+ rs.getString(3));
			System.out.println("Destination: "+ rs.getString(4));
			System.out.println("Duration: "+ rs.getString(5));
			System.out.println("Bus Type: "+ rs.getString(7));
			System.out.println("Capacity: " + rs.getInt(6));
			System.out.println("Ac :"+rs.getBoolean(8));
			System.out.println("------------------------------------------");
		}
		System.out.println("------------------------------------------");
		
	}

	
	
}