package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class SignIn extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JPasswordField pass;
	public static String tid;
	public static String getTid() {
		return tid;
	}

	public static void setTid(String tid) {
		SignIn.tid = tid;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignIn frame = new SignIn();
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
	public SignIn() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 369, 64);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDevelopersInVogue = new JLabel("Developers In Vogue");
		lblDevelopersInVogue.setBounds(26, 11, 316, 37);
		panel.add(lblDevelopersInVogue);
		lblDevelopersInVogue.setForeground(new Color(255, 255, 255));
		lblDevelopersInVogue.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUsername.setBounds(148, 196, 81, 23);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(148, 269, 81, 22);
		contentPane.add(lblPassword);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp su= new SignUp();
				su.setVisible(true);
				dispose();
			}
		});
		lblSignUp.setBounds(10, 613, 46, 14);
		contentPane.add(lblSignUp);
		
		JLabel lblJobOrder = new JLabel("Job Order");
		lblJobOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JobOrder jo=new JobOrder();
				jo.setVisible(true);
				dispose();
			}
		});
		lblJobOrder.setBounds(304, 613, 65, 14);
		contentPane.add(lblJobOrder);
		
		id = new JTextField();
		id.setBounds(98, 220, 177, 30);
		contentPane.add(id);
		id.setColumns(10);
		
		pass = new JPasswordField();
		pass.setBounds(98, 298, 177, 30);
		contentPane.add(pass);
		
		JButton btnSignIn = new JButton("Sign In");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=id.getText().toString();
				String password= pass.getText().toString();
				try{
					String x=check(name,password);
					System.out.println(x);
					if(x.equals("yes")){
						JOptionPane.showMessageDialog(null, "Incorrect Password or User Name");
					}if(x.equals("no")){
						TraineePage su=new TraineePage();
						su.setVisible(true);
						tid=name;
						dispose();	
					}
									
				}catch(Exception e1){
					JOptionPane.showMessageDialog(null, e1);
				}
				
			}
		});
		btnSignIn.setBackground(SystemColor.activeCaption);
		btnSignIn.setBounds(140, 339, 89, 23);
		contentPane.add(btnSignIn);
	}
	
	public ResultSet checkDetails(String user, String pass) throws SQLException{
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
		String query="select id, password from members where id='"+user+"' and password='"+pass+"' and role ='trainee';";
		PreparedStatement pst= conn.prepareStatement(query);
		ResultSet rs=pst.executeQuery();
		return rs;
	}
	
	public String check(String id, String pass){
		Connection conn;
		String isNull = "no";
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="select * from members where id='"+id+"' and password='"+pass+"';" ;
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			if(!rs.next()){
				isNull="yes";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isNull;
	}
	
	public String role(String id){
		Connection conn;
		String position = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="select role from members where id='"+id+"';";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			position=rs.getString(1);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return position;
	}
}
