package OOPs_Project;

import java.util.*;

public class TicketBooking {
	public static void main(String ... args) {
		TicketSystem ticketSystem = new TicketSystem();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\nRailway Booking System:");
			System.out.println("1. Book Ticket");
			System.out.println("2. Cancel Ticket");
			System.out.println("3. View Confirmed Tickets");
			System.out.println("4. View Available Tickets");
			System.out.println("5. View RAC Tickets");
			System.out.println("6. View Waiting List Tickets");
			System.out.println("7. Exit");
			
//			System.out.println("Enter your choice: ");
//			int choice = sc.nextInt();
//			sc.nextLine(); // Consume new line
			
			int choice = -1;
			while (true) {
			    System.out.print("Enter your choice: ");
			    String input = sc.nextLine();
			    try {
			        choice = Integer.parseInt(input);
			        if (choice < 1 || choice > 7) {
			            System.out.println("Invalid choice. Please enter a number between 1 and 7.");
			        } else {
			            break; // valid input
			        }
			    } catch (NumberFormatException e) {
			        System.out.println("Invalid input. Please enter a valid number.");
			    }
			}

			
			switch (choice) {
				case 1:
					System.out.print("Enter Name: ");
					String name = sc.nextLine();

//					System.out.print("Enter Age: ");
//					int age = sc.nextInt();
//					sc.nextLine(); // Consume newline
					int age = 0;
                    while (true) {
                        System.out.print("Enter Age: ");
                        try {
                            age = Integer.parseInt(sc.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid age. Please enter a valid number.");
                        }
                    }

					System.out.print("Enter Gender (Male/Female): ");

					String gender = sc.nextLine().toLowerCase(); // Normalize gender

					System.out.print("Enter Berth Preference (L/U/M): ");

					String berthPreference = sc.nextLine().toUpperCase(); // Normalize berth preference

					//calls the bookTicket class of TicketSystem class

					ticketSystem.bookTicket(name, age, gender, berthPreference);

					break;
				
				case 2:
					System.out.print("Enter Ticket ID to Cancel: ");
					
					String ticketId = sc.nextLine();
					ticketSystem.cancelTicket(ticketId);

					break;

				case 3:
					ticketSystem.printBookedTickets();
					break;

				case 4:
					ticketSystem.printAvailableTickets();
					break;

				case 5:
					ticketSystem.viewRacTickets();
					break;

				case 6:
					ticketSystem.viewWaitingListTickets();
					break;
				case 7:
					System.out.println("Exiting...");
					System.exit(0);

				default:
					System.out.println("Invalid choice. Try again.");

				}
			}
		}
	}
