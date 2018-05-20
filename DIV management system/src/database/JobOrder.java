package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JobOrder extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField email;
	private JTextField contractor;
	private JTextField id;
	
	public static String sid;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobOrder frame = new JobOrder();
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
	public JobOrder() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox type = new JComboBox();
		type.setModel(new DefaultComboBoxModel(new String[] {"Website Development", "Software Development"}));
		type.setBounds(126, 358, 135, 20);
		contentPane.add(type);
		
		JLabel lblContractName = new JLabel("Contract Name");
		lblContractName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContractName.setBounds(124, 157, 120, 23);
		contentPane.add(lblContractName);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(88, 175, 191, 28);
		contentPane.add(name);
		
		JLabel lblContractorEmail = new JLabel("Contractor E-mail");
		lblContractorEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContractorEmail.setBounds(126, 214, 135, 23);
		contentPane.add(lblContractorEmail);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(88, 238, 191, 28);
		contentPane.add(email);
		
		JLabel lblContractorName = new JLabel("Contractor Name");
		lblContractorName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContractorName.setBounds(126, 271, 135, 22);
		contentPane.add(lblContractorName);
		
		contractor = new JTextField();
		contractor.setColumns(10);
		contractor.setBounds(88, 294, 191, 28);
		contentPane.add(contractor);
		
		JLabel lblContractType = new JLabel("Contract Type");
		lblContractType.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContractType.setBounds(138, 333, 110, 20);
		contentPane.add(lblContractType);
		
		JLabel lblBack = new JLabel("Back");
		lblBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn si = new SignIn();
				si.setVisible(true);
				dispose();
			}
		});
		lblBack.setBounds(326, 613, 33, 14);
		contentPane.add(lblBack);
		
		JButton btnOrder = new JButton("Order");
		btnOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cid,  cname,  contractorName,  cpass,  ctype,  cemail;
				cid= id.getText().toString(); cname= name.getText().toString(); contractorName = contractor.getText().toString();
				cpass= "customer"; ctype=type.getSelectedItem().toString(); cemail= email.getText().toString();
				sid=cid;
				insert(cid,  cname,  contractorName,  cpass,  ctype,  cemail);
						
				CostPage cp=new CostPage();
				cp.setVisible(true);
				dispose();
			}
		});
		btnOrder.setBounds(153, 418, 80, 23);
		contentPane.add(btnOrder);
		
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
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(88, 126, 191, 28);
		contentPane.add(id);
		
		JLabel lblContractId = new JLabel("Contract ID");
		lblContractId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblContractId.setBounds(141, 104, 120, 23);
		contentPane.add(lblContractId);
	}


	public void insert(String id, String name, String contractor, String password, String type, String email){
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="insert into customers (id,name,contractor,password,type,email) values ('"+id+"','"+name+"','"+contractor+"','"+password+"','"+type+"','"+email+"');" ;
			PreparedStatement pst= conn.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	public DefaultListModel<String> fill(JList<String> list){
		DefaultListModel<String> dlm= new DefaultListModel<String>();
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="select id from customers;";
			PreparedStatement pst= conn.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()){
				dlm.addElement(rs.getString(1));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dlm;
	}
	
	public static String getSid() {
		return sid;
	}
	
	public void setSid(String sid) {
		this.sid = sid;
	}

}
