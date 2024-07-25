import java.util.*;
/**
* This class contains details about a Room in a Hotel
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class Room{
  /**
  * This variable contains a Rooom's name
  */
  private String name;
  /**
  * This variable contains a Room's price
  */
  private double price;
  /**
  * This variable contains an array of Boolean where it holds the
  * availability of the rooms from day 1-31
  */
  private ArrayList<Boolean> availability;
  /**
  * This variable contains an array of Reservations where it contains instances
  * of Reservation objects
  */
  private ArrayList<Reservation> reservations;

  /**
  * This method creates a new Room instance 
  * @param name name of the room
  * @param price price of the room
  */
  public Room(String name, double price){
    this.name = name;
    this.price = price;
    this.availability = new ArrayList<Boolean>();
    this.reservations = new ArrayList<Reservation>();

    //sets all availability to true
    for(int i = 0; i < 31; i++){
        this.availability.add(true);
    }
  }
  /**
  * This method gets the name of a Room
  * @return name of a Room
  */
  public String getName(){
    return this.name;
  }

  /**
  * This method gets the price of a Room
  * @return price of a Room
  */
  public double getPrice(){
    return this.price;
  }

  /**
  * This method returns a boolean if a Room is available or not
  * on a day chosen by the usre
  * @param index day of availability
  * @return boolean value
  */
  public boolean isAvailable(int index){
    return this.availability.get(index);
  }

  public ArrayList<Boolean> getAvailability(){
    return this.availability;
  }

  /**
  * This method gets the array of Reservations of a Room instance
  * @return array of Reservations
  */
  public ArrayList<Reservation> getReservations(){
    return this.reservations;
  }

  /**
  * This method sets a new price for a Room
  * @param price new price of a Room
  */
  public void setPrice(double price){
    this.price = price;
  }

  /**
  * This method adds a Reservation instance to the array of Reservations
  * @param reservation a Reservation instance to be added
  * @return true {check in and check out dates are valid}
  * false {check in and check out days are invalid and they overlap other reservation dates}
  */
  public boolean addReservation(Reservation reservation){
    int checkIn = reservation.getCheckIn() - 1;
    int checkOut = reservation.getCheckOut() - 1;

    //Checks if out of bounds
    if (checkIn < 0 || checkOut > 30 || checkIn >= checkOut || checkIn == 31 || checkOut == 0) {
        System.out.println("\nInvalid Check-In/Check-Out Dates");
        return false;
    }

    //checks if the Room's availability does not overlap days that are set to false
    for (int i = checkIn; i < checkOut; i++) {
        if (this.availability.get(i) == false) {
            System.out.println("\nOverlapping Reservation Dates");
            return false;
        }
    }
    
    //sets the Room's days of availability to false
    for(int i = checkIn; i < checkOut; i++){
        this.availability.set(i, false);
    }
    
    this.reservations.add(reservation);
    
    System.out.println("\nReservation Successful\n");
    return true;
  }
  /**
  * This method removes a Reservation instance from an array of Reservations
  * @param reservation a Reservation instance to be removed
  */
  public void removeReservation(Reservation reservation){
    for(int i = 0; i < this.reservations.size(); i++){
      //finds the reservation of the guest name
        if(this.reservations.get(i).getGuestName().equals(reservation.getGuestName())){
            int checkIn = reservation.getCheckIn() - 1;
            int checkOut = reservation.getCheckOut() - 1;

            //Removes reservation by setting the availability of the range of days to true
            for(int j = checkIn; j < checkOut; j++){
                this.availability.set(j, true);
            }

            this.reservations.remove(i);
            System.out.println("\nSuccessfully Removed Reservation");
            return;
        }
    }

    System.out.println("\nGuest Name Not Found");
  }
  
}
