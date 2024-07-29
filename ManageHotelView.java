import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;

import java.util.*;

public class ManageHotelView extends JFrame{
    private JFrame updPriceFrame, nameFrame, roomFrame, removeRsvFrame, guestFrame, modFrame;
    private JPanel northPanel, centerPanel;
    private JLabel logLbl, nameLbl, promptLbl, promptLbl2, feedbackLbl;
    private JButton changeNameBtn, addRoomBtn, removeRoomBtn, updPriceBtn, dpModifyBtn, removeRsvBtn, removeHotelBtn, backBtn;
    private ArrayList<JButton> roomList = new ArrayList<JButton>();
    private JTextField inputTf;
    private JButton priceBtn, nameBtn, removeOneBtn, removeAllBtn, guestBtn, applyMdBtn;
    private JComboBox<Integer> daysCB;
    
    public ManageHotelView(){
        super("Manage Hotel");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(300,450);

        Dimension buttonDim = new Dimension(170, 30);

        this.changeNameBtn = new JButton("Change Hotel Name");
        this.changeNameBtn.setPreferredSize(buttonDim);

        this.nameBtn = new JButton("Change Name");
        this.nameBtn.setPreferredSize(new Dimension(120, 30));
  
        this.addRoomBtn = new JButton("Add a Room");
        this.addRoomBtn.setPreferredSize(buttonDim);
  
        this.removeRoomBtn = new JButton("Remove a Room");
        this.removeRoomBtn.setPreferredSize(buttonDim);
  
        this.updPriceBtn = new JButton("Update Room Prices");
        this.updPriceBtn.setPreferredSize(buttonDim);

        this.priceBtn = new JButton("Change Price");
        this.priceBtn.setPreferredSize(new Dimension(120, 30));

        this.dpModifyBtn = new JButton("Modify Date Pricing");
        this.dpModifyBtn.setPreferredSize(buttonDim);

        this.applyMdBtn = new JButton("Apply Modification");
        this.applyMdBtn.setPreferredSize(new Dimension(150, 30));

        this.removeRsvBtn = new JButton("Cancel A Reservation");
        this.removeRsvBtn.setPreferredSize(buttonDim);

        this.removeOneBtn = new JButton("Remove One");
        this.removeOneBtn.setPreferredSize(new Dimension(130, 30));

        this.removeAllBtn = new JButton("Remove All");
        this.removeAllBtn.setPreferredSize(new Dimension(130, 30));

        this.guestBtn = new JButton("Check Name");
        this.guestBtn.setPreferredSize(new Dimension(120, 30));
  
        this.removeHotelBtn = new JButton("Remove This Hotel");
        this.removeHotelBtn.setPreferredSize(buttonDim);

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(buttonDim);

    }

    public void manageHotelDisplay(Hotel hotel){
        //Top panel
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        nameLbl = new JLabel("~ " + hotel.getName() + " ~", SwingConstants.CENTER);
        nameLbl.setFont(new Font("Dialog", Font.BOLD, 18));
        nameLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        northPanel.add(nameLbl, BorderLayout.NORTH);

        promptLbl2 = new JLabel("What Would You Like to do With this Hotel?", SwingConstants.CENTER);
        northPanel.add(promptLbl2, BorderLayout.CENTER);

        this.add(northPanel, BorderLayout.NORTH);

        //Center Panel
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(10, 50, 5, 50);

        gbc.gridy++;
        centerPanel.add(changeNameBtn, gbc);

        gbc.gridy++;
        centerPanel.add(addRoomBtn, gbc);

        gbc.gridy++;
        centerPanel.add(removeRoomBtn, gbc);

        gbc.gridy++;
        centerPanel.add(updPriceBtn, gbc);

        gbc.gridy++;
        centerPanel.add(dpModifyBtn, gbc);

        gbc.gridy++;
        centerPanel.add(removeRsvBtn, gbc);

        gbc.gridy++;
        centerPanel.add(removeHotelBtn, gbc);

        gbc.gridy++;
        centerPanel.add(backBtn, gbc);

        this.add(centerPanel, BorderLayout.CENTER);

        logLbl = new JLabel("", SwingConstants.CENTER);
        logLbl.setFont(new Font("Dialog", Font.PLAIN, 12));
        logLbl.setBorder(new EmptyBorder(0,0, 10, 0));
        logLbl.setPreferredSize(new Dimension(200, 30));
      
        this.add(logLbl, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    public void changeNameDisplay(Hotel hotel){
        nameFrame = new JFrame("Change Hotel Name");
        nameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nameFrame.setLayout(new BorderLayout());
        nameFrame.setSize(new Dimension(380, 150));

        promptLbl = new JLabel("Enter a New Name for the Hotel", SwingConstants.CENTER);
        promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        nameFrame.add(promptLbl, BorderLayout.NORTH);

        feedbackLbl = new JLabel("Current Hotel Name: " + hotel.getName(), SwingConstants.CENTER);
        feedbackLbl.setFont(new Font("Dialog", Font.BOLD, 11));
        feedbackLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        nameFrame.add(feedbackLbl, BorderLayout.SOUTH);

        //Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        inputTf = new JTextField(19);

        gbc.gridx++;
        centerPanel.add(inputTf, gbc);

        gbc.gridx++;
        centerPanel.add(nameBtn, gbc);

        nameFrame.add(centerPanel, BorderLayout.CENTER);

        nameFrame.setLocationRelativeTo(null);
        nameFrame.setVisible(true);
        nameFrame.setResizable(false);
    }

    public void roomsDisplay(int index){
        roomFrame = new JFrame("Select Room");
        roomFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        roomFrame.setLayout(new BorderLayout());
        roomFrame.setSize(new Dimension(450, 400));

        if(index == 0){
            promptLbl = new JLabel("Select a Hotel Room to Remove", SwingConstants.CENTER);
        }
        else{
            promptLbl = new JLabel("Select a Hotel Room", SwingConstants.CENTER);
        }
        promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        roomFrame.add(promptLbl, BorderLayout.NORTH);

        feedbackLbl = new JLabel("", SwingConstants.CENTER);
        feedbackLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        feedbackLbl.setFont(new Font("Dialog", Font.BOLD, 12));
        roomFrame.add(feedbackLbl, BorderLayout.SOUTH);

        // Center panel with grid layout
        JPanel centerPanel = new JPanel();
        int rows = (int) Math.ceil(roomList.size() / 3.0);
        centerPanel.setLayout(new GridLayout(rows, 3, 10, 10));

        for (JButton hButton : roomList) {
            hButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            hButton.setPreferredSize(new Dimension(100, 50));
            centerPanel.add(hButton);
        }

        JScrollPane scrollPane = new JScrollPane(centerPanel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(6);
        scrollPane.getVerticalScrollBar().setBlockIncrement(40);
        roomFrame.add(scrollPane, BorderLayout.CENTER);

        // White space borders
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(20, 0));
        roomFrame.add(westPanel, BorderLayout.WEST);

        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(20, 0));
        roomFrame.add(eastPanel, BorderLayout.EAST);

        roomFrame.setLocationRelativeTo(null);
        roomFrame.setVisible(true);
        roomFrame.setResizable(false);
    }

    public void updPriceDisplay(Hotel hotel){
        updPriceFrame = new JFrame("Change Hotel Price");
        updPriceFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        updPriceFrame.setLayout(new BorderLayout());
        updPriceFrame.setSize(new Dimension(330, 150));

        promptLbl = new JLabel("Enter a New Price for the Hotel", SwingConstants.CENTER);
        promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        updPriceFrame.add(promptLbl, BorderLayout.NORTH);

        feedbackLbl = new JLabel("Current General Room Price: " + hotel.getPrice(), SwingConstants.CENTER);
        feedbackLbl.setFont(new Font("Dialog", Font.BOLD, 11));
        feedbackLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        updPriceFrame.add(feedbackLbl, BorderLayout.SOUTH);
        
        //Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        inputTf = new JTextField(12);

        gbc.gridx++;
        centerPanel.add(inputTf, gbc);

        gbc.gridx++;
        centerPanel.add(priceBtn, gbc);

        updPriceFrame.add(centerPanel, BorderLayout.CENTER);

        updPriceFrame.setLocationRelativeTo(null);
        updPriceFrame.setVisible(true);
        updPriceFrame.setResizable(false);
    }

    public void modifyDpDisplay(){
        modFrame = new JFrame("Date Price Modifier");
        modFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);    
        modFrame.setLayout(new BorderLayout());
        modFrame.setSize(new Dimension(500, 150));

        promptLbl = new JLabel("Select a day to place the modifier", SwingConstants.CENTER);
        promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        modFrame.add(promptLbl, BorderLayout.NORTH);

        daysCB = new JComboBox<Integer>();

        for(int i = 1; i < 32; i++){
            daysCB.addItem(i);
        }
        modFrame.add(daysCB, BorderLayout.CENTER);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        inputTf = new JTextField(3);

        gbc.gridx++;
        centerPanel.add(new JLabel("Place desired percentage: "), gbc);

        gbc.gridx++;
        centerPanel.add(inputTf, gbc);

        gbc.gridx++;
        centerPanel.add(new JLabel("%"), gbc);

        gbc.gridx++;
        centerPanel.add(applyMdBtn, gbc);

        modFrame.add(centerPanel, BorderLayout.SOUTH);

        modFrame.setLocationRelativeTo(null);
        modFrame.setVisible(true);
        modFrame.setResizable(false);
    }

    public void removeRsvDisplay(Room room){
        removeRsvFrame = new JFrame("Remove Room Reservation");
        removeRsvFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        removeRsvFrame.setLayout(new BorderLayout());
        removeRsvFrame.setSize(new Dimension(480, 140));

        promptLbl = new JLabel("Would You Like to Remove ONE Reservation or ALL Reservations For " + room.getName() + "?", SwingConstants.CENTER);
        promptLbl.setFont(new Font("Dialog", Font.BOLD, 11));
        promptLbl.setBorder(new EmptyBorder(10, 10, 5, 10));
        removeRsvFrame.add(promptLbl, BorderLayout.NORTH);

        //Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        gbc.gridx++;
        centerPanel.add(removeOneBtn, gbc);

        gbc.gridx++;
        centerPanel.add(removeAllBtn, gbc);

        removeRsvFrame.add(centerPanel, BorderLayout.CENTER);

        removeRsvFrame.setLocationRelativeTo(null);
        removeRsvFrame.setVisible(true);
        removeRsvFrame.setResizable(false);
    }

    public void findGuestDisplay(){
        guestFrame = new JFrame("Change Hotel Name");
        guestFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        guestFrame.setLayout(new BorderLayout());
        guestFrame.setSize(new Dimension(380, 150));

        promptLbl = new JLabel("Enter the Guest's Name to Find the Reservation", SwingConstants.CENTER);
        promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        guestFrame.add(promptLbl, BorderLayout.NORTH);

        feedbackLbl = new JLabel("", SwingConstants.CENTER);
        feedbackLbl.setFont(new Font("Dialog", Font.BOLD, 11));
        feedbackLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
        guestFrame.add(feedbackLbl, BorderLayout.SOUTH);

        //Center panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 10, 5, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;

        inputTf = new JTextField(19);

        gbc.gridx++;
        centerPanel.add(inputTf, gbc);

        gbc.gridx++;
        centerPanel.add(guestBtn, gbc);

        guestFrame.add(centerPanel, BorderLayout.CENTER);

        guestFrame.setLocationRelativeTo(null);
        guestFrame.setVisible(true);
        guestFrame.setResizable(false);
    }

    //button stuff
    public void setChangeNameBtn(ActionListener actionListener){
        this.changeNameBtn.addActionListener(actionListener);
    }

    public void setNameBtn(ActionListener actionListener){
        this.nameBtn.addActionListener(actionListener);
    }
  
    public void setAddRoomBtn(ActionListener actionListener){
        this.addRoomBtn.addActionListener(actionListener);
    }
  
    public void setRemoveRoomBtn(ActionListener actionListener){
        this.removeRoomBtn.addActionListener(actionListener);
    }
  
    public void setUpdPriceBtn(ActionListener actionListener){
        this.updPriceBtn.addActionListener(actionListener);
    }

    public void setPriceBtn(ActionListener actionListener){
        this.priceBtn.addActionListener(actionListener);
    }

    public void setDpModifyBtn(ActionListener actionListener){
        this.dpModifyBtn.addActionListener(actionListener);
    }

    public void setApplyMdBtn(ActionListener actionListener){
        this.applyMdBtn.addActionListener(actionListener);
    }
  
    public void setRemoveRsvBtn(ActionListener actionListener){
        this.removeRsvBtn.addActionListener(actionListener);
    }

    public void setRemoveOneBtn(ActionListener actionListener){
        this.removeOneBtn.addActionListener(actionListener);
    }

    public void setRemoveAllBtn(ActionListener actionListener){
        this.removeAllBtn.addActionListener(actionListener);
    }

    public void setGuestBtn(ActionListener actionListener){
        this.guestBtn.addActionListener(actionListener);
    }
  
    public void setRemoveHotelBtn(ActionListener actionListener){
        this.removeHotelBtn.addActionListener(actionListener);
    }
  
    public void setBackBtn(ActionListener actionListener){
        this.backBtn.addActionListener(actionListener);
    }

    public void setButtonList(String name, ActionListener actionListener){
        JButton button = new JButton(name);
        button.addActionListener(actionListener);
        roomList.add(button);
    }

    public void clearHotelButtons() {
        // Remove all buttons from the frame or panel
        for (JButton button : roomList) {
            roomFrame.remove(button);
        }
        roomList.clear();
        
        if(roomFrame != null){
            roomFrame.revalidate();
            roomFrame.repaint();
        }
    }

    //text stuff
    public void setFeedbackLblText(String text) {
        this.feedbackLbl.setText(text);
    }

    public void setNameLblText(String text){
        this.nameLbl.setText("~ " + text + " ~");
    }

    public void setLogLblText(String text){
        this.logLbl.setText(text);
    }

    public void clearTextFields() {
        this.inputTf.setText("");
    }

    public String getInputTf(){
        return this.inputTf.getText();
    }

    public Integer getSelectedDay() {
        return (Integer) this.daysCB.getSelectedItem();
    }

    //frame stuff
    public void closeManageHFrame(){
        this.dispose();
    }

    public void closeNameFrame(){
        this.nameFrame.dispose();
    }

    public void closeUpdPriceFrame(){
        this.updPriceFrame.dispose();
    }

    public void closeModFrame(){
        this.modFrame.dispose();
    }

    public void closeRoomFrame(){
        this.roomFrame.dispose();
    }

    public void closeRemoveRsvFrame(){
        this.removeRsvFrame.dispose();
    }

    public void closeGuestFrame(){
        this.guestFrame.dispose();
    }

}