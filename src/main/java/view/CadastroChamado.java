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

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class CadastroChamado extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

	private JTextField textData;
	private JTextField textCliente;
	private JTextField textEndereco;
	private JTextField textDistancia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroChamado frame = new CadastroChamado();
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
	public CadastroChamado() {
		setClosable(true);
		setBounds(100, 100, 450, 300);

		JLabel lblData = new JLabel("Data ");
		lblData.setToolTipText("");

		JLabel lblCliente = new JLabel("Cliente");

		JLabel lblEndereco = new JLabel("Endereço");

		JLabel lblDistancia = new JLabel("Distância");

		JLabel lblColab = new JLabel("Colaborador");

		JLabel lblVeiculo = new JLabel("Veículo");
		Date data=new Date();
		textData = new JTextField(formato.format(data));
		textData.setColumns(10);

		textCliente = new JTextField();
		textCliente.setColumns(10);

		textEndereco = new JTextField();
		textEndereco.setColumns(10);

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

				try {
					chamado.setData(formato.parse(textData.getText()));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				chamado.setCliente(textCliente.getText());
				chamado.setEndereco(textEndereco.getText());
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

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap(29, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
						.createSequentialGroup()
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(lblEndereco)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)
										.addComponent(textEndereco, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblData).addComponent(lblCliente))
										.addGap(100)
										.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
												.addComponent(textData, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textCliente, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(lblDistancia).addComponent(lblColab)
												.addComponent(lblVeiculo))
										.addPreferredGap(ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(cbColab, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(cbVeiculo, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(textDistancia, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGap(230))
						.addGroup(groupLayout.createSequentialGroup().addComponent(btnSalvar).addGap(32)
								.addComponent(btnCancelar).addGap(77)))));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblData).addComponent(
						textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblCliente).addComponent(
						textCliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEndereco).addComponent(
						textEndereco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(11)
				.addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(lblDistancia).addComponent(textDistancia,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(16)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblColab)
										.addComponent(cbColab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblVeiculo))
						.addGroup(groupLayout.createSequentialGroup().addGap(28).addComponent(cbVeiculo,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE).addGroup(groupLayout
						.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar).addComponent(btnCancelar))
				.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}
}
