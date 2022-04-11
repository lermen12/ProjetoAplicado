package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setBounds(100, 100, 943, 537);

		JMenuBar jmbPrincipal = new JMenuBar();
		setJMenuBar(jmbPrincipal);

		JMenu jmCadastrar = new JMenu("Cadastrar");
		jmbPrincipal.add(jmCadastrar);

		JMenuItem jmiCadastroColaborador = new JMenuItem("Colaborador");
		jmiCadastroColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroColaborador cadastroColaborador = new CadastroColaborador();
				cadastroColaborador.setVisible(true);
				contentPane.add(cadastroColaborador, 0);
			}
		});
		jmCadastrar.add(jmiCadastroColaborador);

		JMenuItem jmiCadastroVeiculo = new JMenuItem("Ve\u00EDculo");
		jmiCadastroVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroVeiculo cadastroVeiculo = new CadastroVeiculo();
				cadastroVeiculo.setVisible(true);
				contentPane.add(cadastroVeiculo, 0);
			}
		});
		jmCadastrar.add(jmiCadastroVeiculo);

		JMenuItem jmiCadastroChamado = new JMenuItem("Chamado");
		jmiCadastroChamado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroChamado cadastroChamado = new CadastroChamado();
				cadastroChamado.setVisible(true);
				contentPane.add(cadastroChamado, 0);
			}
		});
		jmCadastrar.add(jmiCadastroChamado);

		JMenu jmAtualizar = new JMenu("Atualizar");
		jmbPrincipal.add(jmAtualizar);

		JMenuItem jmiAtualizarColaborador = new JMenuItem("Colaborador");
		jmAtualizar.add(jmiAtualizarColaborador);

		JMenuItem jmAtualizarVeiculo = new JMenuItem("Ve\u00EDculo");
		jmAtualizar.add(jmAtualizarVeiculo);

		JMenuItem jmiAtualizarChamado = new JMenuItem("Chamado");
		jmAtualizar.add(jmiAtualizarChamado);

		JMenu jmListar = new JMenu("Listar");
		jmbPrincipal.add(jmListar);

		JMenuItem jmiListarColaborador = new JMenuItem("Colaborador");
		jmListar.add(jmiListarColaborador);

		JMenuItem jmiListarVeiculo = new JMenuItem("Ve\u00EDculo");
		jmListar.add(jmiListarVeiculo);

		JMenuItem jmiListarChamado = new JMenuItem("Chamado");
		jmListar.add(jmiListarChamado);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
