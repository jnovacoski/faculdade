package model;

public class Funcionario extends Pessoa{

	public Funcionario(String nome, String endereco, String telefone) {
		super(nome, endereco, telefone);
		this.setTipo('F');
		// TODO Auto-generated constructor stub
	}
	
}
