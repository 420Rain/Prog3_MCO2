import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HotelReservationSystemView{
    private JFrame mainFrame, createHFrame, viewHFrame;
    private JLabel promptLbl, promptLbl2, feedbackLbl;
    private JTextField hotelNameTf, numRoomTf;
    private JTextArea hotelListTextArea;
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, exitBtn, createBtn, viewBtn;

    public HotelReservationSystemView(){
        this.mainFrame = new JFrame("Hotel Reservation System");

        this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BoxLayout(this.mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        this.mainFrame.setSize(750, 225);

        this.promptLbl = new JLabel("Welcome to the Hotel Reservation System !");
        this.promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.promptLbl2 = new JLabel("Please select an option !");
        this.promptLbl2.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.hotelListTextArea = new JTextArea();
        this.hotelListTextArea.setPreferredSize(new Dimension(220, 170));
        this.hotelListTextArea.setEditable(false);

        this.createHotelBtn = new JButton("Create a Hotel");
        this.createHotelBtn.setPreferredSize(new Dimension(220, 30));
        this.viewHotelBtn = new JButton("View Hotels");
        this.viewHotelBtn.setPreferredSize(new Dimension(220, 30));
        this.manageHotelBtn = new JButton("Manage a Hotel");
        this.manageHotelBtn.setPreferredSize(new Dimension(220, 30));
        this.bookRoomBtn = new JButton("Book a Room");
        this.bookRoomBtn.setPreferredSize(new Dimension(220, 30));
        this.exitBtn = new JButton("Exit the System");
        this.exitBtn.setPreferredSize(new Dimension(220, 30));
        this.createBtn = new JButton("Create");
        this.createBtn.setPreferredSize(new Dimension(100, 30));
        this.viewBtn = new JButton("View");
        this.viewBtn.setPreferredSize(new Dimension(100, 30));

        this.mainFrame.add(Box.createVerticalStrut(20));
        this.mainFrame.add(promptLbl);
        this.mainFrame.add(Box.createVerticalStrut(10));
        this.mainFrame.add(promptLbl2);
        this.mainFrame.add(Box.createVerticalStrut(20));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(createHotelBtn);
        panel.add(viewHotelBtn);
        panel.add(manageHotelBtn);
        panel.add(bookRoomBtn);
        panel.add(exitBtn);
        this.mainFrame.add(panel);
        
        this.mainFrame.setVisible(true);
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

    public void createHotelDisplay(){
      this.createHFrame = new JFrame("Create a Hotel !");
      this.createHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  this.createHFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
      this.createHFrame.setSize(600, 125);

      this.promptLbl = new JLabel("Enter Hotel Name: ");
      this.promptLbl2 = new JLabel("Enter # of Rooms: ");
      this.feedbackLbl = new JLabel();
      this.feedbackLbl.setPreferredSize(new Dimension(220, 30));
      
      this.hotelNameTf = new JTextField();
		  this.hotelNameTf.setColumns(10);
		  this.numRoomTf = new JTextField();
		  this.numRoomTf.setColumns(2);

      JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.add(this.promptLbl);
      panel.add(this.hotelNameTf);
      panel.setPreferredSize(new Dimension(220, 30));
      this.createHFrame.add(panel);

      panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.add(promptLbl2);
      panel.add(numRoomTf);
      panel.setPreferredSize(new Dimension(220, 30));
      this.createHFrame.add(panel);

      this.createHFrame.add(createBtn);
      this.createHFrame.add(feedbackLbl);

      this.createHFrame.setVisible(true);
    }

    public void viewHotelDisplay(){
      this.viewHFrame = new JFrame("View a Hotel !");
      this.viewHFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		  this.viewHFrame.setLayout(new BoxLayout(this.viewHFrame.getContentPane(), BoxLayout.Y_AXIS));
      this.viewHFrame.setSize(600, 300);
      
      this.promptLbl = new JLabel("Select a Hotel to view !");
      this.promptLbl.setAlignmentX(Component.CENTER_ALIGNMENT);
      this.promptLbl2 = new JLabel("Hotel: ");
        

      JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      this.viewHFrame.add(hotelListTextArea);
      this.viewHFrame.add(panel);

      this.hotelNameTf = new JTextField();
		  this.hotelNameTf.setColumns(10);

      this.viewHFrame.add(Box.createVerticalStrut(15));
      this.viewHFrame.add(promptLbl);
      this.viewHFrame.add(Box.createVerticalStrut(10));

      panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
      panel.add(this.promptLbl2);
      panel.add(this.hotelNameTf);
      panel.setPreferredSize(new Dimension(220, 30));
      this.viewHFrame.add(panel);

      this.viewBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
      this.viewHFrame.add(viewBtn);

      this.viewHFrame.setVisible(true);
    }
}
