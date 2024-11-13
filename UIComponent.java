import java.util.Scanner;
import java.util.List;
public class UIComponent {
    private HotelService hotelService;
    private BookingService bookingService;
    private PaymentService paymentService;
    private NotificationService notificationService;
    private UserManagementService userManagementService;

    public UIComponent(HotelService hotelService, BookingService bookingService, PaymentService paymentService,
                       NotificationService notificationService, UserManagementService userManagementService) {
        this.hotelService = hotelService;
        this.bookingService = bookingService;
        this.paymentService = paymentService;
        this.notificationService = notificationService;
        this.userManagementService = userManagementService;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Booking System!");

        while (true) {
            System.out.println("1. Search Hotels");
            System.out.println("2. Book Room");
            System.out.println("3. View My Bookings");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    searchHotels();
                    break;
                case 2:
                    bookRoom();
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    private void searchHotels() {
        System.out.println("Enter location:");
        String location = new Scanner(System.in).nextLine();
        hotelService.findHotelsByCriteria(location);
    }

    private void bookRoom() {
        System.out.println("Enter hotel name:");
        String hotelName = new Scanner(System.in).nextLine();
        System.out.println("Enter room type:");
        String roomType = new Scanner(System.in).nextLine();
        System.out.println("Enter dates (dd-mm-yyyy):");
        String dates = new Scanner(System.in).nextLine();

        if (bookingService.checkAvailability(hotelName, roomType, dates)) {
            bookingService.bookRoom(hotelName, roomType, dates);
            paymentService.processPayment();
            notificationService.sendBookingConfirmation();
        } else {
            System.out.println("Room not available.");
        }
    }

    private void viewBookings() {
        System.out.println("Displaying bookings...");
    }
}

