import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.BorderUIResource;

import java.util.*;

public class HotelReservationSystemView extends JFrame {
    private ArrayList<JFrame> frameList = new ArrayList<JFrame>();
    private JLabel promptLbl, promptLbl2, feedbackLbl;
    private JTextField hotelNameTf, numRoomTf;
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, exitBtn, createBtn, viewBtn, okayBtn, manageBtn;
    private JTextArea hotelListTextArea;

    public HotelReservationSystemView(){
        super("Hotel Reservation System");
        setLayout(new BorderLayout());
        setSize(700, 400);
        
        initialize();

        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JFrame createHFrame = new JFrame("Create a Hotel !");
        this.frameList.add(createHFrame);

        JFrame noHFrame = new JFrame("Hotel Reservation System");
        this.frameList.add(noHFrame);

        JFrame viewHFrame = new JFrame("View a Hotel !");
        this.frameList.add(viewHFrame);

        this.hotelListTextArea = new JTextArea();
        this.hotelListTextArea.setPreferredSize(new Dimension(220, 170));
        this.hotelListTextArea.setEditable(false);

        this.createBtn = new JButton("Create");
        this.createBtn.setPreferredSize(new Dimension(100, 30));

        this.viewBtn = new JButton("View");
        this.viewBtn.setPreferredSize(new Dimension(100, 30));

        this.okayBtn = new JButton("Okay");
        this.okayBtn.setPreferredSize(new Dimension(100, 20));
        
        //removes the blue thing around the text of the button but needs to applied to all buttons :(
        this.okayBtn.setFocusPainted(false);
    }

    public void initialize(){
        //Left Panel
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
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout());

        promptLbl2 = new JLabel("Welcome to the Hotel Reservation System!");
        promptLbl2.setHorizontalAlignment(SwingConstants.CENTER);
        centerPanel.add(promptLbl2, BorderLayout.CENTER);

        this.add(centerPanel, BorderLayout.CENTER);
    }
    
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

    public void setCreateBtnListener(ActionListener actionListener){
      this.createBtn.addActionListener(actionListener);
    }

    public void setViewBtnListener(ActionListener actionListener){
      this.viewBtn.addActionListener(actionListener);
    }

    public void setOkayBtnListener(ActionListener actionListener){
      this.okayBtn.addActionListener(actionListener);
    }

    public void setFeedbackLblText(String text) {
      this.feedbackLbl.setText(text);
    }

    public void setHotelListLblText(String text) {
      this.hotelListTextArea.setText(text);
    }

    public String getHotelNameTfText() {
      return this.hotelNameTf.getText();
    }
  
    public String getNumRoomTfText() {
      return this.numRoomTf.getText();
    }
  
    public void clearTextFields() {
      this.hotelNameTf.setText("");
      this.numRoomTf.setText("");
    }

    public void closeWindow(JFrame Window){
      Window.dispose();
    }
    
    public void clearPanels(){ 
      //clears panels
    }

    public void createHotelDisplay(){
      JFrame createHFrame = this.frameList.get(0);

      createHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  createHFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
      createHFrame.setSize(600, 125);

      this.promptLbl = new JLabel("Enter Hotel Name: ");
      this.promptLbl2 = new JLabel("Enter # of Rooms: ");
      this.feedbackLbl = new JLabel();
      this.feedbackLbl.setPreferredSize(new Dimension(220, 30));
      
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
      JFrame noHFrame = this.frameList.get(1);

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

    public void viewHotelDisplay(){
      JFrame viewHFrame = this.frameList.get(2);

      viewHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  viewHFrame.setLayout(new BoxLayout(viewHFrame.getContentPane(), BoxLayout.Y_AXIS));
      viewHFrame.setSize(600, 300);

      this.promptLbl = new JLabel("Select a Hotel to view !");
      this.promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
      this.promptLbl2 = new JLabel("Hotel: ");


      JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      viewHFrame.add(hotelListTextArea);
      viewHFrame.add(panel);

      this.hotelNameTf = new JTextField();
		  this.hotelNameTf.setColumns(10);

      viewHFrame.add(Box.createVerticalStrut(15));
      viewHFrame.add(promptLbl);
      viewHFrame.add(Box.createVerticalStrut(10));

      panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      panel.add(this.promptLbl2);
      panel.add(this.hotelNameTf);
      panel.setPreferredSize(new Dimension(220, 30));
      viewHFrame.add(panel);

      this.viewBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
      viewHFrame.add(viewBtn);

      viewHFrame.setLocationRelativeTo(null);
      viewHFrame.setVisible(true);
    }

    public ArrayList<JFrame> getFrameList(){
      return this.frameList;
    }
}
