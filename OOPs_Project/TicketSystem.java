package OOPs_Project;

import java.util.*;

public class TicketSystem {
	private final List<String> availableBerths = new ArrayList<>(Arrays.asList("L", "M", "U")); // 3 berths
	private final Queue<Passenger> racQueue = new LinkedList<>(); // 1 RAC berth
	private final Queue<Passenger> waitingListQueue = new LinkedList<>(); // 1 waiting list
	private final List<Passenger> confirmedPassengers = new ArrayList<>();
	private int ticketCounter = 1;

	public void bookTicket(String name, int age, String gender, String berthpreference) {
		String ticketId = "T" + ticketCounter++;
		Passenger passenger;

		try {
			if (!availableBerths.isEmpty()) {
				String allocatedBerth = allocateBerth(age, gender, berthpreference);
				passenger = new Passenger(name, age, gender, berthpreference, allocatedBerth, ticketId);
				confirmedPassengers.add(passenger);
				availableBerths.remove(allocatedBerth);
				System.out.println("Ticket confirmed: " + passenger);
			} else if (racQueue.size() < 1) {
				passenger = new Passenger(name, age, gender, berthpreference, "RAC", ticketId);
				racQueue.offer(passenger);
				System.out.println("Ticket in RAC: " + passenger);
			} else if (waitingListQueue.size() < 1) {
				passenger = new Passenger(name, age, gender, berthpreference, "RAC", ticketId);
				waitingListQueue.offer(passenger);
				System.out.println("Ticket in Waiting List: " + passenger);
			} else {
				System.out.println("No Tickets Available");
			}
		} catch (Exception e) {
			System.out.println("Error during booking: " + e.getMessage());
		}
	}

	private String allocateBerth(int age, String gender, String berthpreference) {
		gender = gender.toLowerCase(); // Normalize inside method
		
		try {
			if ((age >= 60 || gender.equals("female")) && availableBerths.contains("L")) {
				return "L";
			}
			if (availableBerths.contains(berthpreference)) {
				return berthpreference;
			}
			return availableBerths.get(0); // This can throw IndexOutOfBoundsException or fallback
		} catch (Exception e) {
			System.out.println("Error during berth allocation: " + e.getMessage());
			return "L"; // Fallback berth
		}
	}

	public void cancelTicket(String ticketId) {
		try {
			Optional<Passenger> passengerOpt = confirmedPassengers.stream()
					.filter(p -> p.ticketId.equals(ticketId))
					.findFirst();

			if (passengerOpt.isPresent()) {
				Passenger passenger = passengerOpt.get();
				confirmedPassengers.remove(passenger);
				availableBerths.add(passenger.allottedBerth);

				if (!racQueue.isEmpty()) {
					Passenger racPassenger = racQueue.poll();
					String allocatedBerth = allocateBerth(racPassenger.age, racPassenger.gender,
							racPassenger.berthpreference);
					racPassenger.allottedBerth = allocatedBerth;
					confirmedPassengers.add(racPassenger);
					availableBerths.remove(allocatedBerth);
					System.out.println("RAC ticket moved to confirmed: " + racPassenger);
				}

				if (!waitingListQueue.isEmpty()) {
					Passenger waitingPassenger = waitingListQueue.poll();
					waitingPassenger.allottedBerth = "RAC";
					racQueue.offer(waitingPassenger);
					System.out.println("Waiting List ticket moved to RAC: " + waitingPassenger);
				}

				System.out.println("Ticket cancelled successfully for ID: " + ticketId);
			} else {
				System.out.println("No Ticket found with ID: " + ticketId);
			}
		} catch (Exception e) {
			System.out.println("Error during cancellation: " + e.getMessage());
		}
	}

	public void printBookedTickets() {
		try {
			if (confirmedPassengers.isEmpty()) {
				System.out.println("No confirmed tickets.");
			} else {
				System.out.println("Confirmed Tickets: ");
				for (Passenger passenger : confirmedPassengers) {
					System.out.println(passenger);
				}
			}
		} catch (Exception e) {
			System.out.println("Error displaying confirmed tickets: " + e.getMessage());
		}
	}

	public void printAvailableTickets() {
		try {
			System.out.println("Available Berths: " + availableBerths.size());
			System.out.println("Available RAC Tickets: " + (1 - racQueue.size()));
			System.out.println("Available Waiting List Tickets: " + (1 - waitingListQueue.size()));
		} catch (Exception e) {
			System.out.println("Error displaying available tickets: " + e.getMessage());
		}
	}

	public void viewRacTickets() {
		try {
			if (racQueue.isEmpty()) {
				System.out.println("No RAC tickets.");
			} else {
				System.out.println("RAC Tickets: ");
				for (Passenger passenger : racQueue) {
					System.out.println(passenger);
				}
			}
		} catch (Exception e) {
			System.out.println("Error displaying RAC tickets: " + e.getMessage());
		}
	}

	public void viewWaitingListTickets() {
		try {
			if (waitingListQueue.isEmpty()) {
				System.out.println("No Waiting List tickets.");
			} else {
				System.out.println("Waiting List Tickets: ");
				for (Passenger passenger : waitingListQueue) {
					System.out.println(passenger);
				}
			}
		} catch (Exception e) {
			System.out.println("Error displaying waiting list tickets: " + e.getMessage());
		}
	}
}
