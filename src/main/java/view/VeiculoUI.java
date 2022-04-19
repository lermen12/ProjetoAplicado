package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import controller.VeiculoController;
import entidades.Veiculo;
import view.tabelas.VeiculoTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VeiculoUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textModelo;
	private JTextField textAutonomia;
	private JTextField textAnoFab;
	private JTable tableVeiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VeiculoUI frame = new VeiculoUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VeiculoUI() {
		setTitle("Veículo");

		setClosable(true);
		setBounds(100, 100, 713, 506);

		JLabel lblModelo = new JLabel("Modelo");

		JLabel lblAnoFab = new JLabel("Ano de Fabricação");

		JLabel lblAutonomia = new JLabel("Autonomia");

		textModelo = new JTextField();
		textModelo.setColumns(10);

		textAutonomia = new JTextField();
		textAutonomia.setColumns(10);

		textAnoFab = new JTextField();
		textAnoFab.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				veiculo.setModelo(textModelo.getText());
				veiculo.setAutonomia(Double.parseDouble(textAutonomia.getText()));
				veiculo.setAnoDeFabricacao(Integer.parseInt(textAnoFab.getText()));

				try {
					new VeiculoController().salvar(veiculo);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					tableVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar!");
				}

			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new Veiculo();
				veiculo.setId((Integer) tableVeiculo.getValueAt(tableVeiculo.getSelectedRow(), 0));
				veiculo.setModelo(textModelo.getText());
				veiculo.setAutonomia(Double.parseDouble(textAutonomia.getText()));
				veiculo.setAnoDeFabricacao(Integer.parseInt(textAnoFab.getText()));

				try {

					new VeiculoController().atualizar(veiculo);
					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
					tableVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar!");
				}

			}
		});

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Veiculo veiculo = new VeiculoTableModel(new VeiculoController().listar()).get(tableVeiculo.getSelectedRow());
				try {
					new VeiculoController().excluir(veiculo.getId());
					tableVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Deletar");
				}
			}
		});

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(lblModelo)
										.addComponent(lblAnoFab)))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(22)
									.addComponent(lblAutonomia)))
							.addGap(46)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textAnoFab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 622, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnSalvar)
									.addGap(27)
									.addComponent(btnAtualizar)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnDeletar)
									.addGap(18)
									.addComponent(btnCancelar)))))
					.addContainerGap(64, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblModelo)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblAnoFab)
								.addComponent(textAnoFab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblAutonomia))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar)
						.addComponent(btnAtualizar)
						.addComponent(btnDeletar)
						.addComponent(btnCancelar))
					.addGap(81)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(41))
		);

		tableVeiculo = new JTable();
		tableVeiculo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textModelo.setText(tableVeiculo.getValueAt(tableVeiculo.getSelectedRow(), 1).toString());
				textAnoFab.setText(tableVeiculo.getValueAt(tableVeiculo.getSelectedRow(), 2).toString());
				textAutonomia.setText(tableVeiculo.getValueAt(tableVeiculo.getSelectedRow(), 3).toString());
			}
		});
		tableVeiculo.setModel(new VeiculoTableModel(new VeiculoController().listar()));

		scrollPane.setViewportView(tableVeiculo);
		getContentPane().setLayout(groupLayout);

	}
}
