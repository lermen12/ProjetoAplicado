package controller;

import DAO.VeiculoDAO;
import entidades.Chamado;
import entidades.Veiculo;
import java.util.List;

public class VeiculoController {

  public void salvar(Veiculo veiculo) throws Exception {
    if (veiculo.getAnoDeFabricacao() == 0|| (veiculo.getAutonomia() == null) || (veiculo.getModelo() == null)) throw new Exception("Dados Inválidos!");
    VeiculoDAO.getInstance().salvar(veiculo);
  }
  public void atualizar(Veiculo veiculo) throws Exception {
    if (veiculo.getAnoDeFabricacao() == 0|| (veiculo.getAutonomia() == null) || (veiculo.getModelo() == null)) throw new Exception("Dados Inválidos!");
    VeiculoDAO.getInstance().atualizar(veiculo);

  }
  public void excluir(int idVeiculos) throws Exception {
    if (idVeiculos == 0) throw new Exception("Nenhum chamado selecionado");
    VeiculoDAO.getInstance().excluir(idVeiculos);

  }
  public List<Veiculo> listar(){
    return VeiculoDAO.getInstance().listar();
  }

  {

  }
}
