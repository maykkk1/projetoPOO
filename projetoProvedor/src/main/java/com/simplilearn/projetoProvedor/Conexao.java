package com.simplilearn.projetoProvedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import classes.Administrador;
import classes.Cliente;
import classes.Conta;
import classes.Plano;

public class Conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	
	public Conexao () {
		this.url = "jdbc:postgresql://localhost:5432/provedor";
		this.usuario = "postgres";
		this.senha = "5591";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int executaSQL(String sql) {
		try {
			Statement stm = con.createStatement();
			int res = stm.executeUpdate(sql);
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}	
	}
	
	public ResultSet executaBusca(String sql) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void criarConta(String nome, String cpf, String end, int plano) {
		String criarCliente = String.format("INSERT INTO cliente values('%s','%s','%s')", cpf, nome, end);
		String criarConta = String.format("INSERT INTO conta values(default, '%s', '%s')", plano , cpf);
		try {
			this.executaSQL(criarCliente);
			this.executaSQL(criarConta);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public ArrayList<Cliente> buscarCliente() {
		ResultSet rs = this.executaBusca("select cl.cpf, cl.nome, cl.endereco, conta_id from cliente as cl\n"
				+ "INNER JOIN conta as co\n"
				+ "ON cl.cpf = co.cliente_cpf");
		ArrayList<Cliente> clientes = new ArrayList<Cliente>(); 
		
		try {
			while(rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				int conta_id = rs.getInt("conta_id");
				
				
				Cliente c = new Cliente(nome, cpf, endereco, conta_id);
				clientes.add(c);	
			}
			
			return clientes;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public ArrayList<Conta> buscarConta() {
		ResultSet buscaEmConta = this.executaBusca("select * from conta");
		ResultSet buscaEmCliente;
		ResultSet buscaEmPlano;
		
		ArrayList<Conta> contas = new ArrayList<Conta>();
		Cliente cliente = null;
		Plano plano = null;
		
		
		try {
			while(buscaEmConta.next()) {
				String numeroConta = String.valueOf(buscaEmConta.getInt("conta_id"));
				String cpfCliente = buscaEmConta.getString("cliente_cpf");
				int planoId = buscaEmConta.getInt("plano_id");
				buscaEmCliente = this.executaBusca(String.format("select cl.cpf, cl.nome, cl.endereco, conta_id from cliente as cl\n"
						+ "INNER JOIN conta as co\n"
						+ "ON cl.cpf = co.cliente_cpf\n"
						+ "WHERE cl.cpf = '%s'", cpfCliente));
				
				buscaEmPlano = this.executaBusca(String.format("select * from plano as p\n"
						+ "where p.plano_id = %s", planoId));
				
				while(buscaEmCliente.next()) {
					String cpf = buscaEmCliente.getString("cpf");
					String nome = buscaEmCliente.getString("nome");
					String endereco = buscaEmCliente.getString("endereco");
					int conta_id = buscaEmCliente.getInt("conta_id");
					cliente = new Cliente(nome, cpf, endereco, conta_id);		
				}
				
				while(buscaEmPlano.next()) {
					String nome = buscaEmPlano.getString("nome");
					double velocidade = buscaEmPlano.getDouble("velocidade");
					double valor = buscaEmPlano.getDouble("valor");
					plano = new Plano(nome, velocidade, valor);
				}

				
				
				Conta c = new Conta(buscaEmConta.getInt("conta_id"), cliente, plano);
				contas.add(c);	
			}
			
			return contas;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Administrador buscarAdministrador () {
		ResultSet rs = this.executaBusca("Select * from administrador");
		Administrador adm = null;
		
		try {
			while(rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String senhaAdm = rs.getString("senha");	
				adm = new Administrador(nome, cpf, endereco, senhaAdm);			
			}
			
			return adm;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	

}
