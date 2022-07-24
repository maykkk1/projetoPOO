package classes;

public class Plano {
	String nome;
	double velocidade;
	double valor;
	
	
	public Plano(String nome, double velocidade, double valor) {
		super();
		this.nome = nome;
		this.velocidade = velocidade;
		this.valor = valor;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(double velocidade) {
		this.velocidade = velocidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
