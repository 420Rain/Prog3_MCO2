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
                
            }
        });

        this.vhView.setReservationsBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
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
                
                // Clear the text area
                textArea.setText("");
                
                // Append new content
                while(availableRooms.hasNext()){
                    textArea.append(availableRooms.next().getName() + "\n");
                }
    
                // Force the UI to update
                textArea.revalidate();
                textArea.repaint();
            }
        });

        this.vhView.setReturnBtnListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vhView.showView("mainView");
            }
        });
    }
}