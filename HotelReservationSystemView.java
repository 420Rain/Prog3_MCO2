import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.BorderUIResource;

import java.util.*;

public class HotelReservationSystemView extends JFrame {
    private JFrame createHFrame, noHFrame, selectHFrame, manageHFrame;
    private ArrayList<JButton> hotelList = new ArrayList<JButton>();  
    private JLabel promptLbl, promptLbl2, feedbackLbl;
    private JTextField hotelNameTf, numRoomTf;
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, exitBtn, createBtn, viewBtn, okayBtn, 
    changeNameBtn, addRoomBtn, removeRoomBtn, updPriceBtn, removeRsvBtn, removeHotelBtn, backBtn;
    private JTextArea hotelListTextArea;
    private JPanel westPanel, centerPanel;

    public HotelReservationSystemView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());
        setSize(700, 400);
        
        westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        initialize();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.hotelListTextArea = new JTextArea();
        this.hotelListTextArea.setPreferredSize(new Dimension(220, 170));
        this.hotelListTextArea.setEditable(false);
        this.hotelListTextArea.setFocusable(false);

        

        //for createHFrame
        this.createBtn = new JButton("Create");
        this.createBtn.setPreferredSize(new Dimension(100, 30));

        this.viewBtn = new JButton("View");
        this.viewBtn.setPreferredSize(new Dimension(100, 30));

        //for noHFrame
        this.okayBtn = new JButton("Okay");
        this.okayBtn.setPreferredSize(new Dimension(100, 20));

        /*for manageHFram
        Dimension buttonDim = new Dimension(170, 30);

        this.changeNameBtn = new JButton("Change Hotel Name");
        this.changeNameBtn.setPreferredSize(buttonDim);
  
        this.addRoomBtn = new JButton("Add a Room");
        this.addRoomBtn.setPreferredSize(buttonDim);
  
        this.removeRoomBtn = new JButton("Remove a Room");
        this.removeRoomBtn.setPreferredSize(buttonDim);
  
        this.updPriceBtn = new JButton("Update Room Prices");
        this.updPriceBtn.setPreferredSize(buttonDim);
  
        this.removeRsvBtn = new JButton("Cancel A Reservation");
        this.removeRsvBtn.setPreferredSize(buttonDim);
  
        this.removeHotelBtn = new JButton("Remove This Hotel");
        this.removeHotelBtn.setPreferredSize(buttonDim);

        this.backBtn = new JButton("Back to Main Menu");
        this.backBtn.setPreferredSize(buttonDim);*/
        
        //removes the blue thing around the text of the button but needs to applied to all buttons :(
        this.okayBtn.setFocusPainted(false);
    }

    public void initialize(){
        Dimension buttonDim = new Dimension(170, 30);

        //Left Panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH; // align to the top
        gbc.insets = new Insets(5, 10, 5, 10); // space around the buttons

        promptLbl = new JLabel("Select an Option", SwingConstants.CENTER);
        westPanel.add(promptLbl, gbc);

        gbc.gridy++;
        createHotelBtn = new JButton("Create a Hotel");
        createHotelBtn.setPreferredSize(buttonDim);
        westPanel.add(createHotelBtn, gbc);

        gbc.gridy++;
        viewHotelBtn = new JButton("View Hotels");
        viewHotelBtn.setPreferredSize(buttonDim);
        westPanel.add(viewHotelBtn, gbc);

        gbc.gridy++;
        manageHotelBtn = new JButton("Manage a Hotel");
        manageHotelBtn.setPreferredSize(buttonDim);
        westPanel.add(manageHotelBtn, gbc);

        gbc.gridy++;
        bookRoomBtn = new JButton("Book a Room");
        bookRoomBtn.setPreferredSize(buttonDim);
        westPanel.add(bookRoomBtn, gbc);

        gbc.gridy++;
        exitBtn = new JButton("Exit the System");
        exitBtn.setPreferredSize(buttonDim);
        westPanel.add(exitBtn, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        westPanel.add(Box.createVerticalGlue(), gbc);

        westPanel.setBackground(Color.decode("#98c1d9"));

        this.add(westPanel, BorderLayout.WEST);

        //Center Panel
        promptLbl2 = new JLabel("Welcome to the Hotel Reservation System!");
        promptLbl2.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(promptLbl2, BorderLayout.CENTER);

        this.add(centerPanel, BorderLayout.CENTER);
        
    }
    
    //for main menu buttons
    public void setCreateHotelBtnListener(ActionListener actionListener) {
		  this.createHotelBtn.addActionListener(actionListener);
	  }

    public void setViewHotelBtnListener(ActionListener actionListener) {
		  this.viewHotelBtn.addActionListener(actionListener);
	  }

    public void setManageHotelBtnListener(ActionListener actionListener) {
		  this.manageHotelBtn.addActionListener(actionListener);
	  }

    public void setBookRoomListener(ActionListener actionListener) {
		  this.bookRoomBtn.addActionListener(actionListener);
	  }

    public void setExitBtnListener(ActionListener actionListener) {
		  this.exitBtn.addActionListener(actionListener);
	  }

    //for create hotel window
    public void setCreateBtnListener(ActionListener actionListener){
      this.createBtn.addActionListener(actionListener);
    }

    //for view hotel window
    public void setViewBtnListener(ActionListener actionListener){
      this.viewBtn.addActionListener(actionListener);
    }

    //for no hotel window
    public void setOkayBtnListener(ActionListener actionListener){
      this.okayBtn.addActionListener(actionListener);
    }

    /*for manage hotel buttons
    public void setChangeNameBtn(ActionListener actionListener){
      this.changeNameBtn.addActionListener(actionListener);
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

    public void setRemoveRsvBtn(ActionListener actionListener){
      this.removeRsvBtn.addActionListener(actionListener);
    }

    public void setRemoveHotelBtn(ActionListener actionListener){
      this.removeHotelBtn.addActionListener(actionListener);
    }

    public void setBackBtn(ActionListener actionListener){
      this.backBtn.addActionListener(actionListener);
    }*/

    //for text stuff

    public void setFeedbackLblText(String text) {
      this.feedbackLbl.setText(text);
    }

    public void setButtonList(String name, ActionListener actionListener){
      JButton button = new JButton(name);
      button.addActionListener(actionListener);
      button.setPreferredSize(new Dimension(220, 30));
      hotelList.add(button);
    }

    public String getHotelNameTfText() {
      return this.hotelNameTf.getText();
    }

    /*public void clearHotelButtons(){
      this.hotelList.clear();
    }*/
  
    public String getNumRoomTfText() {
      return this.numRoomTf.getText();
    }
  
    public void clearTextFields() {
      this.hotelNameTf.setText("");
      this.numRoomTf.setText("");
    }
    
    public void clearPanel(JPanel Panel){ 
      //clears panels in mainframe
      Panel.removeAll();
    }

    public void clearHotelButtons() {
      // Remove all buttons from the frame or panel
      for (JButton button : hotelList) {
          selectHFrame.remove(button);
      }
      hotelList.clear();
      
      if(selectHFrame != null){
        selectHFrame.revalidate();
        selectHFrame.repaint();
      }
    }

    /*public void manageHotelDisplay(Hotel hotel){
      manageHFrame = new JFrame("Manage Hotel");

      manageHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      manageHFrame.setLayout(new BorderLayout());
      manageHFrame.setSize(300,450);

      //Top panel
      JPanel northPanel = new JPanel();
      northPanel.setLayout(new BorderLayout());
      promptLbl = new JLabel("~ " + hotel.getName() + " ~", SwingConstants.CENTER);
      promptLbl.setBorder(new EmptyBorder(10, 10, 10, 10));
      northPanel.add(promptLbl, BorderLayout.NORTH);

      promptLbl2 = new JLabel("What Would You Like to do With this Hotel?", SwingConstants.CENTER);
      northPanel.add(promptLbl2, BorderLayout.CENTER);

      manageHFrame.add(northPanel, BorderLayout.NORTH);

      //Center Panel
      JPanel centerPanel = new JPanel();
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
      centerPanel.add(removeRsvBtn, gbc);

      gbc.gridy++;
      centerPanel.add(removeHotelBtn, gbc);

      gbc.gridy++;
      centerPanel.add(backBtn, gbc);

      manageHFrame.add(centerPanel, BorderLayout.CENTER);

      feedbackLbl = new JLabel("", SwingConstants.CENTER);
      feedbackLbl.setFont(new Font("Dialog", Font.BOLD, 10));
      feedbackLbl.setPreferredSize(new Dimension(200, 30));
      
      manageHFrame.add(feedbackLbl, BorderLayout.SOUTH);

      manageHFrame.setLocationRelativeTo(null);
      manageHFrame.setVisible(true);
      manageHFrame.setResizable(false);
    }*/

    public void createHotelDisplay(){
      createHFrame = new JFrame("Create a Hotel");

      createHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  createHFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
      createHFrame.setSize(600, 125);

      this.promptLbl = new JLabel("Enter Hotel Name: ");
      this.promptLbl2 = new JLabel("Enter # of Rooms: ");
      this.feedbackLbl = new JLabel("", SwingConstants.CENTER);
      this.feedbackLbl.setPreferredSize(new Dimension(500, 30));
      
      this.hotelNameTf = new JTextField();
		  this.hotelNameTf.setColumns(10);
		  this.numRoomTf = new JTextField();
		  this.numRoomTf.setColumns(2);

      JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.add(promptLbl);
      panel.add(hotelNameTf);
      panel.setPreferredSize(new Dimension(220, 30));
      createHFrame.add(panel);

      panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.add(promptLbl2);
      panel.add(numRoomTf);
      panel.setPreferredSize(new Dimension(220, 30));
      createHFrame.add(panel);

      createHFrame.add(createBtn);
      createHFrame.add(feedbackLbl);

      createHFrame.setLocationRelativeTo(null);
      createHFrame.setVisible(true);
    }

    public void noHotelDisplay(){
      noHFrame = new JFrame("Hotel Reservation System");

      noHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      noHFrame.setLayout(new BorderLayout());
      noHFrame.setSize(450, 100);

      promptLbl = new JLabel("Cannot Proceed. No Hotels Found. Click Create Hotel to Create One", SwingConstants.CENTER);

      JPanel centerPanel = new JPanel();
      centerPanel.setLayout(new BorderLayout());
      centerPanel.add(promptLbl);

      noHFrame.add(centerPanel, BorderLayout.CENTER);

      JPanel southPanel = new JPanel();
      southPanel.setLayout(new FlowLayout());
      okayBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
      southPanel.add(okayBtn);

      noHFrame.add(southPanel, BorderLayout.SOUTH);
      
      noHFrame.setLocationRelativeTo(null);
      noHFrame.setVisible(true);
      noHFrame.setResizable(false);
    }

    public void selectHotel(int index){
      selectHFrame = new JFrame();
      
      if(index == 0){
        selectHFrame.setTitle("View Hotel");
      }
      if(index == 1){
        selectHFrame.setTitle("Manage Hotel");
      }

      selectHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  selectHFrame.setLayout(new BoxLayout(selectHFrame.getContentPane(), BoxLayout.Y_AXIS));
      selectHFrame.setSize(250, 300);

      promptLbl = new JLabel("Select a Hotel to view !");
      promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);

      selectHFrame.add(Box.createVerticalStrut(15));
      selectHFrame.add(promptLbl);
      selectHFrame.add(Box.createVerticalStrut(10));

      Iterator<JButton> button = hotelList.iterator();
      while (button.hasNext()) {
        JButton hButton = button.next();
        hButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //hButton.setPreferredSize(new Dimension(180, 30));
        selectHFrame.add(hButton);
      }
      
      selectHFrame.setLocationRelativeTo(null);
      selectHFrame.setVisible(true);
      selectHFrame.setResizable(false);
    }


    public void closeCreateHFrame(){
      createHFrame.dispose();
    }

    public void closeSelectHFrame(){
      selectHFrame.dispose();
    }

    public void closeNoHFrame(){
      noHFrame.dispose();
    }

    /*public void closeManageHFrame(){
      manageHFrame.dispose();
    }

    public JButton getAddRoomBtn() {
      return addRoomBtn;
    }
  
    public JButton getRemoveHotelBtn() {
      return removeHotelBtn;
    }*/
}
