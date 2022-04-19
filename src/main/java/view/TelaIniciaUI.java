package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class TelaIniciaUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaIniciaUI frame = new TelaIniciaUI();
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
	public TelaIniciaUI() {
		setTitle("Sistema Pegada de Carbono");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1001, 751);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JButton btnColab = new JButton("Colaborador");
		btnColab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ColaboradorUI colaborador = new ColaboradorUI();
				colaborador.setVisible(true);
				contentPane.add(colaborador, 0);
			}
		});

		JButton btnVeiculo = new JButton("Veículo");
		btnVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VeiculoUI veiculo = new VeiculoUI();
				veiculo.setVisible(true);
				contentPane.add(veiculo, 0);
			}
		});

		JButton btnChamado = new JButton("Chamado");
		btnChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChamadoUI chamado = new ChamadoUI();
				chamado.setVisible(true);
				contentPane.add(chamado, 0);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(180)
					.addComponent(btnColab)
					.addGap(171)
					.addComponent(btnVeiculo)
					.addPreferredGap(ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
					.addComponent(btnChamado)
					.addGap(201))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(580, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnColab)
						.addComponent(btnChamado)
						.addComponent(btnVeiculo))
					.addGap(99))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
