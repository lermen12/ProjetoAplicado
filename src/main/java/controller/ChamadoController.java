package controller;

import DAO.ChamadoDAO;
import entidades.Chamado;
import java.util.List;

public class ChamadoController {

	public void salvar(Chamado chamado) throws Exception {
		if (chamado.getCliente() == null && chamado.getDistancia() == null)
			throw new Exception("Campos inválidos!");
		ChamadoDAO.getInstance().salvar(chamado);

	}

	public void atualizar(Chamado chamado) throws Exception {
		if (chamado.getCliente() == null && chamado.getDistancia() == null)
			throw new Exception("Campos inválidos!");
		ChamadoDAO.getInstance().atualizar(chamado);

	}

	public void excluir(int idChamado) throws Exception {
		if (idChamado == 0)
			throw new Exception("Nenhum chamado selecionado");
		ChamadoDAO.getInstance().excluir(idChamado);
	}

	public List<Chamado> listar() {
		return ChamadoDAO.getInstance().listar();
	}

	{

	}
}
