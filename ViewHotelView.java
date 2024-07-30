import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import java.util.*;

public class ViewHotelView extends JFrame {
    private Hotel hotelViewed;
    private JLabel promptLbl, promptLbl2, promptLbl3, promptLbl4;
    private JLabel rLabel, rPlaceholder, pLabel, pPlaceholder, tLabel, tPlaceholder, dateLabel;
    private JLabel nPlaceholder, resPlaceholder, iPlaceholder, oPlaceholder, tpPlaceholder;
    private JButton roomAvailBtn, roomDetailBtn, reservationsBtn, backBtn;
    private JButton returnBtn, returnBtn2, returnBtn3, selectDayBtn, selectRoomBtn, returnSelectBtn, selectGuestBtn, returnSelectBtn2;
    private JTextField availTf, roomTf, guestTf;
    private JTextArea availabilityTextArea, displayRoomsTextArea;
    private JPanel mainPanel, daysPanel;
    private CardLayout cardLayout;
    private ArrayList<JLabel> labelList;    

    public ViewHotelView(Hotel hotel) {
        super("Viewing " + hotel.getName());
        this.hotelViewed = hotel;
        this.labelList = new ArrayList<JLabel>();
        setLayout(new BorderLayout());
        setSize(700, 400);

        initialize();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initialize() {
        // Left Panel
        Dimension buttonDim = new Dimension(150, 30);

        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH; // align to the top
        gbc.insets = new Insets(5, 10, 5, 10); // space around the buttons

        promptLbl = new JLabel("Please select an option!");
        westPanel.add(promptLbl, gbc);

        gbc.gridy++;
        roomAvailBtn = new JButton("Room Availability");
        roomAvailBtn.setPreferredSize(buttonDim);
        westPanel.add(roomAvailBtn, gbc);

        gbc.gridy++;
        roomDetailBtn = new JButton("Room Information");
        roomDetailBtn.setPreferredSize(buttonDim);
        westPanel.add(roomDetailBtn, gbc);

        gbc.gridy++;
        reservationsBtn = new JButton("Reservations");
        reservationsBtn.setPreferredSize(buttonDim);
        westPanel.add(reservationsBtn, gbc);

        gbc.gridy++;
        backBtn = new JButton("Back to Menu");
        backBtn.setPreferredSize(buttonDim);
        westPanel.add(backBtn, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        westPanel.add(Box.createVerticalGlue(), gbc);

        westPanel.setBackground(Color.decode("#98c1d9"));
        this.add(westPanel, BorderLayout.WEST);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3, 1));

        promptLbl2 = new JLabel("Hotel: " + hotelViewed.getName(), SwingConstants.CENTER);
        promptLbl3 = new JLabel("Number of Rooms: " + hotelViewed.getNumRooms(), SwingConstants.CENTER);
        promptLbl4 = new JLabel("Earnings this month: Php" + hotelViewed.getEarnings(), SwingConstants.CENTER);

        centerPanel.add(promptLbl2);
        centerPanel.add(promptLbl3);
        centerPanel.add(promptLbl4);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        
        mainPanel.add(centerPanel, "mainView");
        mainPanel.add(createViewAvailability(), "availView");
        mainPanel.add(createSelectRoomInfo(), "selectRoomView");
        mainPanel.add(createDisplayRoomInfo(), "displayRoomView");
        mainPanel.add(createReservationSelect(), "selectReservationView");
        mainPanel.add(createReservationDisplay(), "displayReservationView");

        this.add(mainPanel, BorderLayout.CENTER);
    }

    public JPanel createViewAvailability() {
        Dimension buttonDim = new Dimension(150, 30);

        JPanel availPanel = new JPanel();
        promptLbl4 = new JLabel("Select a day to view (1-31): ");

        availTf = new JTextField();
        availTf.setColumns(2);

        selectDayBtn = new JButton("Select");
        selectDayBtn.setPreferredSize(buttonDim);
        returnBtn = new JButton("Return to Main View");
        returnBtn.setPreferredSize(buttonDim);

        JPanel inputPanel = new JPanel();
        inputPanel.add(promptLbl4);
        inputPanel.add(availTf);
        inputPanel.add(selectDayBtn);

        availabilityTextArea = new JTextArea(10, 40);
        availabilityTextArea.setEditable(false);
        availabilityTextArea.setFocusable(false);

        availPanel.add(inputPanel, BorderLayout.CENTER);
        availPanel.add(returnBtn, BorderLayout.CENTER);
        availPanel.add(availabilityTextArea, BorderLayout.SOUTH);

        return availPanel;
    }

    public JPanel createSelectRoomInfo(){
        Dimension buttonDim = new Dimension(150, 30);

        JPanel roomPanel = new JPanel();
        displayRoomsTextArea = new JTextArea(10, 40);
        displayRoomsTextArea.setEditable(false);
        displayRoomsTextArea.setFocusable(false);

        promptLbl4 = new JLabel("Select a Room to view from the available above: ");
        roomTf = new JTextField();
        roomTf.setColumns(7);
        selectRoomBtn = new JButton("Select");
        selectRoomBtn.setPreferredSize(buttonDim);  
        returnBtn2 = new JButton("Return to Main View");
        returnBtn2.setPreferredSize(buttonDim);

        roomPanel.add(displayRoomsTextArea, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(promptLbl4, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(roomTf, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        inputPanel.add(selectRoomBtn, gbc);

        gbc.gridy = 2;
        inputPanel.add(returnBtn2, gbc);

        roomPanel.add(inputPanel, BorderLayout.SOUTH);

        return roomPanel;
    }

    /*public JPanel createDisplayRoomInfo() {
        Dimension buttonDim = new Dimension(150, 30);
    
        JPanel roomPanel2 = new JPanel(new BorderLayout());
    
        JPanel textPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        rLabel = new JLabel("Room Name: ");
        rPlaceholder = new JLabel();
        textPanel.add(rLabel);
        textPanel.add(rPlaceholder);
        tLabel = new JLabel("Room Type: ");
        tPlaceholder = new JLabel();
        textPanel.add(tLabel);
        textPanel.add(tPlaceholder);
        pLabel = new JLabel("Room Price: ");
        pPlaceholder = new JLabel();
        textPanel.add(pLabel);
        textPanel.add(pPlaceholder);
    
        roomPanel2.add(textPanel, BorderLayout.NORTH);
    
        JPanel textPanel2 = new JPanel();
        textPanel2.setLayout(new BorderLayout());
    
        JPanel legendPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        dateLabel = new JLabel("Dates Available: ");
        legendPanel.add(dateLabel);
    
        JLabel availableBox = new JLabel();
        availableBox.setPreferredSize(new Dimension(10, 10));
        availableBox.setBackground(new Color(0, 128, 0));
        availableBox.setOpaque(true);
        legendPanel.add(availableBox);
    
        JLabel textA = new JLabel(" - Available");
        legendPanel.add(textA);
    
        JLabel unavailableBox = new JLabel();
        unavailableBox.setPreferredSize(new Dimension(10, 10));
        unavailableBox.setBackground(new Color(128, 0, 0));
        unavailableBox.setOpaque(true);
        legendPanel.add(unavailableBox);
    
        JLabel textU = new JLabel(" - Unavailable");
        legendPanel.add(textU);
    
        textPanel2.add(legendPanel, BorderLayout.NORTH);
    
        JPanel daysPanel = new JPanel(new GridLayout(5, 7, 5, 5));
    
        daysPanel.removeAll();
    
        for (JLabel label : labelList) {
            daysPanel.add(label);
        }
    
        textPanel2.add(daysPanel, BorderLayout.CENTER);
    
        roomPanel2.add(textPanel2, BorderLayout.CENTER);
    
        returnSelectBtn = new JButton("Return to Selection");
        returnSelectBtn.setPreferredSize(buttonDim);
    
        roomPanel2.add(returnSelectBtn, BorderLayout.SOUTH);
    
        return roomPanel2;
    }*/

    public JPanel createDisplayRoomInfo() {
        Dimension buttonDim = new Dimension(150, 30);
        
        JPanel roomPanel2 = new JPanel(new BorderLayout());
        
        JPanel textPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        rLabel = new JLabel("Room Name: ");
        rPlaceholder = new JLabel();
        textPanel.add(rLabel);
        textPanel.add(rPlaceholder);
        tLabel = new JLabel("Room Type: ");
        tPlaceholder = new JLabel();
        textPanel.add(tLabel);
        textPanel.add(tPlaceholder);
        pLabel = new JLabel("Room Price: ");
        pPlaceholder = new JLabel();
        textPanel.add(pLabel);
        textPanel.add(pPlaceholder);
        
        roomPanel2.add(textPanel, BorderLayout.NORTH);
        
        JPanel textPanel2 = new JPanel();
        textPanel2.setLayout(new BorderLayout());
        
        JPanel legendPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        dateLabel = new JLabel("Dates Available: ");
        legendPanel.add(dateLabel);
        
        JLabel availableBox = new JLabel();
        availableBox.setPreferredSize(new Dimension(10, 10));
        availableBox.setBackground(new Color(0, 128, 0));
        availableBox.setOpaque(true);
        legendPanel.add(availableBox);
        
        JLabel textA = new JLabel(" - Available");
        legendPanel.add(textA);
        
        JLabel unavailableBox = new JLabel();
        unavailableBox.setPreferredSize(new Dimension(10, 10));
        unavailableBox.setBackground(new Color(128, 0, 0));
        unavailableBox.setOpaque(true);
        legendPanel.add(unavailableBox);
        
        JLabel textU = new JLabel(" - Unavailable");
        legendPanel.add(textU);
        
        textPanel2.add(legendPanel, BorderLayout.NORTH);
        
        daysPanel = new JPanel(new GridLayout(5, 7, 5, 5));
        
        // Ensure labelList is correctly populated
        labelList.clear(); // Clear any existing labels
        /*for (int i = 0; i < 31; i++) { // Assuming 31 days, adjust if necessary
            JLabel label = new JLabel("" + (i + 1), SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(50, 50));
            // Default to available, adjust as needed
            setGreen(label);
            labelList.add(label);
        }*/
        
        // Add labels to daysPanel
        for (JLabel label : labelList) {
            daysPanel.add(label);
        }
        
        textPanel2.add(daysPanel, BorderLayout.CENTER);
        
        roomPanel2.add(textPanel2, BorderLayout.CENTER);
        
        returnSelectBtn = new JButton("Return to Selection");
        returnSelectBtn.setPreferredSize(buttonDim);
        
        roomPanel2.add(returnSelectBtn, BorderLayout.SOUTH);
        
        return roomPanel2;
    }

    public JPanel createReservationSelect(){
        Dimension buttonDim = new Dimension(150, 30);

        JPanel selectGuest = new JPanel();
        selectGuest.setLayout(new BorderLayout());

        JLabel text = new JLabel("Type the Guest's name for their current Reservation");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        selectGuest.add(text, BorderLayout.CENTER);

        JPanel input = new JPanel();
        guestTf = new JTextField();
        guestTf.setColumns(10);
        input.add(guestTf, BorderLayout.NORTH);

        selectGuestBtn = new JButton("Select");
        selectGuestBtn.setPreferredSize(buttonDim);
        input.add(selectGuestBtn, BorderLayout.CENTER);

        returnBtn3 = new JButton("Return to Main View");
        returnBtn3.setPreferredSize(buttonDim);
        input.add(returnBtn3, BorderLayout.CENTER);

        selectGuest.add(input, BorderLayout.SOUTH);

        return selectGuest;
    }

    public JPanel createReservationDisplay(){
        //Dimension buttonDim = new Dimension(150, 30);

        JPanel displayPanel = new JPanel();
        
        JPanel necessaryInfo = new JPanel();
        necessaryInfo.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel name = new JLabel("GuestName: ");
        nPlaceholder = new JLabel();
        JLabel room = new JLabel("Room: ");
        resPlaceholder = new JLabel();
        JLabel in = new JLabel("Check-In Day: ");
        iPlaceholder = new JLabel();
        JLabel out = new JLabel("Check-Out Day: ");
        oPlaceholder = new JLabel();
        JLabel tp = new JLabel("Total price for Reservation: ");
        tpPlaceholder = new JLabel();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        necessaryInfo.add(name, gbc);

        gbc.gridx = 1;
        necessaryInfo.add(nPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        necessaryInfo.add(room, gbc);

        gbc.gridx = 1;
        necessaryInfo.add(resPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        necessaryInfo.add(in, gbc);

        gbc.gridx = 1;
        necessaryInfo.add(iPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        necessaryInfo.add(out, gbc);

        gbc.gridx = 1;
        necessaryInfo.add(oPlaceholder, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        necessaryInfo.add(tp, gbc);

        gbc.gridy = 5;
        necessaryInfo.add(tpPlaceholder, gbc);
        displayPanel.add(necessaryInfo, BorderLayout.NORTH);

        return displayPanel;
    }

    public void setRoomAvailBtnListener(ActionListener actionListener) {
        roomAvailBtn.addActionListener(actionListener);
    }

    public void setRoomDetailBtnListener(ActionListener actionListener) {
        roomDetailBtn.addActionListener(actionListener);
    }

    public void setReservationsBtnListener(ActionListener actionListener) {
        reservationsBtn.addActionListener(actionListener);
    }

    public void setBackBtnListener(ActionListener actionListener) {
        backBtn.addActionListener(actionListener);
    }

    public void setSelectDayBtnListener(ActionListener actionListener) {
        selectDayBtn.addActionListener(actionListener);
    }

    public void setSelectRoomBtnListener(ActionListener actionListener){
        selectRoomBtn.addActionListener(actionListener);
    }

    public void setSelectGuestBtnListener(ActionListener actionListener){
        selectGuestBtn.addActionListener(actionListener);
    }

    public void setReturnBtnListener(ActionListener actionListener) {
        returnBtn.addActionListener(actionListener);
    }

    public void setReturnBtn2Listener(ActionListener actionListener) {
        returnBtn2.addActionListener(actionListener);
    }

    public void setReturnBtn3Listener(ActionListener actionListener) {
        returnBtn3.addActionListener(actionListener);
    }

    public void setReturnSelectBtn(ActionListener actionListener){
        returnSelectBtn.addActionListener(actionListener);
    }

    /*public void setReturnSelectBtn2(ActionListener actionListener){
        returnSelectBtn2.addActionListener(actionListener);
    }*/

    public void setGreen(JLabel label){
        label.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(0, 128, 0));
        label.setOpaque(true);
    }

    public void setRed(JLabel label){
        label.setBackground(new Color(255, 255, 255));
        label.setForeground(new Color(128, 0, 0));
        label.setOpaque(true);
    }

    public JLabel getRPlaceHolder(){
        return rPlaceholder;
    }

    public JLabel getPPlaceHolder(){
        return pPlaceholder;
    }

    /*public JLabel getTPlaceHolder(){
        return tPlaceholder;
    }*/

    public ArrayList<JLabel> getLabelList(){
        return labelList;
    }

    public JTextArea getAvailabilityTA() {
        return availabilityTextArea;
    }

    public void updateAvailabilityTA(){
        this.availabilityTextArea.repaint();
        this.availabilityTextArea.revalidate();
    }

    public String getAvailTfText() {
        return availTf.getText();
    }

    public JTextArea getDisplayRoomsTA() {
        return displayRoomsTextArea;
    }

    public String getRoomTfText() {
        return roomTf.getText();
    }

    public String getGuestTfText(){
        return guestTf.getText();
    }

    public JLabel getNPlaceHolder(){
        return nPlaceholder;
    }

    public JLabel getResPlaceHolder(){
        return resPlaceholder;
    }

    public JLabel getIPlaceHolder(){
        return iPlaceholder;
    }

    public JLabel getOPlaceHolder(){
        return oPlaceholder;
    }

    public JLabel getTpPlaceHolder(){
        return tpPlaceholder;
    }

    public void showView(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }

    public JPanel getDaysPanel(){
        return this.daysPanel;
    }
}