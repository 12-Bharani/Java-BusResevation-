package BusReservation;

public class Bus {
	private int busNo;
	private String driverName;
	private String boardingStation;
	private String destination;
	private String duration;
	private String busType;

	
	
	private boolean ac;
	private int capacity; //get and set
	
	
	Bus(int no,String driverName,String boardingStation,
			String destination,String duration,
			String busType,boolean ac,int cap){
		this.busNo = no;
		this.driverName=driverName;
		this.boardingStation =boardingStation ;
		this.destination= destination;
		this.duration= duration;
		this.busType= busType;
	
		this.ac = ac;
		this.capacity = cap;
		
	}
	
	public int getBusNo(){ //accessors
		return busNo;
	}
	
	public String getDriverName() {
		return driverName;
	}
	public String getBoardingStation() {
		return boardingStation;
	}	
	public String getDestination() {
		return destination;
	}
	public String getDuration() {
		return duration;
	}
	public String getBusType() {
		return busType;
	}
	public boolean isAc(){
		return ac;
	}
	public int getCapacity(){ //accessor method
		return capacity;
	}
	
	public void setAc(boolean val) { //mutators
		ac = val;
	}
	
	public void setCapacity(int cap) { //mutator
		capacity = cap;
	}
	
}