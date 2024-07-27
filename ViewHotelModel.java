import java.util.*;

public class ViewHotelModel {
    
    private Hotel hotelViewed;
    private ArrayList<Room> availableList = new ArrayList<Room>();
    private Room room;

    public ViewHotelModel(Hotel hotel){
        this.hotelViewed = hotel;
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
}
