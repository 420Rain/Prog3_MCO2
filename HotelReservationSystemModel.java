import java.util.*;

/**
* This class is the model for the HotelReservationSystem which contains
* methods for creating a hotel and contains the data of Hotels
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class HotelReservationSystemModel {
    /**
     * This variable is an arraylist of hotels
     */
    private ArrayList<Hotel> Hotels;

    /**
     * Creates an instance of HotelReservationSystenmModel
     */
    public HotelReservationSystemModel(){
        this.Hotels = new ArrayList<Hotel>();
    }

    /**
     * This method creates a Hotel instance  and adds it to
     * the arrayList of Hotels
     * @param name name of the hotel
     * @param numOfRooms number of rooms of the hotel
     * @return -1 if hotel has similar name to another hotel in the arraylist
     *  -2 if the inputted number of rooms is invalid
     *  1 hotel is succesfully created
     */
    public int createHotel(String name, int numOfRooms){
        //Checks if the new Hotel's name exists within the array of Hotels
        for(int i = 0; i < this.Hotels.size(); i++){
            if(name.equals(this.Hotels.get(i).getName())){
                return -1;
            } 
        }
        //Checks if number of Rooms inputted by the User is within the Range
        if(numOfRooms < 1 || numOfRooms > 50){
            return -2;
        }
        //Creates Hotel instance
        this.Hotels.add(new Hotel(name, numOfRooms, 1299.0));

        return 1;
    }

    /**
     * This method gets the array lis of hotels and returns it
     * @return arraylist of Hotels
     */
    public ArrayList<Hotel> getHotelList() {
		return this.Hotels;
	}
}
