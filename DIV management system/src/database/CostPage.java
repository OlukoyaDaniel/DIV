package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CostPage extends JFrame {

	private JPanel contentPane;
	String cid,  cname,  contractorName,  cpass,  ctype,  cemail;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostPage frame = new CostPage();
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
	public CostPage() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 667);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 153));
		panel.setBounds(0, 0, 369, 64);
		contentPane.add(panel);
		
		JLabel label = new JLabel("Developers In Vogue");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(26, 11, 316, 37);
		panel.add(label);
		
		JLabel lblThisWouldCost = new JLabel("This would cost:");
		lblThisWouldCost.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThisWouldCost.setBounds(124, 261, 141, 14);
		contentPane.add(lblThisWouldCost);
		
		JLabel lblGhanaCedis = new JLabel("Ghana Cedis");
		lblGhanaCedis.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGhanaCedis.setBounds(138, 398, 108, 14);
		contentPane.add(lblGhanaCedis);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContractInfo ci= new ContractInfo();
				ci.setVisible(true);
				dispose();
			}
		});
		btnProceed.setBounds(140, 478, 89, 23);
		contentPane.add(btnProceed);
		
		JLabel cancelLabel = new JLabel("Cancel");
		cancelLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					delete(JobOrder.getSid());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SignIn si= new SignIn();
				si.setVisible(true);
				dispose();
			}
		});
		cancelLabel.setBounds(165, 512, 39, 14);
		contentPane.add(cancelLabel);
		
		JLabel backLabel = new JLabel("Back");
		backLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JobOrder jo= new JobOrder();
				jo.setVisible(true);
				dispose();
			}
		});
		backLabel.setBounds(330, 613, 39, 14);
		contentPane.add(backLabel);
		
		JLabel costLabel = new JLabel("1000");
		costLabel.setFont(new Font("Tahoma", Font.BOLD, 99));
		costLabel.setBackground(new Color(240, 240, 240));
		costLabel.setBounds(44, 275, 279, 122);
		contentPane.add(costLabel);
	}
	
	public void delete(String id) throws SQLException{
		Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/vogue","root", "");
		String query="delete from customers where id='"+id+"' or id=null;";
		PreparedStatement pst= conn.prepareStatement(query);
		pst.executeUpdate();
	}
	
		
}
