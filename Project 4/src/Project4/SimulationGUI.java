package Project4;

import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSlider;
import java.awt.event.ActionListener;

public class SimulationGUI {

	public static ArrayList<Eatery> eateryList = new ArrayList<>();
	private Random rand = new Random();
	private CIS163Q cashierQ;
	private int restaurantNumber;
	private int avgRestaurantTime;
	private int avgCashierTime;
	private int simulationTime;
	private int newCustomerRate;
	private int leaveTime;
	private boolean cashier1 = false;
	private boolean cashier2 = false;
	public Timer timer;
	private int simulationSpeed;
	
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimulationGUI window = new SimulationGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SimulationGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 557, 710);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 0, 538, 235);
		frame.getContentPane().add(panel1);
		panel1.setLayout(null);
		
		JLabel lblinputInformation = new JLabel("---------------------------   Input information   ---------------------------");
		lblinputInformation.setBounds(6, 5, 525, 21);
		lblinputInformation.setFont(new Font("Aharoni", Font.BOLD, 20));
		panel1.add(lblinputInformation);
		
		JLabel lblNumberOfRestaurants = new JLabel("Number of restaurants");
		lblNumberOfRestaurants.setBounds(16, 35, 143, 16);
		lblNumberOfRestaurants.setHorizontalAlignment(SwingConstants.LEFT);
		panel1.add(lblNumberOfRestaurants);
		
		JLabel lblAverageTimeinRestaurant = new JLabel("Average time in restaurant");
		lblAverageTimeinRestaurant.setBounds(16, 78, 160, 16);
		panel1.add(lblAverageTimeinRestaurant);
		
		JLabel lblAverageTimeIn = new JLabel("Average time in cashier");
		lblAverageTimeIn.setBounds(16, 123, 143, 16);
		panel1.add(lblAverageTimeIn);
		
		JLabel lblSimulationTimes = new JLabel("Simulation time (s)");
		lblSimulationTimes.setBounds(275, 39, 135, 16);
		panel1.add(lblSimulationTimes);
		
		JLabel lblNewCustomerTime = new JLabel("New customer time rate");
		lblNewCustomerTime.setBounds(275, 78, 143, 16);
		panel1.add(lblNewCustomerTime);
		
		JLabel lblTimeBeforeCustomers = new JLabel("Time before customers leaves");
		lblTimeBeforeCustomers.setBounds(275, 123, 189, 16);
		panel1.add(lblTimeBeforeCustomers);
		
		textField = new JTextField();
		textField.setBounds(181, 39, 82, 22);
		panel1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(181, 75, 82, 22);
		panel1.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(181, 120, 82, 22);
		panel1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(459, 32, 72, 22);
		panel1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(459, 75, 72, 22);
		panel1.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(459, 120, 72, 22);
		panel1.add(textField_5);
		
		JLabel lblOpenCashier = new JLabel("Open cashier");
		lblOpenCashier.setBounds(16, 163, 147, 16);
		panel1.add(lblOpenCashier);
		
		JToggleButton tglbtnCashier = new JToggleButton("Cashier 1");
		tglbtnCashier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashier1 = true;
			}
		});
		tglbtnCashier.setBounds(181, 159, 98, 25);
		panel1.add(tglbtnCashier);
		
		JToggleButton tglbtnCashier_1 = new JToggleButton("Cashier 2");
		tglbtnCashier_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cashier2 = true;
			}
		});
		tglbtnCashier_1.setBounds(300, 159, 98, 25);
		panel1.add(tglbtnCashier_1);
		
		JButton btnRun = new JButton("RUN");
		btnRun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				execute();
			}
		});
		btnRun.setBackground(Color.GREEN);
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRun.setForeground(Color.BLACK);
		btnRun.setBounds(428, 160, 98, 64);
		panel1.add(btnRun);
		
		JSlider slider = new JSlider();
		slider.setBounds(181, 197, 200, 26);
		panel1.add(slider);
		
		JLabel lblSpeed = new JLabel("Speed");
		lblSpeed.setBounds(16, 207, 56, 16);
		panel1.add(lblSpeed);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(0, 480, 538, 183);
		frame.getContentPane().add(panel3);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(0, 234, 538, 246);
		frame.getContentPane().add(panel2);
		panel2.setLayout(null);
		
		JLabel lblOutputInformation = new JLabel("---------------------------   Output information   ---------------------------");
		lblOutputInformation.setBounds(-2, 5, 542, 21);
		lblOutputInformation.setFont(new Font("Aharoni", Font.BOLD, 20));
		panel2.add(lblOutputInformation);
		
		JLabel lblTotalCustomerAverage = new JLabel("Total average time");
		lblTotalCustomerAverage.setBounds(12, 39, 165, 16);
		panel2.add(lblTotalCustomerAverage);
		
		JLabel lblLargestOfNumber = new JLabel("Maximum restaurant queue\r\n");
		lblLargestOfNumber.setBounds(276, 129, 217, 16);
		panel2.add(lblLargestOfNumber);
		
		JLabel lblMaximumCashierQueue = new JLabel("Maximum cashier queue");
		lblMaximumCashierQueue.setBounds(276, 176, 178, 16);
		panel2.add(lblMaximumCashierQueue);
		
		JLabel lblP = new JLabel("Thorughput (total people)");
		lblP.setBounds(276, 39, 153, 16);
		panel2.add(lblP);
		
		JLabel lblPeopleLeftIn = new JLabel("People left in line");
		lblPeopleLeftIn.setBounds(276, 81, 114, 16);
		panel2.add(lblPeopleLeftIn);
		
		JLabel lblAverageTime = new JLabel("Average cashier queue time\r\n");
		lblAverageTime.setBounds(12, 81, 165, 16);
		panel2.add(lblAverageTime);
		
		JLabel lblAverageRestaurantQueue = new JLabel("Average restaurant queue time\r\n");
		lblAverageRestaurantQueue.setBounds(12, 129, 178, 16);
		panel2.add(lblAverageRestaurantQueue);
	}
	
	public void producePerson(){
		int r = rand.nextInt(100);
		
		if( r <= 70 && r >= 79){
			SpecialNeedsPerson SN = new SpecialNeedsPerson();
			chooseEatery(SN);
		}
		if( r <= 80){
			LimitedTimePerson LT = new LimitedTimePerson();
			chooseEatery(LT);
		}
		else{
			RegularPerson RP = new RegularPerson();
			chooseEatery(RP);
		}
	}
	
	public void chooseEatery(Person temp){
		
		int r = rand.nextInt(eateryList.size());
		eateryList.get(r).addToEateryQ(temp);
	}
	
	public void execute(){
		this.restaurantNumber = Integer.parseInt(textField.getText());
		this.avgRestaurantTime = Integer.parseInt(textField_1.getText());
		this.avgCashierTime = Integer.parseInt(textField_2.getText());
		this.simulationTime = Integer.parseInt(textField_3.getText());
		this.newCustomerRate = Integer.parseInt(textField_4.getText());
		this.leaveTime = Integer.parseInt(textField_5.getText());
		
		ActionListener actionListener = new ActionListener() 
		{
			public void actionPerformed(ActionEvent evt) 
			{
				
			}
		};
		
		timer = new Timer(simulationSpeed, actionListener{});
				
	}
}
