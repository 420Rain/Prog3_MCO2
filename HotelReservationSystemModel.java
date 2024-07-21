import java.util.*;

public class HotelReservationSystemModel {
    private ArrayList<Hotel> Hotels;

    public HotelReservationSystemModel(){
        this.Hotels = new ArrayList<Hotel>();
    }

    public boolean createHotel(String name, int numOfRooms){
        //Checks if the new Hotel's name exists within the array of Hotels
        for(int i = 0; i < this.Hotels.size(); i++){
            if(name.equals(this.Hotels.get(i).getName())){
                return false;
            } 
        }
        //Checks if number of Rooms inputted by the User is within the Range
        if(numOfRooms < 1 || numOfRooms > 50){
            return false;
        }
        //Creates Hotel instance
        this.Hotels.add(new Hotel(name, numOfRooms, 1299.0));

        return true;
    }

    public ArrayList<Hotel> getHotelList() {
		return this.Hotels;
	}
}
