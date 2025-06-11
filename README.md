# Indian Railway Ticket Booking System (Java OOPs Project)

This is a simple simulation of the **Indian Railway Ticket Booking System** built using **Object-Oriented Programming (OOP)** concepts in **Java**. The system manages berth allocations, RAC (Reservation Against Cancellation), and Waiting List tickets based on user inputs.

---

## 🎯 Features

- ✅ Booking tickets with berth preference (Lower, Middle, Upper)
- ✅ Auto allocation of RAC ticket if berths are full
- ✅ Waiting List ticket when both berths and RAC are full
- ✅ Automatic upgrades: 
  - RAC → Confirmed when a ticket is cancelled
  - Waiting List → RAC if RAC becomes available
- ✅ Ticket cancellation by Ticket ID
- ✅ View:
  - Confirmed tickets
  - Available berths
  - RAC queue
  - Waiting list queue
- ✅ Full input validation and crash prevention using exception handling

---

## 🛠️ Tech Stack

- Java OOPs (JDK 11+ recommended)
- Collections: `ArrayList`, `Queue`, `LinkedList`
- Basic console I/O (`Scanner`)

---

## 🧠 Constraints Simulated

- ✅ Total Berths: `3` (`L`, `M`, `U`)
- ✅ RAC Capacity: `1` passenger
- ✅ Waiting List Capacity: `1` passenger
- ❌ No real database or file storage (in-memory only)
- ❌ No GUI — Console only

---

## 🚀 How to Run

1. Clone this repository
2. Compile using a Java IDE (like IntelliJ / Eclipse) or terminal:
   ```bash
   javac Passenger.java TicketSystem.java TicketBooking.java
   java TicketBooking
