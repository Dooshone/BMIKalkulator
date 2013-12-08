import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.text.DecimalFormat;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtTezina;
	private JTextField txtVisina;
	private JTextField txtBMI;
	private JTextField txtGrupa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setTitle("BMI Kalkulator");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUnesiteVauTeinu = new JLabel("Unesite Va\u0161u te\u017Einu (kg):");
		lblUnesiteVauTeinu.setBounds(40, 64, 173, 26);
		contentPane.add(lblUnesiteVauTeinu);
		
		txtTezina = new JTextField();
		txtTezina.setText(" ");
		txtTezina.setBounds(223, 70, 116, 20);
		contentPane.add(txtTezina);
		txtTezina.setColumns(1);
		
		JLabel lblUnesiteVauVisinu = new JLabel("Unesite Va\u0161u visinu (cm):");
		lblUnesiteVauVisinu.setBounds(40, 26, 173, 14);
		contentPane.add(lblUnesiteVauVisinu);
		
		txtVisina = new JTextField();
		txtVisina.setText(" ");
		txtVisina.setBounds(223, 26, 116, 20);
		contentPane.add(txtVisina);
		txtVisina.setColumns(1);
		
		JButton btnIzracunajBmi = new JButton("Izracunaj BMI");
		btnIzracunajBmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Kalkulator k = new Kalkulator();
				String v = txtVisina.getText();
				String t = txtTezina.getText();
				
				if (v == " " || t == " " || v == "" || t == ""){
					Greska g = new Greska();
	            	g.setVisible(true);
	            	txtVisina.setText("");
	            	txtTezina.setText("");
				}else{
					double visina = Double.parseDouble(txtVisina.getText());
					double tezina = Double.parseDouble(txtTezina.getText());
				
					double bmi = k.izracunajBMI(visina, tezina);
				
					DecimalFormat d = new DecimalFormat("#.##");
					String s = d.format(bmi);
				
				
	            
					if ((visina<150 || visina>215 || tezina<35 || tezina>300)){
						Greska g = new Greska();
						g.setVisible(true);
						txtVisina.setText("");
						txtTezina.setText("");
						txtBMI.setText("");
						txtGrupa.setText("");
						
					} else {
						if (bmi <= 18.5) {
	            		txtGrupa.setText("mršavih ljudi.");
	            		txtBMI.setText(""+s);
						}
						if (bmi > 18.5 && bmi <= 24.9) {
							txtGrupa.setText("ljudi normalne težine.");
							txtBMI.setText(""+s);
						}
						if (bmi > 24.9 && bmi <= 29.9) {
							txtGrupa.setText("ljudi prekomerne težine.");
							txtBMI.setText(""+s);
						}
						if (bmi > 29.9) {
							txtGrupa.setText("izuzetno gojaznih ljudi.");
							txtBMI.setText(""+s);
						}
					}
				}
				
				
				
			}
		});
		btnIzracunajBmi.setBounds(139, 121, 116, 23);
		contentPane.add(btnIzracunajBmi);
		
		JLabel lblVaBmiIznosi = new JLabel("Va\u0161 BMI iznosi:");
		lblVaBmiIznosi.setBounds(40, 167, 88, 14);
		contentPane.add(lblVaBmiIznosi);
		
		txtBMI = new JTextField();
		txtBMI.setEditable(false);
		txtBMI.setBounds(169, 164, 170, 20);
		contentPane.add(txtBMI);
		txtBMI.setColumns(10);
		
		JLabel lblISpadateU = new JLabel("Vi spadate u grupu");
		lblISpadateU.setBounds(40, 206, 119, 14);
		contentPane.add(lblISpadateU);
		
		txtGrupa = new JTextField();
		txtGrupa.setEditable(false);
		txtGrupa.setBounds(169, 203, 170, 20);
		contentPane.add(txtGrupa);
		txtGrupa.setColumns(10);
	}
}
