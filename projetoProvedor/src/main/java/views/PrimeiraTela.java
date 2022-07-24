package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import com.simplilearn.projetoProvedor.Conexao;

import classes.Administrador;

import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PrimeiraTela {

	private JFrame frame;
	private JTextField admTextField;
	private JTextField senhaTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrimeiraTela window = new PrimeiraTela();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Conexao con = new Conexao();
	
	Administrador adm = con.buscarAdministrador();

	/**
	 * Create the application.
	 */
	public PrimeiraTela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(20, 160, 68, 37);
		frame.getContentPane().add(lblNewLabel_1);
		
		admTextField = new JTextField();
		admTextField.setBounds(86, 165, 327, 34);
		frame.getContentPane().add(admTextField);
		admTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(20, 219, 68, 37);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		senhaTextField = new JTextField();
		senhaTextField.setColumns(10);
		senhaTextField.setBounds(86, 224, 327, 34);
		frame.getContentPane().add(senhaTextField);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = admTextField.getText();
				String senha = senhaTextField.getText();
				
				
				if(!adm.getNome().equals(nome) || !adm.getSenha().equals(senha)) {
					JOptionPane.showMessageDialog(null, "Senha incorreta");
				} else {
					
					try {
						TelaPrincipal telaPrincipal = new TelaPrincipal();
						telaPrincipal.setVisible(true);
						JComponent comp = (JComponent) e.getSource();
						Window win = SwingUtilities.getWindowAncestor(comp);
						win.dispose();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(156, 294, 137, 49);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("SISTEMA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(158, 38, 180, 49);
		frame.getContentPane().add(lblNewLabel);
	}
}
