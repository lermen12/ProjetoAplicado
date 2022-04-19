package DAO;

import entidades.Colaboradores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class ColaboradoresDAO {
	private static ColaboradoresDAO instance;
	private Connection connection = ConnectionUtil.getConnection();

	public static ColaboradoresDAO getInstance() {
		if (instance == null)
			instance = new ColaboradoresDAO();
		return instance;
	}

	public void salvar(Colaboradores colaboradores) {
		try {
			String sql = "insert into colaborador (nome,habilitado,email) values (?, ?, ?)";

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, colaboradores.getNome());
			preparedStatement.setBoolean(2, colaboradores.getHabilitado());
			preparedStatement.setString(3, colaboradores.getEmail());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Colaboradores colaboradores) {
		try {
			String sql = "update colaborador set  nome=?,habilitado=?,email=? where id_colaborador=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, colaboradores.getNome());
			preparedStatement.setBoolean(2, colaboradores.getHabilitado());
			preparedStatement.setString(3, colaboradores.getEmail());
			preparedStatement.setInt(4, colaboradores.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int idColaboradores) {
		try {
			String sql = "delete from colaborador where id_colaborador=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idColaboradores);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Colaboradores> listar() {
		List<Colaboradores> colaboradoresList = new ArrayList<>();
		try {
			String sql = "select * from colaborador";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Colaboradores colaboradores = new Colaboradores();
				colaboradores.setId(resultSet.getInt("id_colaborador"));
				colaboradores.setNome(resultSet.getString("nome"));
				colaboradores.setHabilitado(resultSet.getBoolean("habilitado"));
				colaboradores.setEmail(resultSet.getString("email"));
				colaboradoresList.add(colaboradores);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return colaboradoresList;
	}

	{
	}
}
