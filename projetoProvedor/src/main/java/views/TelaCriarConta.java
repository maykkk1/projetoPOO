package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.simplilearn.projetoProvedor.Conexao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCriarConta extends JFrame {

	private JPanel contentPane;
	private JTextField nameTextField;
	private JTextField cpfTextField;
	private JTextField enderecoTextField;
	
	
	//criando  conexao
	Conexao con = new Conexao();
	
	// Cria os radio buttons
	JRadioButton rdbtnPlanoBronze;
	JRadioButton rdbtnPlanoSilver;
	JRadioButton rdbtnPlanoGold;
	
	// O radio já vem marcado como bronze
	int planoEscolhido = 1;

	public TelaCriarConta() {
		setBounds(100, 100, 483, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(10, 82, 127, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpf.setBounds(10, 124, 127, 31);
		contentPane.add(lblCpf);
		
		JLabel lblEndereo = new JLabel("Endere\u00E7o");
		lblEndereo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEndereo.setBounds(10, 166, 127, 31);
		contentPane.add(lblEndereo);
		
		JLabel lblNewLabel_1 = new JLabel("Criar conta");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(109, 11, 214, 38);
		contentPane.add(lblNewLabel_1);
		
		nameTextField = new JTextField();
		nameTextField.setBounds(125, 82, 308, 31);
		contentPane.add(nameTextField);
		nameTextField.setColumns(10);
		
		cpfTextField = new JTextField();
		cpfTextField.setColumns(10);
		cpfTextField.setBounds(125, 124, 308, 31);
		contentPane.add(cpfTextField);
		
		enderecoTextField = new JTextField();
		enderecoTextField.setColumns(10);
		enderecoTextField.setBounds(125, 166, 308, 31);
		contentPane.add(enderecoTextField);
		
		rdbtnPlanoBronze = new JRadioButton("Plano Bronze");
		rdbtnPlanoBronze.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planoEscolhido = 1;
			}
		});
		rdbtnPlanoBronze.setSelected(true);
		rdbtnPlanoBronze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPlanoBronze.setBounds(10, 228, 149, 23);
		contentPane.add(rdbtnPlanoBronze);
		
		rdbtnPlanoSilver = new JRadioButton("Plano Silver");
		rdbtnPlanoSilver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planoEscolhido = 2;
			}
		});
		rdbtnPlanoSilver.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPlanoSilver.setBounds(10, 254, 149, 23);
		contentPane.add(rdbtnPlanoSilver);
		
		rdbtnPlanoGold = new JRadioButton("Plano Gold");
		rdbtnPlanoGold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planoEscolhido = 3;
			}
		});
		rdbtnPlanoGold.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnPlanoGold.setBounds(10, 280, 149, 23);
		contentPane.add(rdbtnPlanoGold);
		
		ButtonGroup group = new ButtonGroup();
		group.add(rdbtnPlanoBronze);
		group.add(rdbtnPlanoSilver);
		group.add(rdbtnPlanoGold);
		
		JButton btnNewButton = new JButton("CRIAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(enderecoTextField.getText().isEmpty() || cpfTextField.getText().isEmpty() || nameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos!");
				} else {
					String nome = nameTextField.getText();
					String cpf = cpfTextField.getText();
					String endereco = enderecoTextField.getText();
					
					
					con.criarConta(nome, cpf, endereco, planoEscolhido);
					
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(163, 356, 139, 38);
		contentPane.add(btnNewButton);
	}
}
