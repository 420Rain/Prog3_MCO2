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
                
                int result = hrsModel.createHotel(hotelName, numRooms);

                if(result == 1){
					//hrsView.setFeedbackLblText("Hotel Created Succesfully !");
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

        /*this.hrsView.setManageHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<Hotel> hotelList = hrsModel.getHotelList();
                String displayText = "";

                if(!hrsModel.getHotelList().isEmpty()){
                    hrsView.clearHotelButtons();
                    Iterator<Hotel> hotels = hrsModel.getHotelList().iterator();

                    while(hotels.hasNext()){
                        Hotel hotel = hotels.next();
                        ActionListener actionListener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                hrsView.manageHotelDisplay(hotel);
                                hrsView.closeSelectHFrame();
                                //ViewHotelView viewHotelView = new ViewHotelView(hotel);
                            }
                        };
                        hrsView.setButtonList(hotel.getName(), actionListener);
                        addRoom(hotel);
                        removeHotel(hotel);
                    }
                    
                    hrsView.selectHotel(1);
                }
                else{
                    displayText += "No Hotels listed yet !";
                    hrsView.noHotelDisplay();
                }
            }
        });

        this.hrsView.setManageHotelBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hrsModel.getHotelList().isEmpty()) {
                    refreshHotelList(); // Refresh the hotel list for managing hotels
                    hrsView.selectHotel(1);
                } else {
                    hrsView.noHotelDisplay();
                }
            }
        });*/

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

        /*this.hrsView.setBackBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                hrsView.closeManageHFrame();
            }
        });*/
        
        this.hrsView.setExitBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    /*public void addRoom(Hotel hotel){
        this.hrsView.setAddRoomBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i < hrsModel.getHotelList().size(); i++){
                    if(hrsModel.getHotelList().get(i).getName().equals(hotel.getName())){
                        boolean result = hrsModel.getHotelList().get(i).addRoom();

                        if(result == true){
                            hrsView.setFeedbackLblText("Room Added Successfully");
                        }
                        else{
                            hrsView.setFeedbackLblText("Cannot Add Room. Max Number of Rooms Reached");
                        }
                    }
                }
                
            }
        });
    }*/

    /*public void addRoom(Hotel hotel) {
        ActionListener addRoomListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (Hotel h : hrsModel.getHotelList()) {
                    if (h.getName().equals(hotel.getName())) {
                        boolean result = h.addRoom();

                        if (result) {
                            hrsView.setFeedbackLblText("Room Added Successfully");
                        } else {
                            hrsView.setFeedbackLblText("Cannot Add Room. Max Number of Rooms Reached");
                        }
                    }
                }
            }
        };
        hrsView.setAddRoomBtn(addRoomListener);
    }*/

    /*public void removeHotel(Hotel hotel){
        this.hrsView.setRemoveHotelBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                hrsModel.getHotelList().remove(hotel);
                hrsView.closeManageHFrame();
                //update hotel list in mainframe (right panel)
            }
        });
    }*/

    /*public void removeHotel(Hotel hotel) {
        ActionListener removeHotelListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hrsModel.getHotelList().remove(hotel);
                hrsView.closeManageHFrame();
                refreshHotelList(); // Update hotel list in mainframe (right panel)
            }
        };
        hrsView.setRemoveHotelBtn(removeHotelListener);
    }

    private void refreshHotelList() {
        hrsView.clearHotelButtons(); // Clear existing buttons in the view

        for (Hotel hotel : hrsModel.getHotelList()) {
            hrsView.setButtonList(hotel.getName(), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    hrsView.manageHotelDisplay(hotel); // Display hotel management interface
                    hrsView.closeSelectHFrame();

                    clearAddRoomListeners();
                    clearRemoveHotelListeners();

                    addRoom(hotel); // Set up add room functionality
                    removeHotel(hotel); // Set up remove hotel functionality
                }
            });
        }
    }

    // Method to clear existing add room listeners
    private void clearAddRoomListeners() {
        for (ActionListener al : hrsView.getAddRoomBtn().getActionListeners()) {
            hrsView.getAddRoomBtn().removeActionListener(al);
        }
    }

    // Method to clear existing remove hotel listeners
    private void clearRemoveHotelListeners() {
        for (ActionListener al : hrsView.getRemoveHotelBtn().getActionListeners()) {
            hrsView.getRemoveHotelBtn().removeActionListener(al);
        }
    }*/

}
