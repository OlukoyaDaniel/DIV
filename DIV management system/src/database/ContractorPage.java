package database;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContractorPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContractorPage frame = new ContractorPage();
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
	public ContractorPage() {
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
		tabbedPane.setBounds(10, 75, 339, 456);
		contentPane.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Progress", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblContractName = new JLabel("Contract Name: ");
		lblContractName.setBounds(27, 82, 94, 14);
		panel_1.add(lblContractName);
		
		JLabel lblDateStarted = new JLabel("Date Started: ");
		lblDateStarted.setBounds(27, 107, 94, 14);
		panel_1.add(lblDateStarted);
		
		JLabel lblCompleted = new JLabel("Completed: ");
		lblCompleted.setBounds(27, 133, 94, 14);
		panel_1.add(lblCompleted);
		
		JLabel lblDateEnded = new JLabel("Date Ended: ");
		lblDateEnded.setBounds(27, 158, 94, 14);
		panel_1.add(lblDateEnded);
		
		JLabel contactID = new JLabel("ContractID");
		contactID.setFont(new Font("Tahoma", Font.BOLD, 15));
		contactID.setBounds(111, 57, 112, 14);
		panel_1.add(contactID);
		
		JLabel lblA = new JLabel("");
		lblA.setBounds(183, 133, 94, 14);
		panel_1.add(lblA);
		
		JLabel lblA_1 = new JLabel("");
		lblA_1.setBounds(183, 158, 94, 14);
		panel_1.add(lblA_1);
		
		JLabel lblA_2 = new JLabel("");
		lblA_2.setBounds(183, 107, 94, 14);
		panel_1.add(lblA_2);
		
		JLabel lblA_3 = new JLabel("");
		lblA_3.setBounds(183, 82, 94, 14);
		panel_1.add(lblA_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Team Working", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 314, 261);
		panel_2.add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Contact Us", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Telephone No.");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(92, 59, 150, 25);
		panel_3.add(lblNewLabel);
		
		JLabel lblHotlineno = new JLabel("Hotline No.");
		lblHotlineno.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHotlineno.setBounds(110, 151, 120, 25);
		panel_3.add(lblHotlineno);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(125, 242, 100, 25);
		panel_3.add(lblAddress);
		
		JLabel label_1 = new JLabel("Log Out");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignIn si= new SignIn();
				si.setVisible(true);
				dispose();
			}
		});
		label_1.setBounds(303, 542, 46, 14);
		contentPane.add(label_1);
	}
}
