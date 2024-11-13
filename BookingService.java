public class BookingService {
    public boolean checkAvailability(String hotelName, String roomType, String dates) {
        System.out.println("Checking availability for " + hotelName + " " + roomType + " on " + dates);
        return true;  
    }

    public void bookRoom(String hotelName, String roomType, String dates) {
        System.out.println("Room booked: " + hotelName + " " + roomType + " on " + dates);
    }
}
