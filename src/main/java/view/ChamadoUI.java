package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import DAO.ColaboradoresDAO;
import DAO.VeiculoDAO;
import controller.ChamadoController;
import entidades.Chamado;
import entidades.Colaboradores;
import entidades.Veiculo;
import view.tabelas.ChamadoTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChamadoUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textCliente;
	private JTextField textDistancia;
	private JTable tableChamado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChamadoUI frame = new ChamadoUI();
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
	public ChamadoUI() {
		setClosable(true);
		setBounds(100, 100, 704, 556);

		JLabel lblCliente = new JLabel("Cliente");

		JLabel lblDistancia = new JLabel("Distância");

		JLabel lblColab = new JLabel("Colaborador");

		JLabel lblVeiculo = new JLabel("Veículo");

		textCliente = new JTextField();
		textCliente.setColumns(10);

		textDistancia = new JTextField();
		textDistancia.setColumns(10);

		JComboBox<Colaboradores> cbColab = new JComboBox<Colaboradores>();
		cbColab.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				ColaboradoresDAO dao = new ColaboradoresDAO();
				java.util.List<Colaboradores> lista = dao.listar();
				cbColab.removeAll();

				for (Colaboradores colaboradores : lista) {
					cbColab.addItem(colaboradores);

				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		JComboBox<Veiculo> cbVeiculo = new JComboBox<Veiculo>();
		cbVeiculo.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {
				VeiculoDAO dao = new VeiculoDAO();
				java.util.List<Veiculo> lista = dao.listar();
				cbVeiculo.removeAll();
				for (Veiculo veiculo : lista) {
					cbVeiculo.addItem(veiculo);

				}

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chamado chamado = new Chamado();
				Colaboradores colaboradores = new Colaboradores();
				Veiculo veiculo = new Veiculo();

				chamado.setCliente(textCliente.getText());
				chamado.setDistancia(Double.parseDouble(textDistancia.getText()));
				colaboradores = (Colaboradores) cbColab.getSelectedItem();
				chamado.setColaboradores(colaboradores);
				veiculo = (Veiculo) cbVeiculo.getSelectedItem();
				chamado.setVeiculo(veiculo);
				try {
					new ChamadoController().salvar(chamado);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
					dispose();
				} catch (Exception e1) {
					e1.printStackTrace();
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

		JButton btnEditar = new JButton("Editar");

		JButton btnDeletar = new JButton("Deletar");

		JScrollPane scrollPane = new JScrollPane();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblColab)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblCliente)
										.addComponent(lblDistancia).addComponent(lblVeiculo))
								.addGap(90)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(textCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textDistancia, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbColab, Alignment.LEADING, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnSalvar)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEditar)
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDeletar).addGap(18)
								.addComponent(btnCancelar))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(33, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(50)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCliente).addComponent(
						textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textDistancia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDistancia))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblColab).addComponent(
						cbColab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblVeiculo).addComponent(
						cbVeiculo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar)
						.addComponent(btnEditar).addComponent(btnDeletar).addComponent(btnCancelar))
				.addGap(27).addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(135, Short.MAX_VALUE)));

		tableChamado = new JTable();
		tableChamado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textCliente.setText(tableChamado.getValueAt(tableChamado.getSelectedRow(), 1).toString());
				textDistancia.setText(tableChamado.getValueAt(tableChamado.getSelectedRow(), 2).toString());
			}
		});
		scrollPane.setViewportView(tableChamado);
		getContentPane().setLayout(groupLayout);

		tableChamado.setModel(new ChamadoTableModel(new ChamadoController().listar()));

	}

}
