import java.util.ArrayList;

public class Deluxe extends Room{

    private double priceDeluxe;

    public Deluxe(String name, double price) {
        super(name, price);
        this.priceDeluxe = price * 1.2;
    }

    @Override
    public void setPrice(double price){
        this.priceDeluxe = price * 1.2;
    }

    @Override
    public double getPrice(){
        return this.priceDeluxe;
    }

    @Override
    public ArrayList<Reservation> getReservations(){
        return super.getReservations();
    }
}