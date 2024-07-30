import java.util.ArrayList;

public class Executive extends Room{

    private double priceExecutive;

    public Executive(String name, double price) {
        super(name, price);
        this.priceExecutive = price * 1.35;
    }

    @Override
    public void setPrice(double price){
        this.priceExecutive = price * 1.35;
    }

    @Override
    public double getPrice(){
        return this.priceExecutive;
    }

    @Override
    public ArrayList<Reservation> getReservations(){
        return super.getReservations();
    }
}