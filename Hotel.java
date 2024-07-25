import java.util.*;
/**
* This class represents a Hotel where the hotel contains a name, 
* base price, earnings, and rooms
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class Hotel{
    /**
    * This variable contains the name of the Hotel
    */
    private String name;

    /**
    * This variable contains the base price for all the rooms in the Hotel
    */
    private double price;

    /**
    * This variable contains the total earnings of the Hotel
    */
    private double earnings;

    /**
     * This variable contains the number of Rooms in a Hotel
     */
    private int numRooms;

    /**
    * This variable is an array of Room objects which represents the rooms of the hotel
    */
    private ArrayList<Room> hotelRooms;

  /**
  * This method creates a new Hotel Instance
  * @param name the name of the hotel
  * @param numOfRooms the number of rooms of the hotel
  * @param roomPrice the base price of the rooms
  */
  public Hotel(String name, int numOfRooms, double roomPrice){
   this.name = name;
   this.price = roomPrice;
   this.numRooms = numOfRooms;
   this.hotelRooms = new ArrayList<Room>();

   //Creates Room instances until the numOfRooms limit
   for(int i = 0; i < numOfRooms; i++){
     hotelRooms.add(new Room("Room " + (i + 1), roomPrice));
   }
 }

  /**
  * This method adds a Room object to the array of Room Objects in the Hotel
  * if number of Rooms is less than 50
  */
  public void addRoom(){
    //Checks if a Room instance can still be added
    if(numRooms < 50){
      //Creates a Room instance
      hotelRooms.add(new Room("Room " + (numRooms + 1), price));
      numRooms++;
      System.out.println("\nRoom Added Successfully");
    }
    else {
      System.out.println("\nCannot Add Room. Max Number of Rooms Reached");
    }
  }

  /**
  * This method removes a Room object from an array of Room Objects in the Hotel
  * @param roomName name of the Room object
  */
  public void removeRoom(String roomName){
    //Loops through a Hotel's Rooms
    for(int i = 0; i < numRooms; i++){
        //Checks if chosen Room exists
      if(roomName.equals(hotelRooms.get(i).getName())){
          //Checks if chosen Room still has Reservations
        if(hotelRooms.get(i).getReservations().isEmpty()){
            //Removes Room
            hotelRooms.remove(i);
            numRooms--;
            System.out.println("\nRoom Successfully Removed");
            return;
        }
        else{
            System.out.println("\nCannot Remove. Selected Room Currently Has Reservation/s");
            return;
        }
      }
    }
    System.out.println("\nRoom Name Not Found");
  }

  /**
  * This method gets the name of the Hotel
  * @return name of the Hotel
  */
  public String getName(){
    return this.name;
  }

  /**
  * This method gets the base price of the Rooms of the Hotel
  * @return base price of the Rooms
  */
  public double getPrice(){
    return this.price;
  }
  
  /**
  * This method gets the earnings of the Hotel
  * @return earnings of the Hotel
  */
  public double getEarnings(){
    double temp = 0;
    //adds all the totalPrice of the Reservations in a Hotel
    for(int i = 0; i < numRooms; i++){
      for(int j = 0; j < hotelRooms.get(i).getReservations().size(); j++){
        temp += hotelRooms.get(i).getReservations().get(j).getTotalPrice();
      }
    }
    this.earnings = temp;
    return this.earnings;
  }

  /**
  * This method gets the number of Rooms of the Hotel
  * @return number of rooms of the Hotel
  */
  public int getNumRooms(){
    return this.numRooms;
  }

  public Room getRoom(int index){
    return hotelRooms.get(index);
  }

  /**
  * This method gets the array of Rooms of the Hotel
  * @return array of Rooms
  */
  public ArrayList<Room> getRooms(){
     return this.hotelRooms;   
  }

  /**
  * This method sets a new name of the Hotel as it replaces the old one
  * @param name name of the hotel
  */
  public void setName(String name){ //error handling in hotelManager to check if list of hotels contain inputted name
    this.name = name;
  }

  /**
  * This method changes the new base price of the Rooms in the Hotel
  * @param price base price of a Room
  */
  public void setRoomPrice(double price){
    for(int i = 0; i < numRooms; i++){ //cause you can only change price if theres no reservations in all rooms
      if(!hotelRooms.get(i).getReservations().isEmpty()){
        System.out.println("\nCould Not Change Price. Some Rooms Have Reservations");
        return;
      }
    }

    this.price = price;

    for(int i = 0; i < numRooms; i++){
      hotelRooms.get(i).setPrice(price);
    }
    
    System.out.println("\nSuccessfully Changed the Room Prices");
  }

}
