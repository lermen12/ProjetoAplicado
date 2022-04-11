package view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.text.BadLocationException;

import controller.ColaboradoresController;
import entidades.Colaboradores;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroColaborador extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textTelefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroColaborador frame = new CadastroColaborador();
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
	public CadastroColaborador() {
		setClosable(true);
		setTitle("Cadastro de Colaborador");
		setBounds(100, 100, 400, 233);

		JLabel lblNome = new JLabel("Nome: ");

		JLabel lblEmail = new JLabel("E-mail: ");

		JLabel lblTelefone = new JLabel("Telefone: ");

		JLabel lblHabilitado = new JLabel("Habilitado:");

		textNome = new JTextField();
		textNome.setColumns(10);

		textEmail = new JTextField();
		textEmail.setColumns(10);

		textTelefone = new JTextField();
		textTelefone.setColumns(10);

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
					try {
						colaboradores.setTelefone(textTelefone.getText(0, 10));
					} catch (BadLocationException e1) {
						JOptionPane.showMessageDialog(null, "Telefone invalido", "Erro Telefone",
								JOptionPane.ERROR_MESSAGE);
						e1.printStackTrace();
						return;
					}
					if (rdbtnHabilitadoNao.isSelected()) {
						colaboradores.setHabilitado(false);
					} else {
						colaboradores.setHabilitado(true);
					}

					new ColaboradoresController().salvar(colaboradores);
					JOptionPane.showMessageDialog(null, "Colaborador Salvo");
					dispose();
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(255, Short.MAX_VALUE)
						.addComponent(btnSalvarColab).addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(btnCancelarColab).addGap(31))
				.addGroup(Alignment.LEADING, groupLayout
						.createSequentialGroup().addGap(22).addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNome).addGroup(groupLayout.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout
												.createParallelGroup(Alignment.LEADING).addComponent(lblEmail)
												.addComponent(lblTelefone).addComponent(lblHabilitado))))
						.addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addComponent(rdbtnHabilitadoSim)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(rdbtnHabilitadoNao))
								.addComponent(textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(205, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(19)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblNome).addComponent(
						textNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
				.addGap(21)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblTelefone).addComponent(
						textTelefone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblHabilitado)
						.addComponent(rdbtnHabilitadoSim).addComponent(rdbtnHabilitadoNao))
				.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvarColab)
						.addComponent(btnCancelarColab))
				.addContainerGap()));
		getContentPane().setLayout(groupLayout);

	}
}
