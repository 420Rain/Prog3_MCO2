package HRS;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.*;

/**
* This class creates the GUI for the HotelReservation view or the Main Menu
* @author Rainier A. Dulatre
* @author Patrick Hans A. Perez
* @version 1.0
*/
public class HotelReservationSystemView extends JFrame {
    /**
     * These variables create the Frames for the 3 main Frames being the
     * create a hotel, no hotel and select hotel
     */
    private JFrame createHFrame, noHFrame, selectHFrame;
    /**
     * This variable contains an arrayList of JButtons 
     */ 
    private ArrayList<JButton> hotelList = new ArrayList<JButton>();
    /**
     * These variables are labels used in other methods of the GUI
     */
    private JLabel promptLbl, promptLbl2, feedbackLbl;
    /**
     * These variables are the textfields that are used in the GUI for creating
     * a hotel object
     */
    private JTextField hotelNameTf, numRoomTf;
    /**
     * These variables are buttons that are used for creating the buttons that will lead to other MVCs
     */
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, exitBtn, createBtn, viewBtn, okayBtn;
    /**
     * This variable is a textArea for hotel lists
     */
    private JTextArea hotelListTextArea;
    /**
     * These variables are panels that will be used to organize components
     */
    private JPanel westPanel, centerPanel;

    /**
     * Creates an instance of HotelReservationSystemView
     */
    public HotelReservationSystemView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());
        setSize(700, 400);
        
        westPanel = new JPanel();
        westPanel.setLayout(new GridBagLayout());

        centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        //initializes the main frame
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
        
        //removes the blue thing around the text of the button but needs to applied to all buttons :(
        this.okayBtn.setFocusPainted(false);
    }
    
    /**
     * This method initializes the main menu of the GUI
     */
    public void initialize(){
        Dimension buttonDim = new Dimension(170, 30);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.insets = new Insets(5, 10, 5, 10);

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

        promptLbl2 = new JLabel("Welcome to the Hotel Reservation System!");
        promptLbl2.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(promptLbl2, BorderLayout.CENTER);

        this.add(centerPanel, BorderLayout.CENTER);

        westPanel.revalidate();
        westPanel.repaint();
        centerPanel.revalidate();
        centerPanel.repaint();
    }
    
    /**
     * This method sets the actionListener for the createHotelBtn
     * @param actionListener an actionlistener
     */
    public void setCreateHotelBtnListener(ActionListener actionListener) {
		  this.createHotelBtn.addActionListener(actionListener);
	  }

    /**
     * This method sets the actionListener for the viewHotelBtn
     * @param actionListener an actionlistener
     */
    public void setViewHotelBtnListener(ActionListener actionListener) {
		  this.viewHotelBtn.addActionListener(actionListener);
	  }

    /**
     * This method sets the actionListener for the manageHotelBtn
     * @param actionListener an actionlistener
     */
    public void setManageHotelBtnListener(ActionListener actionListener) {
		  this.manageHotelBtn.addActionListener(actionListener);
	  }

    /**
     * This method sets the actionListener for the bookRoomBtn
     * @param actionListener an actionlistener
     */
    public void setBookRoomListener(ActionListener actionListener) {
		  this.bookRoomBtn.addActionListener(actionListener);
	  }

    /**
     * This method sets the actionListener for the exitBtn
     * @param actionListener an actionlistener
     */
    public void setExitBtnListener(ActionListener actionListener) {
		  this.exitBtn.addActionListener(actionListener);
	  }

    /**
     * This method sets the actionListener for the createBtn
     * @param actionListener an actionlistener
     */
    public void setCreateBtnListener(ActionListener actionListener){
      this.createBtn.addActionListener(actionListener);
    }

    /**
     * This method sets the actionListener for the createHotelBtn
     * @param actionListener an actionlistener
     */
    public void setViewBtnListener(ActionListener actionListener){
      this.viewBtn.addActionListener(actionListener);
    }

    /**
     * This method sets the actionListener for the okayBtn
     * @param actionListener an actionlistener
     */
    public void setOkayBtnListener(ActionListener actionListener){
      this.okayBtn.addActionListener(actionListener);
    }

    /**
     * This method sets the feedback text of the JLabel
     * @param text feedback text
     */
    public void setFeedbackLblText(String text) {
      this.feedbackLbl.setText(text);
    }

    /**
     * This method initializes the button and adds it to the buttonlist
     * @param name name of the button
     * @param actionListener an action listener
     */
    public void setButtonList(String name, ActionListener actionListener){
      JButton button = new JButton(name);
      button.addActionListener(actionListener);
      button.setPreferredSize(new Dimension(220, 30));
      hotelList.add(button);
    }

    /**
     * This method returns the text of the textfield of hotelNameTf
     * @return string
     */
    public String getHotelNameTfText() {
      return this.hotelNameTf.getText();
    }
    
    /**
     * This method returns the text of the textfield of numRoomTf
     * @return string
     */
    public String getNumRoomTfText() {
      return this.numRoomTf.getText();
    }
    
    /**
     * This method clears the textfields of text
     */
    public void clearTextFields() {
      this.hotelNameTf.setText("");
      this.numRoomTf.setText("");
    }

    /**
     * This method closes a JFrame without terminating the program
     * @param Window frame being closed
     */
    public void closeWindow(JFrame Window){
      Window.dispose();
    }
    
    /**
     * This method clears out the components in a JPanel
     * @param Panel panel being removed of component
     */
    public void clearPanels(JPanel Panel){ 
      Panel.removeAll();
    }

    /**
     * This method removes buttons in a frame or a panel
     */
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

    /**
     * This method displays and interface of creating a hotel
     */
    public void createHotelDisplay(){
      createHFrame = new JFrame("Create a Hotel");

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

    /**
     * This method displays if there is no hotel in the database
     * of the hotel reservation system
     */
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

    /**
     * This method displays a button of hotels with the options
     * of viewing them, managing them, and booking a room in them
     * @param index the option whether to view, manage or book
     */
    public void selectHotel(int index){
      selectHFrame = new JFrame();
      
      if(index == 0){
        promptLbl = new JLabel("Select a Hotel to view!");
        promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectHFrame.setTitle("View Hotel");
      }
      if(index == 1){
        promptLbl = new JLabel("Select a Hotel to manage!");
        promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectHFrame.setTitle("Manage Hotel");
      }
      if(index == 2){
        promptLbl = new JLabel("Select a Hotel to Book In!");
        promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectHFrame.setTitle("Book A Room");
      }

      selectHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  selectHFrame.setLayout(new BoxLayout(selectHFrame.getContentPane(), BoxLayout.Y_AXIS));
      selectHFrame.setSize(260, 300);   

      selectHFrame.add(Box.createVerticalStrut(15));
      selectHFrame.add(promptLbl);
      selectHFrame.add(Box.createVerticalStrut(10));

      Iterator<JButton> button = hotelList.iterator();
      while (button.hasNext()) {
        JButton hButton = button.next();
        hButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        selectHFrame.add(hButton);
      }
      
      selectHFrame.setLocationRelativeTo(null);
      selectHFrame.setVisible(true);
      selectHFrame.setResizable(false);
    }

    /**
     * This method closes the createHotelFrame
     */
    public void closeCreateHFrame(){
      createHFrame.dispose();
    }

    /**
     * This method closes the selectHotelFrame
     */
    public void closeSelectHFrame(){
      selectHFrame.dispose();
    }

    /**
     * This method closes the noHotelFrame
     */
    public void closeNoHFrame(){
      noHFrame.dispose();
    }
}
