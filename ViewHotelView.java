<<<<<<< HEAD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewHotelView extends JFrame {
    private Hotel hotelViewed;
    private JLabel promptLbl, promptLbl2, promptLbl3, promptLbl4;
    private JButton roomAvailBtn, roomDetailBtn, reservationsBtn, backBtn;
    private JButton returnBtn, selectDayBtn;
    private JTextField availTf;
    private JTextArea availabilityTextArea = new JTextArea(15, 10);
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public ViewHotelView(Hotel hotel) {
        super("Viewing " + hotel.getName());
        this.hotelViewed = hotel;
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

        availabilityTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(availabilityTextArea);

        availPanel.add(inputPanel, BorderLayout.CENTER);
        availPanel.add(returnBtn, BorderLayout.CENTER);
        availPanel.add(scrollPane, BorderLayout.SOUTH);

        return availPanel;
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

    public void setReturnBtnListener(ActionListener actionListener) {
        returnBtn.addActionListener(actionListener);
    }

    public JTextArea getAvailabilityTA() {
        return availabilityTextArea;
    }

    public String getAvailTfText() {
        return availTf.getText();
    }

    public void showView(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
=======
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ViewHotelView extends JFrame {
    private Hotel hotelViewed;
    private JLabel promptLbl, promptLbl2, promptLbl3, promptLbl4;
    private JButton roomAvailBtn, roomDetailBtn, reservationsBtn, backBtn;
    private JButton returnBtn, selectDayBtn;
    private JTextField availTf;
    private JTextArea availabilityTextArea = new JTextArea(15, 10);
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public ViewHotelView(Hotel hotel) {
        super("Viewing " + hotel.getName());
        this.hotelViewed = hotel;
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

        availabilityTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(availabilityTextArea);

        availPanel.add(inputPanel, BorderLayout.CENTER);
        availPanel.add(returnBtn, BorderLayout.CENTER);
        availPanel.add(scrollPane, BorderLayout.SOUTH);

        return availPanel;
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

    public void setReturnBtnListener(ActionListener actionListener) {
        returnBtn.addActionListener(actionListener);
    }

    public JTextArea getAvailabilityTA() {
        return availabilityTextArea;
    }

    public String getAvailTfText() {
        return availTf.getText();
    }

    public void showView(String panelName) {
        cardLayout.show(mainPanel, panelName);
    }
>>>>>>> df834ca5672ff59fc5ca2646de4b6d6cb6c41dc6
}