package OOPs_Project;

public class Passenger {

	String name;
	int age;
	String gender;
	String berthpreference; // Lower, Middle, Upper
	String allottedBerth;
	String ticketId; // important for cancelling ticket
	
	public Passenger(String name, int age, String gender, String berthpreference, String allottedBerth, String ticketId) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.berthpreference = berthpreference;
		this.allottedBerth = allottedBerth;
		this.ticketId = ticketId;
		
	}
	
	@Override
	public String toString() {
		return "Ticket ID: " + ticketId + ", Name: " + name + ", Age: " + age + 
				", Gender: "+ gender + ", Berth: " + allottedBerth; 
	}
	

}
