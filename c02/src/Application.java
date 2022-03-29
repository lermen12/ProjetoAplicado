import controller.VeiculoController;
import entidades.Chamado;
import entidades.Colaboradores;
import entidades.Veiculo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import util.ConnectionUtil;

public class Application {

  public static void main(String[] args) throws SQLException {

    Connection connection = ConnectionUtil.getConnection();
    Statement statement = connection.createStatement();
    String sql = "select * from veiculo";
    ResultSet resultSet = statement.executeQuery(sql);
    while (resultSet.next()){
      System.out.println(resultSet.getString("modelo"));
    }

//    Veiculo veiculo = new Veiculo("Gol",2015, 16.5);
//    Veiculo veiculo1 = new Veiculo("Palio",2010,14.5);
//    Veiculo veiculo2 = new Veiculo("Ford",2018,12.0);
//    /*Colaboradores colaboradores = new Colaboradores("Carlos", true,"carlos@hotmail.com","48999991215");
//    Chamado chamado = new Chamado(new Date(), "Roberto", "rua do cao",150.00,colaboradores,veiculo);
//
//    System.out.print("Valor total do C02: ");
//    System.out.println( String.format("%.2f", chamado.valorTotal()));*/
//
//    VeiculoController veiculoController = new VeiculoController();
//
//    try {
//      veiculoController.salvar(veiculo);
//      veiculoController.salvar(veiculo1);
//      veiculoController.salvar(veiculo2);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());;
//    }
//    for (Veiculo v: veiculoController.listar()) {
//      System.out.println(v.toString());
//    }
//    System.out.println("--------------------------------------------------------");
//
//    try {
//      veiculoController.excluir(1);
//    } catch (Exception e) {
//      System.out.println(e.getMessage());;
//    }
//    for (Veiculo v: veiculoController.listar()) {
//      System.out.println(v.toString());
//    }
 }
}
