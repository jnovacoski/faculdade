package dao;

import java.sql.SQLException;

import javafx.collections.ObservableList;
import model.Funcionario;
public interface IFuncionario {
	public void inserir(Funcionario funcionario) throws SQLException;
	public void remover(Funcionario funcionario) throws SQLException;
	public void atualizar(int id, Funcionario funcionario) throws SQLException;
	public ObservableList<Funcionario> listarFuncionarios() throws SQLException;
	public Funcionario dadosFuncionario(int codFuncionario) throws SQLException;

	//public void update(Estudante estudante) throws SQLException;
}