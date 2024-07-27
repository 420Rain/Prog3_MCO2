import java.util.*;

public class ManageHotelModel{

    private ArrayList<Hotel> hotelList;

    public ManageHotelModel(ArrayList<Hotel> hotelList){
        this.hotelList = hotelList;
    }

    public ArrayList<Hotel> getHotelList(){
        return this.hotelList;
    }

    public boolean changeName(Hotel hotel, String name){
        for(int i = 0; i < this.hotelList.size(); i++){
            if(this.hotelList.get(i).getName().equals(name)){
                return false;
            }
        }

        hotel.setName(name);
        return true;
    }

    public boolean addRoom(Hotel hotel) {
        // Check if a Room instance can still be added
        if (hotel.getNumRooms() < 50) {
            // Generate a unique name for the room
            String roomName = generateUniqueRoomName(hotel);
            // Creates a Room instance
            hotel.getRooms().add(new Room(roomName, hotel.getPrice()));
            hotel.addNumRoom();
            System.out.println(hotel.getNumRooms());
            System.out.println(hotel.getName());
            return true;
        } else {
            return false;
        }
    }

    //ensures all hotel room names are unique especially when removing a room
    private String generateUniqueRoomName(Hotel hotel) {
        String baseName = "Room";
        int count = hotel.getNumRooms();
        String uniqueName = baseName + " " + count;
    
        while (isRoomNameTaken(hotel, uniqueName)) {
            count++;
            uniqueName = baseName + " " + count;
        }
        return uniqueName;
    }
    
    private boolean isRoomNameTaken(Hotel hotel, String roomName) {
        for (Room room : hotel.getRooms()) {
            if (room.getName().equals(roomName)) {
                return true;
            }
        }
        return false;
    }

    /*public void removeRoom(Hotel hotel, String room){
        hotel.removeRoom(room);
    }*/

    public boolean removeRoom(Hotel hotel, String roomName){
        //Loops through a Hotel's Rooms
        for(int i = 0; i < hotel.getNumRooms(); i++){
            //Checks if chosen Room exists
            if(roomName.equals(hotel.getRooms().get(i).getName())){
                //Checks if chosen Room still has Reservations
                if(hotel.getRooms().get(i).getReservations().isEmpty()){
                    //Removes Room
                    hotel.getRooms().remove(i);
                    hotel.lessNumRoom();
                    System.out.println("\nRoom Successfully Removed");
                    return true;
                }
                else{
                    System.out.println("\nCannot Remove. Selected Room Currently Has Reservation/s");
                    return false;
                }
            }
        }
        return false;
      }

    public boolean updatePrice(Hotel hotel, double price){
        return hotel.setRoomPrice(price);
    }

    /*public void removeReservation(Room room, Reservation reservation){
        room.removeReservation(reservation);
    }*/

    public void removeReservation(Room room, Reservation reservation){
        for(int i = 0; i < room.getReservations().size(); i++){
          //finds the reservation of the guest name
            if(room.getReservations().get(i).getGuestName().equals(reservation.getGuestName())){
                int checkIn = reservation.getCheckIn() - 1;
                int checkOut = reservation.getCheckOut() - 1;
    
                //Removes reservation by setting the availability of the range of days to true
                for(int j = checkIn; j < checkOut; j++){
                    room.setAvailability().set(j, true);
                }
    
                room.getReservations().remove(i);
                System.out.println("\nSuccessfully Removed Reservation");
                return;
            }
        }
        System.out.println("\nGuest Name Not Found");
    }

    public void removeHotel(Hotel hotel){
        this.hotelList.remove(hotel);
    }



}