import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class BookRoomView extends JFrame{
    private JDialog popUp;
    private JButton selectRoomBtn, bookBtn, returnMenuBtn;
    private JTextField selectRoomTf, nameTf, inTf, outTf, typeTf;
    private Hotel hotel;

    public BookRoomView(Hotel hotel) {
        super("Booking a room in " + hotel.getName());
        this.hotel = hotel;
        this.bookBtn = new JButton("Book");
        setLayout(new BorderLayout());
        setSize(575, 400);

        initialize();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initialize(){
        JPanel roomPanel = new JPanel();
        JTextArea roomList = new JTextArea(10, 40);
        roomList.setEditable(false);
        roomList.setFocusable(false);

        Iterator<Room> hotelRooms = hotel.getRooms().iterator();
        int count = 0;
        roomList.setText("");

        while(hotelRooms.hasNext()){
        count++;
        Room room = hotelRooms.next();
        roomList.append(String.format("%-15s", room.getName()));
            if(count % 7 == 0){
                roomList.append("\n");
            }else if(count < 10){
                roomList.append(" ");
            }
        }

        roomPanel.add(roomList, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        JLabel label = new JLabel("Select a room to book: ");
        selectRoomTf = new JTextField();
        selectRoomTf.setColumns(8);
        selectRoomBtn = new JButton("Select");
        selectRoomBtn.setPreferredSize(new Dimension(150, 30));
        returnMenuBtn = new JButton("Return to Main Menu");
        selectRoomBtn.setPreferredSize(new Dimension(150, 30));
        inputPanel.add(label, BorderLayout.CENTER);
        inputPanel.add(selectRoomTf, BorderLayout.CENTER);
        inputPanel.add(selectRoomBtn, BorderLayout.CENTER);
        inputPanel.add(returnMenuBtn, BorderLayout.CENTER);

        roomPanel.add(inputPanel, BorderLayout.SOUTH);

        this.add(roomPanel, BorderLayout.CENTER);
    }

    public void displayResInput(){
        popUp = new JDialog(this, "Booking Room", true);
        popUp.setLayout(new BorderLayout());
        popUp.setSize(400, 200);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel label = new JLabel("Please input the necessary details: ");
        JLabel label2 = new JLabel("Name: ");
        JLabel label3 = new JLabel("Room Type: ");
        JLabel label4 = new JLabel("Check-In Date: ");
        JLabel label5 = new JLabel("Check-Out Date: ");
        nameTf = new JTextField(10);
        typeTf = new JTextField(10);
        inTf = new JTextField(2);
        outTf = new JTextField(2);
        bookBtn.setPreferredSize(new Dimension(100, 30));

        inputPanel.add(label2);
        inputPanel.add(nameTf);
        inputPanel.add(label3);
        inputPanel.add(typeTf);
        inputPanel.add(label4);
        inputPanel.add(inTf);
        inputPanel.add(label5);
        inputPanel.add(outTf);
        inputPanel.add(new JLabel());
        inputPanel.add(bookBtn);

        popUp.add(label, BorderLayout.NORTH);
        popUp.add(inputPanel, BorderLayout.CENTER);
        popUp.setVisible(true);
        popUp.setResizable(false);
        popUp.setLocationRelativeTo(this);
        popUp.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    public void setSelectRoomBtnListener(ActionListener actionListener){
        selectRoomBtn.addActionListener(actionListener);
    }

    public void setBookBtnListener(ActionListener actionListener){
        bookBtn.addActionListener(actionListener);
    }

    public void setReturnMenuBtnListener(ActionListener actionListener){
        returnMenuBtn.addActionListener(actionListener);
    }

    public String getSelectRoomTf(){
        return selectRoomTf.getText();
    }

    public String getNameTf(){
        return nameTf.getText();
    }

    /*public String typeTf(){
        return typeTf.getText();
    }*/

    public String getInTf(){
        return inTf.getText();
    }

    public String getOutTf(){
        return outTf.getText();
    }

    public void closePopUpFrame(){
        popUp.dispose();
      }
} 
