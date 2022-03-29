package DAO;

import entidades.Chamado;
import entidades.Colaboradores;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.ConnectionUtil;

public class ColaboradoresDAO {
  private static ColaboradoresDAO instance;
  private List<Colaboradores> colaboradoresList = new ArrayList<>();
  private Connection connection = ConnectionUtil.getConnection();


  public static ColaboradoresDAO getInstance(){
    if (instance == null) instance = new ColaboradoresDAO();
    return instance;
  }

  public void salvar(Colaboradores colaboradores) {
   try {
     String sql = "insert into colaborador (nome,habilitado,email,telefone) values (?, ?, ?, ?)";

     PreparedStatement preparedStatement = connection.prepareStatement(sql);
     preparedStatement.setString(1, colaboradores.getNome());
     preparedStatement.setString(2, colaboradores.getHabilitado());
     preparedStatement.setString(3, colaboradores.getEmail());
     preparedStatement.setString(4, colaboradores.getTelefone());
     preparedStatement.execute();
   } catch (SQLException e) {
     e.printStackTrace();
   }
  }
  public void atualizar(Colaboradores colaboradores){
    try {
      String sql = "update colaborador set  nome=?,habilitado=?,email=?,telefone=? where id_coloborador=?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setString(1,colaboradores.getNome());
      preparedStatement.setString(2,colaboradores.getHabilitado());
      preparedStatement.setString(3,colaboradores.getEmail());
      preparedStatement.setString(4,colaboradores.getTelefone());
      preparedStatement.setInt(5,colaboradores.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public void excluir(int idColaboradores){
    try {
      String sql = "delete from colaborador where id_colaborador=?";
      PreparedStatement preparedStatement = connection.prepareStatement(sql);
      preparedStatement.setInt(1, idColaboradores);
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
  public List<Colaboradores> listar(){
    List<Colaboradores> colaboradoresList = new ArrayList<>();
    try {
      String sql = "select * from colaborador";
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      while (resultSet.next()){
        Colaboradores colaboradores = new Colaboradores();
        colaboradores.setId(resultSet.getInt("id_colaborador"));
        colaboradores.setNome(resultSet.getString("nome"));
        colaboradores.setHabilitado(resultSet.getString("habilitado"));
        colaboradores.setEmail(resultSet.getString("email"));
        colaboradores.setTelefone(resultSet.getString("telefone"));
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
