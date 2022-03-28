package DAO;

import entidades.Colaboradores;
import entidades.Veiculo;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDAO {
  private static VeiculoDAO instance;
  private List<Veiculo> veiculoList = new ArrayList<>();

  public static VeiculoDAO getInstance(){
    if (instance == null) instance = new VeiculoDAO();
    return instance;
  }


  public void salvar(Veiculo veiculo){
    veiculoList.add(veiculo);
  }
  public void atualizar(Veiculo veiculo){
    veiculoList.set(veiculo.getId(),veiculo);
  }
  public void excluir(int idVeiculos){
    veiculoList.remove(idVeiculos);
  }
  public List<Veiculo> listar(){
    return veiculoList;
  }

  {

  }
}
