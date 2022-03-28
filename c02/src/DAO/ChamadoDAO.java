package DAO;

import entidades.Chamado;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
  private static ChamadoDAO instance;
  private List<Chamado> chamadoList = new ArrayList<>();

  public static ChamadoDAO getInstance(){
    if (instance == null) instance = new ChamadoDAO();
    return instance;
  }

  public void salvar(Chamado chamado){
    chamadoList.add(chamado);
  }
  public void atualizar(Chamado chamado){
    chamadoList.set(chamado.getId(),chamado);
  }
  public void excluir(int idChamado){
    chamadoList.remove(idChamado);
  }
  public List<Chamado> listar(){
    return chamadoList;
  }

  {

  }
}
