import java.util.*;

public class BookRoomModel {
    private Hotel chosenHotel;
    private Room chosenRoom;

    public BookRoomModel(Hotel hotel){
        this.chosenHotel = hotel;
    }

    public Hotel getHotel(){
        return chosenHotel;
    }

    public Room getRoom(){
        return chosenRoom;
    }

    public boolean availableRooms(Hotel hotel){
        Iterator<Room> roomList = hotel.getRooms().iterator();
        int countDay = 0;
        int countRoom = 0;
        while(roomList.hasNext()){
            Room room = roomList.next();
            ArrayList<Boolean> available = room.getAvailability(); 
            Iterator<Boolean> availList = available.iterator();
            while(availList.hasNext()){
                if(availList.next() == false){
                    countDay++;
                }
            }
            if(countDay == available.size()){
                countRoom++;
            } 
        }

        if(countRoom == 0){
            return true;
        }
        else{
            return false;
        }
        
    }

    public boolean checkAvailability(Room room){
        int count = 0;
        Iterator<Boolean> availableList = room.getAvailability().iterator();

        while(availableList.hasNext()){
            if(availableList.next() == false){
                count++;
            }
        }

        if(count == 31){
            return false;
        }
        else{
            return true;
        }
    }

    public int findRoom(Hotel hotel, String roomName){
        Iterator<Room> roomList = hotel.getRooms().iterator();
        int i = 0;

        while(roomList.hasNext()){
            Room roomNext = roomList.next();
            if(roomNext.getName().equals(roomName)){
                this.chosenRoom = roomNext;
                return i;
            }
            i++;
        }

        return -1;
    }

    public int addReservation(Reservation reservation, Room room){
        ArrayList<Boolean> roomAvailable = room.getAvailability();

        ArrayList<Integer> dayList = chosenHotel.getMarkedDayList();
        ArrayList<Double> percenList = chosenHotel.getMarkedPriceList();
        Iterator<Integer> dayIterator = dayList.iterator();

        int in = reservation.getCheckIn();
        int out = reservation.getCheckOut();

        int count = 0;
        double totalPrice = 0.0;

        if (in < 0 || out > 31 || in >= out || in == 32 || out == 0){
            return -1;
        }

        for(int i = in; i < out; i++){
            if(roomAvailable.get(i) == false){
                return 0;
            }
        }

        for(int i = in; i < out; i++){
            roomAvailable.set(i, false);
            while(dayIterator.hasNext()){
                if(dayIterator.next() == i){
                    totalPrice += percenList.get(count) * room.getPrice();
                    count++;
                }
            }
        }

        totalPrice += room.getPrice()*((out-in)-count);
        reservation.setTotalPrice(totalPrice);

        room.getReservations().add(reservation);

        return 1;
    }
}   
