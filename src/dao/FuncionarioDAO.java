package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import model.Funcionario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class FuncionarioDAO implements IConst, IFuncionario {
	private String sql;
	private Connection conn;
	private PreparedStatement stmt;

	private void open() throws SQLException {
		conn = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
	}

	private void close() throws SQLException {
		conn.close();
	}

	@Override
	public void inserir(Funcionario funcionario) throws SQLException {
		// TODO Auto-generated method stub
		open();
		
		close();
		
	}

	@Override
	public void remover(Funcionario funcionario) throws SQLException {
		// TODO Auto-generated method stub
		open();
		sql = "SELECT * FROM funcionario WHERE codfuncionario = ?";
		stmt = this.conn.prepareStatement(sql);
		stmt.setInt(1, funcionario.getId());
		ResultSet result = stmt.executeQuery();
		if(result.next()) {
			Alert alerta = new Alert(AlertType.INFORMATION);
			alerta.setContentText("Usuario removido com sucesso!");
			alerta.setTitle("Sucesso");
			alerta.setHeaderText("Mensagem de Sucesso");
			sql = "DELETE FROM funcionario WHERE codfuncionario = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, funcionario.getId());
			stmt.executeUpdate();
			alerta.showAndWait();
		} else {
			Alert alerta = new Alert(AlertType.ERROR);
			alerta.setContentText("Usuario nao existe!");
			alerta.setTitle("ERRO");
			alerta.setHeaderText("Mensagem de ERRO");
			alerta.showAndWait();
		}
		close();
		
	}

	@Override
	public void atualizar(int id, Funcionario funcionario) throws SQLException {
		// TODO Auto-generated method stub
		sql = "UPDATE funcionario SET nome = ?, endereco = ?, siglaestado = ?, codcidade=? WHERE codfuncionario = ?";
		open();
		
		close();
		
	}

	@Override
	public ObservableList<Funcionario> listarFuncionarios() throws SQLException {
		// TODO Auto-generated method stub
		ObservableList<Funcionario> listaFunc = FXCollections.observableArrayList();
		open();
		close();
		return listaFunc;
	
		
	}

	@Override
	public Funcionario dadosFuncionario(int codFuncionario) throws SQLException {
		open();
		sql = "SELECT * FROM funcionario WHERE codfuncionario = ?";
		stmt = this.conn.prepareStatement(sql);
		stmt.setInt(1, codFuncionario);
		return new Funcionario("Fodase", "Fodase", "FODASE");
	}

}
