public class DriverTemp {
    public static void main(String[] args){
        //instantiates a view and model to be used in the controller for the reservation system
        HotelReservationSystemView view = new HotelReservationSystemView();
        HotelReservationSystemModel model = new HotelReservationSystemModel();

        HotelReservationSystemController controller = new HotelReservationSystemController(view, model);
    }
}
