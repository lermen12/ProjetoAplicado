package DAO;

import entidades.Chamado;
import entidades.Colaboradores;
import java.util.ArrayList;
import java.util.List;

public class ColaboradoresDAO {
  private static ColaboradoresDAO instance;
  private List<Colaboradores> colaboradoresList = new ArrayList<>();

  public static ColaboradoresDAO getInstance(){
    if (instance == null) instance = new ColaboradoresDAO();
    return instance;
  }

  public void salvar(Colaboradores colaboradores){
    colaboradoresList.add(colaboradores);
  }
  public void atualizar(Colaboradores colaboradores){
    colaboradoresList.set(colaboradores.getId(),colaboradores);
  }
  public void excluir(int idColaboradores){
    colaboradoresList.remove(idColaboradores);
  }
  public List<Colaboradores> listar(){
    return colaboradoresList;
  }

  {

  }
}
