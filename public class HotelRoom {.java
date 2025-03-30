 public class HotelRoom {
    private int roomNumber;
    private boolean isReserved;
    private String guestName;

    public HotelRoom(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isReserved = false;
        this.guestName = "";
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve(String guestName) {
        this.isReserved = true;
        this.guestName = guestName;
    }

    public void cancelReservation() {
        this.isReserved = false;
        this.guestName = "";
    }

    public String getGuestName() {
        return guestName;
    }

    @Override
    public String toString() {
        return "Room " + roomNumber + " - " + (isReserved ? "Reserved by " + guestName : "Available");
    }


import java.util.Scanner;
public class ReservationSystem {
    private HotelRoom[] rooms;
  
    public ReservationSystem(int totalRooms) {
        rooms = new HotelRoom[totalRooms];
        for (int i = 0; i < totalRooms; i++) {
            rooms[i] = new HotelRoom(i + 1); // Rooms are numbered starting from 1
        }
    }

    public void displayRooms() {
        for (HotelRoom room : rooms) {
            System.out.println(room);
        }
    }

    public void bookRoom(int roomNumber, String guestName) {
        if (roomNumber < 1 || roomNumber > rooms.length) {
            System.out.println("Invalid room number.");
            return;
        }

        HotelRoom room = rooms[roomNumber - 1];
        if (room.isReserved()) {
            System.out.println("Room " + roomNumber + " is already reserved.");
        } else {
            room.reserve(guestName);
            System.out.println("Room " + roomNumber + " successfully reserved for " + guestName);
        }
    }

    public void cancelReservation(int roomNumber) {
        if (roomNumber < 1 || roomNumber > rooms.length) {
            System.out.println("Invalid room number.");
            return;
        }

        HotelRoom room = rooms[roomNumber - 1];
        if (!room.isReserved()) {
            System.out.println("Room " + roomNumber + " is not reserved.");
        } else {
            room.cancelReservation();
            System.out.println("Reservation for room " + roomNumber + " has been canceled.");
        }
    }


import java.util.Scanner; 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem(10); // Let's assume the hotel has 10 rooms

        while (true) {
            System.out.println("\n--- Hotel Reservation System ---");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    reservationSystem.displayRooms();
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter your name: ");
                    String guestName = scanner.nextLine();
                    reservationSystem.bookRoom(roomNumber, guestName);
                    break;

                case 3:
                    System.out.print("Enter room number to cancel: ");
                    int cancelRoomNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    reservationSystem.cancelReservation(cancelRoomNumber);
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");

            };
        };
    };
};
};
};