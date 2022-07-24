package classes;

public class Cliente extends Pessoa{
	private int numConta;

	public Cliente(String nome, String cpf, String endereco, int numConta) {
		super(nome, cpf, endereco);
		this.numConta = numConta;
	}

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
}
