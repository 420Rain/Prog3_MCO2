import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class HotelReservationSystemView extends JFrame {
    private JFrame mainFrame, createHFrame, viewHFrame;
    private JLabel promptLbl, promptLbl2, feedbackLbl;
    private JTextField hotelNameTf, numRoomTf;
    private JButton createHotelBtn, viewHotelBtn, manageHotelBtn, bookRoomBtn, exitBtn, createBtn, viewBtn;
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

        /*this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.mainFrame.setLayout(new BoxLayout(this.mainFrame.getContentPane(), BoxLayout.Y_AXIS));
        this.mainFrame.setSize(750, 225);*/

        this.hotelListTextArea = new JTextArea();
        this.hotelListTextArea.setPreferredSize(new Dimension(220, 170));
        this.hotelListTextArea.setEditable(false);

        this.createBtn = new JButton("Create");
        this.createBtn.setPreferredSize(new Dimension(100, 30));

        this.viewBtn = new JButton("View");
        this.viewBtn.setPreferredSize(new Dimension(100, 30));

        /*this.mainFrame.add(Box.createVerticalStrut(20));
        this.mainFrame.add(promptLbl);
        this.mainFrame.add(Box.createVerticalStrut(10));
        this.mainFrame.add(promptLbl2);
        this.mainFrame.add(Box.createVerticalStrut(20));*/

        /*JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(createHotelBtn);
        panel.add(viewHotelBtn);
        panel.add(manageHotelBtn);
        panel.add(bookRoomBtn);
        panel.add(exitBtn);
        this.mainFrame.add(panel);
        
        this.mainFrame.setVisible(true);*/
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
      panel.add(promptLbl);
      panel.add(hotelNameTf);
      panel.setPreferredSize(new Dimension(220, 30));
      this.createHFrame.add(panel);

      panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
      panel.add(promptLbl2);
      panel.add(numRoomTf);
      panel.setPreferredSize(new Dimension(220, 30));
      this.createHFrame.add(panel);

      this.createHFrame.add(createBtn);
      this.createHFrame.add(feedbackLbl);

      this.createHFrame.setLocationRelativeTo(null);
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

      this.viewHFrame.setLocationRelativeTo(null);
      this.viewHFrame.setVisible(true);
    }
}
