package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class TeamMates extends JFrame {
	static JList list = new JList();
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeamMates frame = new TeamMates();
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
	public TeamMates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 58, 414, 192);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(list);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 55);
		panel.setLayout(null);
		panel.setBackground(new Color(51, 102, 153));
		contentPane.add(panel);
		
		JLabel lblTeam = new JLabel("Team");
		lblTeam.setForeground(Color.WHITE);
		lblTeam.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTeam.setBounds(171, 11, 91, 37);
		panel.add(lblTeam);
	}
}
