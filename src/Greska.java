import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Greska extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Greska frame = new Greska();
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
	public Greska() {
		setResizable(false);
		setTitle("Ups!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGrekaUneliSte = new JLabel("Gre\u0161ka!");
		lblGrekaUneliSte.setBounds(101, 11, 275, 14);
		contentPane.add(lblGrekaUneliSte);
		
		JButton btnPokuajPonovo = new JButton("Poku\u0161aj ponovo");
		btnPokuajPonovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);	
			}
		});
		btnPokuajPonovo.setBounds(101, 54, 164, 23);
		contentPane.add(btnPokuajPonovo);
		
		JLabel lblNewLabel = new JLabel("Uneli ste nedozvoljene vrednosti!");
		lblNewLabel.setBounds(101, 29, 275, 14);
		contentPane.add(lblNewLabel);
	}
}
