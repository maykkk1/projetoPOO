package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.simplilearn.projetoProvedor.Conexao;

import classes.Cliente;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class TelaClientes extends JFrame {

	private JPanel contentPane;
	private JTable table;
	

	public TelaClientes() {
		
		setBounds(100, 100, 669, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 49, 603, 378);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nº Conta", "Nome", "CPF      ", "Endereco      "
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		// Populando tabela
		Conexao con = new Conexao();
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes = con.buscarCliente();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for(Cliente cliente : clientes) {
			model.addRow(new Object [] {cliente.getNumConta(), cliente.getNome(), cliente.getCpf(), cliente.getEndereco()});
		};
	}
}
