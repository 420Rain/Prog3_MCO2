import java.util.*;

public class ViewHotelModel {
    
    private Hotel hotelViewed;
    private ArrayList<Room> availableList = new ArrayList<Room>();
    private Room room;

    public ViewHotelModel(Hotel hotel){
        this.hotelViewed = hotel;
    }

    public Hotel getHotel(){
        return hotelViewed;
    }

    public ArrayList<Room> getAvailableRooms(int day){
        for(int i = 0; i < hotelViewed.getNumRooms(); i++){
            room = hotelViewed.getRooms().get(i);
            if(isAvailable(room, day) == true){
                availableList.add(room);
            }
        }

        return availableList;
    }

    public boolean isAvailable(Room room, int day){
        Iterator<Boolean> availability = room.getAvailability().iterator();

        while(availability.hasNext()){
            if(availability.next() == true){
                return true;
            }
        }

        return false;
    }

    public Room findRoom(ArrayList<Room> roomList, String roomName){
        Iterator<Room> roomListIterator = roomList.iterator();

        while(roomListIterator.hasNext()){
            Room room = roomListIterator.next();
            if(room.getName().equals(roomName)){
                return room;
            }
        }

        return null;
    }

    public boolean findGuestRes(String name, int roomIndex, int resIndex){
        ArrayList<Room> roomList = hotelViewed.getRooms();

        for(int i = 0; i < roomList.size(); i++){
            ArrayList<Reservation> resList = roomList.get(i).getReservations();
            for(int j = 0; j < resList.size(); j++){
                Reservation reservation = resList.get(j);
                if(reservation.getGuestName().equals(name)){
                    roomIndex = i;
                    resIndex = j;
                    return true;
                }
            }
        }

        return false;
    }
}
