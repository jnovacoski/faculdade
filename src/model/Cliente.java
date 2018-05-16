package model;

public class Cliente extends Pessoa{

	public Cliente(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
		this.setTipo('C');
		// TODO Auto-generated constructor stub
	}

}
