import java.util.*;
/**
* This class contains the information 
* of a Reservation in a Room
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class Reservation{
    /**
    * This variable contains the guest's name who created the Reservation
    */
    private String guestName;

    /**
    * This variable contains the day of check in of the Reservation
    */
    private int checkIn;

    /**
    * This variable contains the day of check out of the Reservation
    */
    private int checkOut;

    /**
    * This variable contains the Room object wherein the Reservation is placed
    */
    private Room roomInfo;

    /**
    * This variable contains the total price of the Reservation depending on the days
    * the guest will stay
    */
    private double totalPrice;
    private String discountCode;
    private ArrayList<String> priceBreakdownList;

    private ArrayList<String> priceBreakdownList;

    /**
    * This method creates a Reservation instance
    * @param username name of the Guest
    * @param checkIn a number representing the day the guest will check in
    * @param checkOut a number representing the day the guest will check out
    * @param room a Room object where the Reservation will take place
    */
    public Reservation(String username, int checkIn, int checkOut, Room room, String discount){
      this.guestName = username;
      this.checkIn = checkIn;
      this.checkOut = checkOut;
      this.roomInfo = room;
<<<<<<< HEAD
      this.discountCode = discount;
      this.priceBreakdownList = new ArrayList<String>();

      if(room instanceof Deluxe){
        this.totalPrice = ((Deluxe) room).getPrice()*(checkOut - checkIn);
      }
      else if(room instanceof Executive){
        this.totalPrice = ((Executive) room).getPrice()*(checkOut - checkIn);
      }
      else{
        this.totalPrice = room.getPrice()*(checkOut - checkIn);
      }
=======
      this.totalPrice = 0.0;
      this.priceBreakdownList = new ArrayList<String>();
>>>>>>> 6d803e1fea80dcba90f5553810e0c4bbb1de5261
    }

    /**
    * This method gets the guest name of a Reservation
    * @return name of the guest
    */
    public String getGuestName(){
      return this.guestName;
    }

    /**
    * This method gets the check in day of a Reservation as an integer
    * @return check in day represented as an integer
    */
    public int getCheckIn(){
      return this.checkIn;
    }

    /**
    * This method gets the check out day of a Reservation as an integer
    * @return check out day represented as an integer
    */
    public int getCheckOut(){
      return this.checkOut;
    }

    /**
    * This method gets a Room object where the reservation takes place
    * @return a Room object of a Reservation
    */
    public Room getRoom(){
      return this.roomInfo;
    }

    /**
    * This method gets the total price of a Reservation
    * @return the total price of a Reservation
    */
    public double getTotalPrice(){
      return this.totalPrice;
    }

    public ArrayList<String> getPriceBreakdown(){
      return this.priceBreakdownList;
    }

<<<<<<< HEAD
    public String getDiscountCode(){
      return this.discountCode;
    }

    public void setTotalPrice(Double price){
      this.totalPrice = price;
=======
    public void setTotalPrice(double Price){
      this.totalPrice = Price;
>>>>>>> 6d803e1fea80dcba90f5553810e0c4bbb1de5261
    }

    public void addPriceBreakdown(String text){
      this.priceBreakdownList.add(text);
    }
  }
