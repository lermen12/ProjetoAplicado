package controller;

import DAO.ColaboradoresDAO;
import entidades.Colaboradores;
import java.util.List;

public class ColaboradoresController {

	public void salvar(Colaboradores colaboradores) throws Exception {
		if (colaboradores.getNome() == null && colaboradores.getTelefone().length() != 11)
			throw new Exception("Dados inválidos!");
		ColaboradoresDAO.getInstance().salvar(colaboradores);
	}

	public void atualizar(Colaboradores colaboradores) throws Exception {
		if (colaboradores.getNome() == null && colaboradores.getTelefone().length() != 11)
			throw new Exception("Dados inválidos!");
		ColaboradoresDAO.getInstance().atualizar(colaboradores);
	}

	public void excluir(int idColaboradores) throws Exception {
		if (idColaboradores == 0)
			throw new Exception("Nenhum chamado selecionado");
		ColaboradoresDAO.getInstance().excluir(idColaboradores);
	}

	public List<Colaboradores> listar() {
		return ColaboradoresDAO.getInstance().listar();
	}

	{

	}
}
