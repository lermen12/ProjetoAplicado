import entidades.Chamado;
import entidades.Colaboradores;
import entidades.Veiculo;
import java.util.Date;

public class Application {

  public static void main(String[] args) {

    Veiculo veiculo = new Veiculo("Gol",2015, 16.5);
    Colaboradores colaboradores = new Colaboradores("Carlos", true,"carlos@hotmail.com","48999991215");
    Chamado chamado = new Chamado(new Date(), "Roberto", "rua do cao",150.00,colaboradores,veiculo);

    System.out.print("Valor total do C02: ");
    System.out.println( String.format("%.2f", chamado.valorTotal()));

  }

}
