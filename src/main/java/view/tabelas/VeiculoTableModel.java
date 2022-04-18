package view.tabelas;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import entidades.Veiculo;

public class VeiculoTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int COL_CODIGO = 0;
	private static final int COL_MODELO = 1;
	private static final int COL_ANO_DE_FAB = 2;
	private static final int COL_AUTONOMIA = 3;

	private List<Veiculo> valores;

	public VeiculoTableModel(List<Veiculo> valores) {
		this.valores = new ArrayList<Veiculo>(valores);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return valores.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Veiculo veiculo = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			return veiculo.getId();
		else if (columnIndex == COL_MODELO)
			return veiculo.getModelo();
		else if (columnIndex == COL_ANO_DE_FAB)
			return veiculo.getAnoDeFabricacao();
		else if (columnIndex == COL_AUTONOMIA)
			return veiculo.getAutonomia();
		return "";
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Veiculo veiculo = valores.get(rowIndex);
		if (columnIndex == COL_CODIGO)
			veiculo.setId(Integer.parseInt(aValue.toString()));
		else if (columnIndex == COL_MODELO)
			veiculo.setModelo(aValue.toString());
		else if (columnIndex == COL_ANO_DE_FAB)
			veiculo.setAnoDeFabricacao(Integer.parseInt(aValue.toString()));
		else if (columnIndex == COL_AUTONOMIA)
			veiculo.setAutonomia(Double.parseDouble(aValue.toString()));

	}

	public String getColumnNameString(int column) {
		if (column == COL_CODIGO)
			return "Código";
		if (column == COL_MODELO)
			return "Modelo";
		if (column == COL_ANO_DE_FAB)
			return "Ano de Fabricação";
		if (column == COL_AUTONOMIA)
			return "Autonomia";
		return "";

	}

	public Veiculo get(int row) {
		return valores.get(row);
	}

}
