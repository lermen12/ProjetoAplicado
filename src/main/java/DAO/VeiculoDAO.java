package DAO;

import entidades.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class VeiculoDAO {
  private static VeiculoDAO instance;
  private Connection connection = ConnectionUtil.getConnection();

  public static VeiculoDAO getInstance(){
    if (instance == null) instance = new VeiculoDAO();
    return instance;
  }


  public void salvar(Veiculo veiculo){
    try {
      String sql = "insert into veiculo (modelo,ano_de_fab,autonomia) values (?, ?, ?)";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,veiculo.getModelo());
      preparedStatement.setInt(2,veiculo.getAnoDeFabricacao());
      preparedStatement.setDouble(3,veiculo.getAutonomia());
      preparedStatement.execute();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void atualizar(Veiculo veiculo){
    try {
      String sql = "update veiculo set modelo=?,ano_de_fab=?,autonomia=? where id_veiculo=?";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,veiculo.getModelo());
      preparedStatement.setInt(2,veiculo.getAnoDeFabricacao());
      preparedStatement.setDouble(3,veiculo.getAutonomia());
      preparedStatement.setInt(4,veiculo.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void excluir(int idVeiculos){
    try {
      String sql = "delete from veiculo where id_veiculo=?";

      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1,idVeiculos);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public List<Veiculo> listar(){
    List<Veiculo> veiculoList = new ArrayList<>();
    try {
      String sql = "select * from veiculo";
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (resultSet.next()){
       Veiculo veiculo = new Veiculo();
       veiculo.setId(resultSet.getInt("id_veiculo"));
       veiculo.setModelo(resultSet.getString("modelo"));
       veiculo.setAnoDeFabricacao(resultSet.getInt("ano_de_fab"));
       veiculo.setAutonomia(resultSet.getDouble("autonomia"));
       veiculoList.add(veiculo);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return veiculoList;
  }

  {

  }
}
