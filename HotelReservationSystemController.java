import java.util.*;
import java.awt.event.*;

public class HotelReservationSystemController{
    private HotelReservationSystemView hrsView;
	private HotelReservationSystemModel hrsModel;

    public HotelReservationSystemController(HotelReservationSystemView hrsView, HotelReservationSystemModel hrsModel) {
        this.hrsView = hrsView;
        this.hrsModel = hrsModel;

        this.hrsView.setCreateHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsView.createHotelDisplay();
            }
        });

        this.hrsView.setCreateBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String hotelName = hrsView.getHotelNameTfText();
				int numRooms = Integer.parseInt(hrsView.getNumRoomTfText());
                
                boolean result = hrsModel.createHotel(hotelName, numRooms);

                if(result) {
					hrsView.setFeedbackLblText("Hotel Created Succesfully !");
					hrsView.clearTextFields();
				} else {
					hrsView.setFeedbackLblText("Hotel was not created");
				}
            }
        });

        this.hrsView.setViewHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String displayText = "";

                if(!hrsModel.getHotelList().isEmpty()){
                    hrsView.clearHotelButtons();
                    Iterator<Hotel> hotels = hrsModel.getHotelList().iterator();
                    
                    while(hotels.hasNext()){
                        Hotel hotel = hotels.next();
                        ActionListener actionListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                ViewHotelView viewHotelView = new ViewHotelView(hotel);
                            }
                        };
                        hrsView.setButtonList(hotel.getName(), actionListener);
                    }
                    hrsView.viewHotelDisplay();
                }
                else{
                    displayText += "No Hotels listed yet !";
                    hrsView.noHotelDisplay();
                }
				
            }
        });

        this.hrsView.setOkayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsView.closeWindow(hrsView.getFrameList().get(1));
            }
        });

        this.hrsView.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
