package view.tabelas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Chamado;

public class ChamadoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COL_CODIGO = 0;
	private static final int COL_CLIENTE = 1;
	private static final int COL_DISTANCIA = 2;
	private static final int COL_COLABORADOR = 3;
	private static final int COL_VEICULO = 4;

	private List<Chamado> valores;

	public ChamadoTableModel(List<Chamado> valores) {
		this.valores = new ArrayList<Chamado>(valores);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Chamado chamado = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			return chamado.getId();
		else if (columnIndex == COL_CLIENTE)
			return chamado.getCliente();
		else if (columnIndex == COL_DISTANCIA)
			return chamado.getDistancia();
		else if (columnIndex == COL_COLABORADOR)
			return chamado.getColaboradores().getId();
		else if (columnIndex == COL_VEICULO)
			return chamado.getVeiculo().getId();
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Chamado chamado = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			chamado.setId(Integer.parseInt(aValue.toString()));
		else if (columnIndex == COL_CLIENTE)
			chamado.setCliente(aValue.toString());
		else if (columnIndex == COL_DISTANCIA)
			chamado.setDistancia(Double.parseDouble(aValue.toString()));
		else if (columnIndex == COL_COLABORADOR)
			chamado.getColaboradores().setId(Integer.parseInt(aValue.toString()));
		else if (columnIndex == COL_VEICULO)
			chamado.getVeiculo().setId(Integer.parseInt(aValue.toString()));

	}

	public String getColumnNameString(int column) {
		if (column == COL_CODIGO)
			return "C??digo";
		if (column == COL_CLIENTE)
			return "Cliente";		
		if (column == COL_DISTANCIA)
			return "Dist??ncia";
		if (column == COL_COLABORADOR)
			return "Colaborador";
		if (column == COL_VEICULO)
			return "Ve??culo";
		return "";

	}

	public Chamado get(int row) {
		return valores.get(row);
	}

}
