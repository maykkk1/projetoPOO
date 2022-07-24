package classes;

public class Conta {
	int numero;
	Cliente cliente;
	Plano plano;
	
	public Conta(int numero, Cliente cliente, Plano plano) {
		super();
		this.numero = numero;
		this.cliente = cliente;
		this.plano = plano;
	}
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Plano getPlano() {
		return plano;
	}
	public void setPlano(Plano plano) {
		this.plano = plano;
	}
	
}
