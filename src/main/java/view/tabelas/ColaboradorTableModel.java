package view.tabelas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import entidades.Colaboradores;

public class ColaboradorTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COL_CODIGO = 0;
	private static final int COL_NOME = 1;
	private static final int COL_HABILITADO = 2;
	private static final int COL_EMAIL = 3;

	private List<Colaboradores> valoresColaboradores;

	public ColaboradorTableModel(List<Colaboradores> valoresColaboradores) {
		this.valoresColaboradores = new ArrayList<Colaboradores>(valoresColaboradores);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return valoresColaboradores.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Colaboradores colaboradores = valoresColaboradores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			return colaboradores.getId();
		else if (columnIndex == COL_NOME)
			return colaboradores.getNome();
		else if (columnIndex == COL_HABILITADO)
			return colaboradores.getHabilitado();
		else if (columnIndex == COL_EMAIL)
			return colaboradores.getEmail();
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Colaboradores colaboradores = valoresColaboradores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			colaboradores.setId(Integer.parseInt(aValue.toString()));
		else if (columnIndex == COL_NOME)
			colaboradores.setNome(aValue.toString());
		else if (columnIndex == COL_HABILITADO)
			colaboradores.setHabilitado(Boolean.parseBoolean(aValue.toString()));
		else if (columnIndex == COL_EMAIL)
			colaboradores.setEmail(aValue.toString());

	}

	public String getColumnNameString(int column) {
		if (column == COL_CODIGO)
			return "Código";
		if (column == COL_NOME)
			return "Nome";
		if (column == COL_HABILITADO)
			return "Habilitado";
		if (column == COL_EMAIL)
			return "E-mail";
		return "";

	}

	public Colaboradores get(int row) {
		return valoresColaboradores.get(row);
	}

}
