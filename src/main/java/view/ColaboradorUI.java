package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import controller.ColaboradoresController;
import entidades.Colaboradores;
import view.tabelas.ColaboradorTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ColaboradorUI extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textEmail;
	private JTable tableColab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColaboradorUI frame = new ColaboradorUI();
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
	public ColaboradorUI() {
		setClosable(true);
		setTitle("Colaborador");
		setBounds(100, 100, 645, 468);

		JLabel lblNome = new JLabel("Nome: ");

		JLabel lblEmail = new JLabel("E-mail: ");

		JLabel lblHabilitado = new JLabel("Habilitado:");

		textNome = new JTextField();
		textNome.setColumns(10);

		textEmail = new JTextField();
		textEmail.setColumns(10);

		JRadioButton rdbtnHabilitadoSim = new JRadioButton("Sim");

		JRadioButton rdbtnHabilitadoNao = new JRadioButton("Não");
		rdbtnHabilitadoNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHabilitadoSim.setSelected(false);
			}
		});
		rdbtnHabilitadoSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnHabilitadoNao.setSelected(false);
			}
		});

		JButton btnSalvarColab = new JButton("Salvar");
		btnSalvarColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Colaboradores colaboradores = new Colaboradores();
					colaboradores.setNome(textNome.getText());
					colaboradores.setEmail(textEmail.getText());

					if (rdbtnHabilitadoNao.isSelected()) {
						colaboradores.setHabilitado(false);
					} else {
						colaboradores.setHabilitado(true);
					}

					new ColaboradoresController().salvar(colaboradores);
					JOptionPane.showMessageDialog(null, "Colaborador Salvo");
					tableColab.setModel(new ColaboradorTableModel(new ColaboradoresController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Salvar o Colaborador");
				}
			}
		});

		JButton btnCancelarColab = new JButton("Cancelar");
		btnCancelarColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JScrollPane scrollPane = new JScrollPane();

		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Colaboradores colaboradores = new Colaboradores();
					colaboradores.setId((Integer) tableColab.getValueAt(tableColab.getSelectedRow(), 0));
					colaboradores.setNome(textNome.getText());
					colaboradores.setEmail(textEmail.getText());
					if (rdbtnHabilitadoNao.isSelected()) {
						colaboradores.setHabilitado(false);
					} else {
						colaboradores.setHabilitado(true);
					}

					new ColaboradoresController().atualizar(colaboradores);

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
					tableColab.setModel(new ColaboradorTableModel(new ColaboradoresController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Atualizar");
				}
			}
		});

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Colaboradores colaboradores = new ColaboradorTableModel(new ColaboradoresController().listar())
						.get(tableColab.getSelectedRow());
				try {
					new ColaboradoresController().excluir(colaboradores.getId());
					tableColab.setModel(new ColaboradorTableModel(new ColaboradoresController().listar()));
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao Deletar");
				}
			}
		});

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(22)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addComponent(lblNome).addGap(27).addComponent(
								textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup().addComponent(btnSalvarColab)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(btnAtualizar)
												.addGap(7).addComponent(btnDeletar).addGap(18)
												.addComponent(btnCancelarColab))
										.addGroup(groupLayout.createSequentialGroup()
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(lblEmail).addComponent(lblHabilitado))
												.addGap(23)
												.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
														.addComponent(textEmail, GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addGroup(groupLayout.createSequentialGroup()
																.addComponent(rdbtnHabilitadoSim)
																.addPreferredGap(ComponentPlacement.UNRELATED)
																.addComponent(rdbtnHabilitadoNao))))
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 578,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(29, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblEmail).addComponent(
						textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(42)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblHabilitado)
						.addComponent(rdbtnHabilitadoSim).addComponent(rdbtnHabilitadoNao))
				.addGap(18)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvarColab)
						.addComponent(btnAtualizar).addComponent(btnCancelarColab).addComponent(btnDeletar))
				.addPreferredGap(ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
				.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));

		tableColab = new JTable();
		tableColab.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textNome.setText(tableColab.getValueAt(tableColab.getSelectedRow(), 1).toString());
				textEmail.setText(tableColab.getValueAt(tableColab.getSelectedRow(), 3).toString());
			}
		});
		tableColab.setModel(new ColaboradorTableModel(new ColaboradoresController().listar()));

		scrollPane.setViewportView(tableColab);
		getContentPane().setLayout(groupLayout);

	}
}
