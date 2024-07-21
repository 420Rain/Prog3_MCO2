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

        this.hrsView.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
