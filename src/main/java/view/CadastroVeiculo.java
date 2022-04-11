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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroVeiculo extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textModelo;
	private JTextField textAutonomia;
	private JTextField textAnoFab;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroVeiculo frame = new CadastroVeiculo();
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
	public CadastroVeiculo() {
		setClosable(true);
		setBounds(100, 100, 450, 300);

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
					dispose();
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
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblAnoFab)
								.addComponent(lblAutonomia).addComponent(lblModelo))
						.addGap(46)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(textAnoFab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(203, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						groupLayout.createSequentialGroup().addContainerGap(234, Short.MAX_VALUE)
								.addComponent(btnSalvar).addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(btnCancelar).addGap(12)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(35)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblModelo).addComponent(
						textModelo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(28)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAnoFab).addComponent(
						textAnoFab, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(40)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAutonomia).addComponent(
						textAutonomia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE))
				.addGap(63).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnSalvar)
						.addComponent(btnCancelar))
				.addContainerGap(21, Short.MAX_VALUE)));
		getContentPane().setLayout(groupLayout);

	}
}
