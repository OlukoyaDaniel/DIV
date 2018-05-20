package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TraineePage extends JFrame {

	private JPanel contentPane;
	JList<String> list = new JList<String>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TraineePage frame = new TraineePage();
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
	public TraineePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 359, 64);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Developers In Vogue");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(24, 11, 316, 37);
		panel.add(label);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 75, 339, 450);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Class", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel label_1 = new JLabel(" Classes");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(10, 21, 74, 19);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("HTML");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 51, 74, 24);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("CSS");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 86, 74, 24);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("JavaScript");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 121, 74, 24);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("Software Development");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 156, 149, 24);
		panel_2.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(205, 156, 74, 24);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(205, 121, 74, 24);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(205, 86, 74, 24);
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("Trainers");
		label_9.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_9.setBounds(205, 21, 74, 19);
		panel_2.add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(205, 51, 74, 24);
		panel_2.add(label_10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Contract", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 314, 388);
		panel_3.add(scrollPane_1);
		
		JList<String> contracts = new JList<String>();
		contracts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String id=contracts.getSelectedValue();
				DefaultListModel<String> dlm2=teamFill(TeamMates.list,id);
				TeamMates.list.setModel(dlm2);
				TeamMates tm= new TeamMates();
				tm.setVisible(true);
			}
		});
		scrollPane_1.setViewportView(contracts);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Job Order", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 314, 400);
		panel_4.add(scrollPane);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dialogResult = JOptionPane.showConfirmDialog (null, "Add to contract list");
				if(dialogResult == JOptionPane.YES_OPTION){
					String contract=list.getSelectedValue();
					String a=SignIn.getTid();
					addContract(a,contract);
					DefaultListModel<String> dlm1=fill(contracts,a);
					contracts.setModel(dlm1);
				}
				
				
			}
		});
		
		
		scrollPane.setViewportView(list);
		
		JLabel lblNewLabel = new JLabel("Log Out");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn si= new SignIn();
				si.setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setBounds(303, 536, 46, 14);
		contentPane.add(lblNewLabel);
		
		DefaultListModel<String> dlm=fill(list);
		list.setModel(dlm);
	}
	
	public DefaultListModel<String> fill(JList<String> list, String id){
		DefaultListModel<String> dlm= new DefaultListModel<String>();
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="select contractid from contract where id='"+id+"';";
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
	
	public DefaultListModel<String> teamFill(JList<String> list, String id){
		DefaultListModel<String> dlm= new DefaultListModel<String>();
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="select id from contract where contractid='"+id+"';";
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
	
	public void addContract(String id,String contract_id){
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
			String query="insert into contract (id,contractid) values ('"+id+"','"+contract_id+"');" ;
			PreparedStatement pst= conn.prepareStatement(query);
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "You are already working on this");
		}
		
	}	
}
