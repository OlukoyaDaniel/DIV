package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContractInfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractInfo frame = new ContractInfo();
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
	public ContractInfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 600);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ContractorPage cp= new ContractorPage();
				cp.setVisible(true);
				dispose();
			}
		});
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYourContractidIs = new JLabel("Your Contract ID is :");
		lblYourContractidIs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourContractidIs.setBounds(97, 206, 164, 14);
		contentPane.add(lblYourContractidIs);
		
		JLabel lblYourPasswordIs = new JLabel("Your Password is:");
		lblYourPasswordIs.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourPasswordIs.setBounds(107, 308, 145, 14);
		contentPane.add(lblYourPasswordIs);
		
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
		
		JLabel lblYouCanUse = new JLabel("You can use this to check the progress of your contract");
		lblYouCanUse.setBounds(45, 536, 282, 14);
		contentPane.add(lblYouCanUse);
		
		JLabel lblKdfn = new JLabel("");
		lblKdfn.setFont(new Font("Tahoma", Font.BOLD, 85));
		lblKdfn.setBounds(91, 221, 236, 76);
		contentPane.add(lblKdfn);
		
		JLabel label_1 = new JLabel("");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 85));
		label_1.setBounds(91, 325, 236, 84);
		contentPane.add(label_1);
	}
	
	
}
