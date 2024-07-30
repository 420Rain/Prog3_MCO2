import java.awt.event.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ViewHotelController {
    
    private ViewHotelModel vhModel;
    private ViewHotelView vhView;

    public ViewHotelController(ViewHotelModel vhModel, ViewHotelView vhView) {
        this.vhModel = vhModel;
        this.vhView = vhView;

        this.vhView.setRoomAvailBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("availView");
            }
        });

        this.vhView.setRoomDetailBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Hotel hotel = vhModel.getHotel();
                Iterator<Room> hotelRooms = hotel.getRooms().iterator();
                JTextArea textArea = vhView.getDisplayRoomsTA();
                int count = 0;
                textArea.setText("");

                while(hotelRooms.hasNext()){
                    count++;
                    Room room = hotelRooms.next();
                    textArea.append(String.format("%-15s", room.getName()));
                    if(count % 7 == 0){
                        textArea.append("\n");
                    }else if(count < 10){
                        textArea.append(" ");
                    }
                }

                vhView.showView("selectRoomView");
            }
        });

        this.vhView.setReservationsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("selectReservationView");
            }
        });

        this.vhView.setBackBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.dispose();
            }
        });

        this.vhView.setSelectDayBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int day = Integer.parseInt(vhView.getAvailTfText());
                Iterator<Room> availableRooms = vhModel.getAvailableRooms(day).iterator();

                JTextArea textArea = vhView.getAvailabilityTA();
                int count = 0;
                textArea.setText("");
                
                while(availableRooms.hasNext()){
                    count++;
                    Room room = availableRooms.next();
                    textArea.append(String.format("%-15s", room.getName()));
                    if(count % 7 == 0){
                        textArea.append("\n");
                    }else if(count < 10){
                        textArea.append(" ");
                    }
                }
                
                textArea.revalidate();
                textArea.repaint();
            }
        });

        /*this.vhView.setSelectRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Room room = vhModel.findRoom(vhModel.getHotel().getRooms(), vhView.getRoomTfText());
                ArrayList<JLabel> labelList = vhView.getLabelList();
                ArrayList<Boolean> availableList = room.getAvailability();
        
                JLabel name = vhView.getRPlaceHolder();
                JLabel price = vhView.getPPlaceHolder();
                //JLabel type = vhView.getTPlaceholder();
        
                name.setText(room.getName());
                price.setText(String.valueOf(room.getPrice()));
                //type.setText(room.getType());
        
                labelList.clear();
        
                for(int i = 0; i < availableList.size(); i++){
                    JLabel label = new JLabel("" + (i + 1), SwingConstants.CENTER);
                    if(availableList.get(i)){
                        vhView.setGreen(label);
                    } else {
                        vhView.setRed(label);
                    }
                    label.setPreferredSize(new Dimension(50, 50));
                    labelList.add(label);
                }
        
                vhView.showView("displayRoomView");
            }
        });*/

        this.vhView.setSelectRoomBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Room room = vhModel.findRoom(vhModel.getHotel().getRooms(), vhView.getRoomTfText());
                ArrayList<JLabel> labelList = vhView.getLabelList();
                ArrayList<Boolean> availableList = room.getAvailability();
        
                JLabel name = vhView.getRPlaceHolder();
                JLabel price = vhView.getPPlaceHolder();
                //JLabel type = vhView.getTPlaceholder();
        
                name.setText(room.getName());
                price.setText(String.valueOf(room.getPrice()));
                //type.setText(room.getType());
        
                labelList.clear();
        
                for(int i = 0; i < availableList.size(); i++){
                    JLabel label = new JLabel("" + (i + 1), SwingConstants.CENTER);
                    if(availableList.get(i)){
                        vhView.setGreen(label);
                    } else {
                        vhView.setRed(label);
                    }
                    label.setPreferredSize(new Dimension(50, 50));
                    labelList.add(label);
                }
        
                // Ensure the panel updates with new labels
                JPanel daysPanel = vhView.getDaysPanel();
                daysPanel.removeAll();
                for (JLabel label : labelList) {
                    daysPanel.add(label);
                }
                daysPanel.revalidate();
                daysPanel.repaint();
                
                vhView.showView("displayRoomView");
            }
        });

        this.vhView.setSelectGuestBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String guestName = vhView.getGuestTfText();
                Integer roomIndex[] = {-1};
                Integer resIndex[] = {-1};

                if(vhModel.findGuestRes(guestName, roomIndex, resIndex)){
                    Reservation reservation = vhModel.getHotel().getRooms().get(roomIndex[0]).getReservations().get(resIndex[0]);
                    vhView.getNPlaceHolder().setText(reservation.getGuestName());
                    vhView.getResPlaceHolder().setText(reservation.getRoom().getName());
                    vhView.getIPlaceHolder().setText("Day " + reservation.getCheckIn());
                    vhView.getOPlaceHolder().setText("Day " + reservation.getCheckOut());
                    vhView.getTpPlaceHolder().setText("Php " + reservation.getTotalPrice());

                    vhView.showView("displayReservationView");
                }
            }
        });

        this.vhView.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("mainView");
            }
        });

        this.vhView.setReturnBtn2Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("mainView");
            }
        });

        this.vhView.setReturnBtn3Listener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("mainView");
            }
        });

        this.vhView.setReturnSelectBtn(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                vhView.showView("selectRoomView");
            }
        });

        /*this.vhView.setReturnSelectBtn2(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                vhView.showView("selectReservationView");
            }
        });*/
    }
}