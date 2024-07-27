import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageHotelController{
    private ManageHotelModel MHmodel;
    private ManageHotelView MHview;
    private Hotel hotel;

    public ManageHotelController(ManageHotelModel model, ManageHotelView view, Hotel hotel){
        this.MHmodel = model;
        this.MHview = view;
        this.hotel = hotel;

        this.MHview.setChangeNameBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.changeNameDisplay(hotel);
            }
        });

        this.MHview.setNameBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = MHview.getInputTf();

                if(MHmodel.changeName(hotel, name)){
                    MHview.setNameLblText(name);
                    MHview.closeNameFrame();
                }
                else{
                    MHview.setFeedbackLblText("That Hotel Name Already Exists");
                }
            }
        });

        this.MHview.setAddRoomBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(MHmodel.addRoom(hotel) == true){
                    MHview.setLogLblText("Room Added Successfully");
                }
                else{
                    MHview.setLogLblText("Cannot Add Room. Max Number of Rooms Reached");
                }
            }
        });

        this.MHview.setRemoveRoomBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                if(hotel.getNumRooms() > 1){
                    MHview.clearHotelButtons();
                    for(Room room: hotel.getRooms()){
                        String roomName = room.getName();
                        MHview.setButtonList(roomName, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(MHmodel.removeRoom(hotel, roomName)){
                                    MHview.closeRoomFrame();
                                    MHview.setLogLblText("Room Successfully Removed");
                                }
                                else{
                                    MHview.setFeedbackLblText("Cannot Remove. Selected Room Has Reservation/s");
                                }
                            }
                        });
                    }
                    MHview.roomsDisplay(0);
                }
                else{
                    MHview.setLogLblText("Cannot Remove a Room. Hotel Only Has One Room");
                }    
            }
        });

        this.MHview.setUpdPriceBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.updPriceDisplay(hotel);
            }
        });

        this.MHview.setPriceBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                try {
                    double price = Double.parseDouble(MHview.getInputTf());

                    if (price >= 100.0) {
                        if (MHmodel.updatePrice(hotel, price)) {
                            MHview.setLogLblText("Successfully Changed the Room Prices");
                            MHview.clearTextFields();
                            MHview.closeUpdPriceFrame();
                        } else {
                            MHview.setFeedbackLblText("Could Not Change Price. Some Rooms Have Reservations");
                            MHview.clearTextFields();
                        }
                    } else {
                        MHview.setFeedbackLblText("Could Not Change Price. Rooms Must Cost at Least 100");
                        MHview.clearTextFields();
                    }
                } catch (NumberFormatException ex) {
                    MHview.setFeedbackLblText("Invalid Price. Please Enter a Valid Number");
                }  
            }
        });

        /*this.MHview.setRemoveRsvBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.clearHotelButtons();
                    for(Room room: hotel.getRooms()){
                        MHview.setButtonList(room.getName(), new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e){
                                if(room.getReservations().isEmpty()){
                                    MHview.closeRoomFrame();
                                    MHview.removeRsvDisplay(room);
                                    removeOneRsv(room);
                                    removeAllRsv(room);
                                }
                                else{
                                    MHview.setFeedbackLblText("Selected Room Has No Reservations");
                                }
                            }
                        });
                    }
                MHview.roomsDisplay(1);
            }
        });*/

        /*this.MHview.setRemoveRsvBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.clearHotelButtons();
                for(Room room: hotel.getRooms()){
                    MHview.setButtonList(room.getName(), new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e){
                            if(room.getReservations().isEmpty()){
                                MHview.closeRoomFrame();
                                MHview.removeRsvDisplay(room);
                                MHview.setRemoveOneBtn(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        MHview.findGuestDisplay();
                                        MHview.closeRemoveRsvFrame();
                                        MHview.setGuestBtn(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e){
                                                String name = MHview.getInputTf();
                                                int reservationIndex = -1;
                                                
                                                for(int i = 0; i < room.getReservations().size(); i++){
                                                    if(name.equals(room.getReservations().get(i).getGuestName())){
                                                        reservationIndex = i;
                                                        break;
                                                    }
                                                }
                        
                                                if(reservationIndex > -1){
                                                    MHmodel.removeReservation(room, room.getReservations().get(reservationIndex));
                                                    MHview.setLogLblText("Successfully Removed " + name + "'s Reservation");
                                                    MHview.closeGuestFrame();
                                                }
                                                else{
                                                    MHview.setFeedbackLblText("Guest Name Not Found");
                                                }
                                            }
                                        });
                                    }
                                });
                                MHview.setRemoveAllBtn(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e){
                                        for(int i = 0; i < room.getReservations().size(); i++){
                                            MHmodel.removeReservation(room, room.getReservations().get(i));
                                        }
                                        MHview.closeRemoveRsvFrame();
                                        MHview.setLogLblText("Removed All Reservations in " + room.getName());
                                    }
                                });

                            }
                            else{
                                MHview.setFeedbackLblText("Selected Room Has No Reservations");
                            }
                        }
                    });
                }
                MHview.roomsDisplay(1);
            }
        });*/

        this.MHview.setRemoveRsvBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MHview.clearHotelButtons();
                MHview.setLogLblText("");
                for (Room room : hotel.getRooms()) {
                    MHview.setButtonList(room.getName(), new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (room.getReservations().isEmpty()) {
                                MHview.closeRoomFrame();
                                MHview.removeRsvDisplay(room);
                                RoomReservationManager reservationManager = new RoomReservationManager(MHmodel, MHview, room);
                                reservationManager.removeOneRsv();
                                reservationManager.removeAllRsv();
                            } else {
                                MHview.setFeedbackLblText("Selected Room Has No Reservations");
                            }
                        }
                    });
                }
                MHview.roomsDisplay(1);
            }
        });

        this.MHview.setRemoveHotelBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHmodel.removeHotel(hotel);
                MHview.closeManageHFrame();
            }
        });

        this.MHview.setBackBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.closeManageHFrame();
            }
        });

        this.MHview.manageHotelDisplay(hotel);
    }

    //TODO: maybe put these two functions in the removeRsvBtn
    /*public void removeOneRsv(Room room){
        this.MHview.setRemoveOneBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                MHview.findGuestDisplay();
                MHview.closeRemoveRsvFrame();
                removeGuestRsv(room);
            }
        });
    }

    public void removeGuestRsv(Room room){
        this.MHview.setGuestBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String name = MHview.getInputTf();
                int reservationIndex = -1;
                
                for(int i = 0; i < room.getReservations().size(); i++){
                    if(name.equals(room.getReservations().get(i).getGuestName())){
                        reservationIndex = i;
                        break;
                    }
                }

                if(reservationIndex > -1){
                    MHmodel.removeReservation(room, room.getReservations().get(reservationIndex));
                    MHview.setLogLblText("Successfully Removed " + name + "'s Reservation");
                    MHview.closeGuestFrame();
                }
                else{
                    MHview.setFeedbackLblText("Guest Name Not Found");
                }
            }
        });
    }

    public void removeAllRsv(Room room){
        this.MHview.setRemoveAllBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                for(int i = 0; i < room.getReservations().size(); i++){
                    MHmodel.removeReservation(room, room.getReservations().get(i));
                }
                MHview.closeRemoveRsvFrame();
                MHview.setLogLblText("Removed All Reservations in " + room.getName());
            }
        });
    }*/

}