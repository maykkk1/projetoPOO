package classes;

public class Administrador extends Pessoa{
	String senha;

	public Administrador(String nome, String cpf, String endereco, String senha) {
		super(nome, cpf, endereco);
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

