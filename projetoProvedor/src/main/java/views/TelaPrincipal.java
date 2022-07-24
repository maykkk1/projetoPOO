package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;


	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Listar contas");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaContas telaC = new TelaContas();
				telaC.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(10, 111, 132, 53);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("GATONET");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(119, 11, 232, 65);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1_1 = new JButton("Listar clientes");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaClientes telaClientes = new TelaClientes();
				telaClientes.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1_1.setBounds(342, 111, 132, 53);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2 = new JButton("Nova conta");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCriarConta tela = new TelaCriarConta();
				tela.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(170, 111, 149, 53);
		contentPane.add(btnNewButton_2);
	}
}
