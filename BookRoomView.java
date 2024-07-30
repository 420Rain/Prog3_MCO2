import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class BookRoomView extends JFrame{
    private JDialog popUp;
    private JButton selectRoomBtn, bookBtn, returnMenuBtn;
    private JTextField selectRoomTf, nameTf, inTf, outTf, discountTf;
    private Hotel hotel;

    public BookRoomView(Hotel hotel) {
        super("Booking a room in " + hotel.getName());
        this.hotel = hotel;
        this.bookBtn = new JButton("Book");
        setLayout(new BorderLayout());
        setSize(550, 420);

        initialize();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initialize(){
        //Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 0);
        gbc.gridx = 0;
        gbc.gridy = 0;

        JLabel stdLbl = new JLabel("Standard Rooms:");
        JTextArea stdRooms = new JTextArea(4, 40);
        stdRooms.setEditable(false);
        stdRooms.setFocusable(false);

        JLabel dlxLbl = new JLabel("Deluxe Rooms:");
        JTextArea dlxRooms = new JTextArea(4, 40);
        dlxRooms.setEditable(false);
        dlxRooms.setFocusable(false);

        JLabel excLbl = new JLabel("Executive Rooms:");
        JTextArea excRooms = new JTextArea(4, 40);
        excRooms.setEditable(false);
        excRooms.setFocusable(false);

        Iterator<Room> hotelRooms = hotel.getRooms().iterator();
        int count = 0;
        stdRooms.setText("");
        dlxRooms.setText("");
        excRooms.setText("");

        while(hotelRooms.hasNext()){
            count++;
            Room room = hotelRooms.next();
            if(room instanceof Deluxe){
                dlxRooms.append(String.format("%-15s", room.getName()));
            }
            else if(room instanceof Executive){
                excRooms.append(String.format("%-15s", room.getName()));
            }
            else{
                stdRooms.append(String.format("%-15s", room.getName()));
            }
                        
            if(count % 7 == 0){
                stdRooms.append("\n");
                dlxRooms.append("\n");
                excRooms.append("\n");
            }else if(count < 10){
                stdRooms.append(" ");
                dlxRooms.append(" ");
                excRooms.append(" ");
            }
        }

        centerPanel.add(stdLbl, gbc);
        
        gbc.gridy++;
        centerPanel.add(stdRooms, gbc);

        gbc.gridy++;
        centerPanel.add(dlxLbl, gbc);

        gbc.gridy++;
        centerPanel.add(dlxRooms, gbc);

        gbc.gridy++;
        centerPanel.add(excLbl, gbc);

        gbc.gridy++;
        centerPanel.add(excRooms, gbc);

        this.add(centerPanel, BorderLayout.NORTH);

        //South Panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(0, 5, 0, 5);
        gbc2.gridx = 0;
        gbc2.gridy = 0;

        JLabel selectLbl = new JLabel("Select a Room to Book");
        southPanel.add(selectLbl, gbc2);

        gbc2.gridx++;
        selectRoomTf = new JTextField();
        selectRoomTf.setColumns(8);
        southPanel.add(selectRoomTf, gbc2);

        gbc2.gridx++;
        selectRoomBtn = new JButton("Select");
        selectRoomBtn.setPreferredSize(new Dimension(100, 30));
        southPanel.add(selectRoomBtn, gbc2);

        gbc2.gridx++;
        returnMenuBtn = new JButton("Return to Main Menu");
        returnMenuBtn.setPreferredSize(new Dimension(160, 30));
        southPanel.add(returnMenuBtn, gbc2);

        this.add(southPanel, BorderLayout.CENTER);

    }

    public void displayResInput(){
        popUp = new JDialog(this, "Booking Room", true);
        popUp.setLayout(new BorderLayout());
        popUp.setSize(400, 200);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        JLabel label = new JLabel("Please input the necessary details: ");
        JLabel label2 = new JLabel("Name: ");
        //JLabel label3 = new JLabel("Room Type: ");
        JLabel label4 = new JLabel("Check-In Date: ");
        JLabel label5 = new JLabel("Check-Out Date: ");
        JLabel label6 = new JLabel("Discount Code (optional): ");

        nameTf = new JTextField(10);
        //typeTf = new JTextField(10);
        inTf = new JTextField(2);
        outTf = new JTextField(2);
        discountTf = new JTextField(10);
        bookBtn.setPreferredSize(new Dimension(100, 30));

        inputPanel.add(label2);
        inputPanel.add(nameTf);

        //inputPanel.add(label3);
        //inputPanel.add(typeTf);

        inputPanel.add(label4);
        inputPanel.add(inTf);

        inputPanel.add(label5);
        inputPanel.add(outTf);

        inputPanel.add(label6);
        inputPanel.add(discountTf);
        inputPanel.add(new JLabel());
        inputPanel.add(bookBtn);

        popUp.setLocationRelativeTo(null);
        popUp.add(label, BorderLayout.NORTH);
        popUp.add(inputPanel, BorderLayout.CENTER);
        popUp.setVisible(true);
        popUp.setResizable(false);
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

    public String getDiscountTf(){
        return discountTf.getText();
    }

    public void closePopUpFrame(){
        popUp.dispose();
      }
} 
