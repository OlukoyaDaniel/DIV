package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;
	private JTextField fname;
	private JTextField id;
	private JTextField lname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SignUp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		gender.setBounds(119, 413, 130, 20);
		contentPane.add(gender);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name= id.getText().toString();
				String first= fname.getText().toString();
				String last= lname.getText().toString();
				String pass= password.getText().toString();
				String sex= (String) gender.getSelectedItem();
				try{
					insert(name, first, last, pass, sex);
					TraineePage tP= new TraineePage();
					tP.setVisible(true);
					dispose();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		});
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(51, 102, 153));
		btnSignUp.setBounds(140, 458, 89, 23);
		contentPane.add(btnSignUp);
		
		password = new JPasswordField();
		password.setBounds(89, 349, 191, 28);
		contentPane.add(password);
		
		JLabel label = new JLabel("Password");
		label.setFont(new Font("Tahoma", Font.BOLD, 15));
		label.setBounds(144, 322, 81, 22);
		contentPane.add(label);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(89, 232, 191, 28);
		contentPane.add(fname);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirstName.setBounds(140, 208, 89, 23);
		contentPane.add(lblFirstName);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(89, 170, 191, 28);
		contentPane.add(id);
		
		JLabel label_2 = new JLabel("Username");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(144, 136, 81, 23);
		contentPane.add(label_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 369, 64);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("Developers In Vogue");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		label_3.setBounds(26, 11, 316, 37);
		panel.add(label_3);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn su= new SignIn();
				su.setVisible(true);
				dispose();
			}
		});
		lblBack.setBounds(328, 613, 31, 14);
		contentPane.add(lblBack);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(89, 295, 191, 28);
		contentPane.add(lname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(140, 271, 89, 23);
		contentPane.add(lblLastName);
		

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(152, 388, 65, 22);
		contentPane.add(lblGender);
		
	}
	
	public void insert(String id, String fname, String lname, String pass, String gender){
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="insert into members(id, firstname,lastname,password,gender,role) values ('"+id+"','"+fname+"','"+lname+"','"+pass+"','"+gender+"','trainee');" ;
			PreparedStatement pst= conn.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
