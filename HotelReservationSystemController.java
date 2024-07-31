package HRS;

import java.util.*;

import javax.swing.JOptionPane;

import java.awt.event.*;

/**
* This class is the controller for the HotelReservationSystem which transfers data from the model
* to the view
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class HotelReservationSystemController{
    /**
     * This variable is the HotelReservationView
     */
    private HotelReservationSystemView hrsView;
    /**
     * This variable is the HotelReservationModel
     */
	private HotelReservationSystemModel hrsModel;

    /**
     * Creates an instance of HotelReservationSystemController
     * @param hrsView view of HotelReservationSystem
     * @param hrsModel model of HotelReservationSystem
     */
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
                
                int result = hrsModel.createHotel(hotelName, numRooms);

                if(result == 1){
					hrsView.clearTextFields();
                    hrsView.closeCreateHFrame();
				} 
                else if(result == -1){
					hrsView.setFeedbackLblText("Hotel Not Created. That Hotel Name Already Exists");
                    hrsView.clearTextFields();
				}
                else{
                    hrsView.setFeedbackLblText("Hotel Not Created. Number of Rooms Must be Between 1 and 50");
                    hrsView.clearTextFields();
                }
            }
        });

        this.hrsView.setViewHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if(!hrsModel.getHotelList().isEmpty()){
                    hrsView.clearHotelButtons();
                    Iterator<Hotel> hotels = hrsModel.getHotelList().iterator();
                    
                    while(hotels.hasNext()){
                        Hotel hotel = hotels.next();
                        ActionListener actionListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                    ViewHotelModel vhModel = new ViewHotelModel(hotel);
                                    ViewHotelView vhView = new ViewHotelView(hotel);
        
                                    ViewHotelController vhController = new ViewHotelController(vhModel, vhView);
                            }              
                        };
                        hrsView.setButtonList(hotel.getName(), actionListener);
                    }
                    hrsView.selectHotel(0);
                }
                else{
                    hrsView.noHotelDisplay();
                }
				
            }
        });

        this.hrsView.setOkayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsView.closeNoHFrame();
            }
        });

        this.hrsView.setManageHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hrsModel.getHotelList().isEmpty()) {
                    hrsView.clearHotelButtons();
                    for (Hotel hotel : hrsModel.getHotelList()) {
                        hrsView.setButtonList(hotel.getName(), new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ManageHotelModel manageHotelModel = new ManageHotelModel(hrsModel.getHotelList());
                                ManageHotelView manageHotelView = new ManageHotelView();
                                ManageHotelController manageHotelController = new ManageHotelController(manageHotelModel, manageHotelView, hotel);
                                hrsView.closeSelectHFrame();
                            }
                        });
                    }
                    hrsView.selectHotel(1);
                } else {
                    hrsView.noHotelDisplay();
                }
            }
        });

        this.hrsView.setBookRoomListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                if(!hrsModel.getHotelList().isEmpty()){
                    hrsView.clearHotelButtons();
                    Iterator<Hotel> hotels = hrsModel.getHotelList().iterator();
                    
                    while(hotels.hasNext()){
                        Hotel hotel = hotels.next();
                        ActionListener actionListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                    BookRoomModel bookRoomModel = new BookRoomModel(hotel);
                                    BookRoomView bookRoomView = new BookRoomView(hotel);
                                    if(bookRoomModel.availableRooms(hotel)){
                                        BookRoomController bookRoomController = new BookRoomController(bookRoomModel, bookRoomView);
                                        hrsView.closeSelectHFrame();
                                    }
                                    else{
                                        JOptionPane.showMessageDialog(null, "No Rooms Available in this Hotel !", "Error", JOptionPane.ERROR_MESSAGE);
                                    }
                            }              
                        };
                        hrsView.setButtonList(hotel.getName(), actionListener);
                    }
                    hrsView.selectHotel(2);
                }
                else{
                    hrsView.noHotelDisplay();
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
