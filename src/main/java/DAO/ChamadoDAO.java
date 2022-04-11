package DAO;

import entidades.Chamado;
import entidades.Colaboradores;
import entidades.Veiculo;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class ChamadoDAO {
	private static ChamadoDAO instance;
	private Connection connection = ConnectionUtil.getConnection();

	public static ChamadoDAO getInstance() {
		if (instance == null)
			instance = new ChamadoDAO();
		return instance;
	}

	public void salvar(Chamado chamado) {
		try {
			String sql = "insert into chamada (data, cliente,endereco, distancia,colaborador_id_colaborador,veiculo_id_veiculo) values (?, ?, ?, ?, ? ,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1,  new Date(chamado.getData().getTime()));
			preparedStatement.setString(2, chamado.getCliente());
			preparedStatement.setString(3, chamado.getEndereco());
			preparedStatement.setDouble(4, chamado.getDistancia());
			preparedStatement.setInt(5, chamado.getColaboradores().getId());
			preparedStatement.setInt(6, chamado.getVeiculo().getId());
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Chamado chamado) {
		try {
			String sql = "update chamada set  data = ?, cliente=?,endereco=?, distancia,colaborador_id_colaborador=?,veiculo_id_veiculo=? where id_chamado=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setDate(1,  new Date(chamado.getData().getTime()));
			preparedStatement.setString(2, chamado.getCliente());
			preparedStatement.setString(3, chamado.getEndereco());
			preparedStatement.setDouble(4, chamado.getDistancia());
			preparedStatement.setInt(5, chamado.getColaboradores().getId());
			preparedStatement.setInt(6, chamado.getVeiculo().getId());
			preparedStatement.setInt(7, chamado.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void excluir(int idChamado) {
		try {
			String sql = "delete from chamada where id_chamado=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idChamado);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Chamado> listar() {
		List<Chamado> chamadoList = new ArrayList<>();
		try {
			String sql = "select * from chamada";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				Chamado chamado = new Chamado();
				chamado.setId(resultSet.getInt("id_chamado"));
				chamado.setData(resultSet.getDate("data"));
				chamado.setCliente(resultSet.getString("cliente"));
				chamado.setEndereco(resultSet.getString("endereco"));
				chamado.setDistancia(resultSet.getDouble("distancia"));
				chamado.setColaboradores(new Colaboradores());
				chamado.getColaboradores().setId(resultSet.getInt("colaborador_id_colaborador"));
				chamado.setVeiculo(new Veiculo());
				chamado.getVeiculo().setId(resultSet.getInt("veiculo_id_veiculo"));
				chamadoList.add(chamado);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chamadoList;
	}

	{

	}
}
