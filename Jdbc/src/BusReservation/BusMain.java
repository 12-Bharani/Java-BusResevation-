package BusReservation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner; 



public class BusMain {

	public static void main(String[] args) throws SQLException  {
		int password=3828;
		int userPassword;
	
	
			
			int userOpt = 1;
		
		
			Scanner scanner = new Scanner(System.in);
					
			while(userOpt==1) {
				
				System.out.println("Enter 1 to display all bus information\"\r\n"
						+ "	Enter 2 to display filter\"\r\n"
						+ "	Enter 3 to cancel previous bookings\"\r\n"
						+ "	Enter 4 to Update Bus information as admin");	
				System.out.println("------------------------------------------");
				userOpt = scanner.nextInt();
				
			
				if(userOpt==2) {
					BusDAO bus=new BusDAO();
					bus.BusAvailability();
					Booking booking = new Booking();
					
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
						System.out.println("Please check your booked details.....");
						booking.bookingInfo();
						System.out.println("To continue for another booking enter below options\"\r\n"
								+ " or enter 0 to exit\"\r\n");
					}
				}
				
				else if(userOpt == 1) {
					BusDAO busdao = new BusDAO();
					
					
					
					
					busdao.displayBusInfo();
					Booking booking = new Booking();
				
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
						System.out.println("Please check your booked details.....");
						booking.bookingInfo();
						
						
					
					
					}
					else {
						System.out.println("Sorry. Bus is full. Try another bus or date.");
					}
				}
				
				else if(userOpt==3) {
					Cancel cancelBooking=new Cancel();
					System.out.println("Do you want to cancel booking ?");
					System.out.println("please Enter your booking id...");
					int bookingId=scanner.nextInt();
					cancelBooking.cancel(bookingId);
					
				}
				else if(userOpt==4) {
					System.out.println("enter password");
					userPassword=scanner.nextInt();
					if(password==userPassword) {
						AddBusDetails details=new AddBusDetails();
						details.addDetails();
						
					}
					
				}
				else if(userOpt==1) {
					
				}
				
				
			
			}
			scanner.close();
		}
		
		
	}

