package swing;

import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.*;

//import swing.JAboutMenuAction;
import swing.JCadastroAlunoMenuAction;
import swing.JCadastroProfessorMenuAction;
import swing.JConsultaAlunoMenuAction;
import swing.JConsultaProfessorMenuAction;
//import swing.JSairMenuAction;

public class JInicialPanel {

	public static final String PRINCIPAL = "PRINCIPAL";

	private static void createAndShowGUI() {

		JFrame frame = new JFrame("  $Marombas$ ");
		CardLayout cards = new CardLayout();
		JPanel principal = new JPanel(cards);

		JPanel ConsultarAluno = new JConsultarAlunoPanel(principal, cards);
		JPanel CadastrarProfessor = new JCadastroProfessorPanel(principal, cards);
		JPanel CadastrarAluno = new JCadastroAlunoPanel(principal, cards);
		JPanel ConsultarProfessor = new JConsultarProfessorPanel(principal, cards);
		JPanel ConsultaAula = new JConsultaAulaProfPanel(principal, cards);
		JPanel vazio = new JPanel();
		JLabel label = new JLabel(" $Marombas$ - Sistemas");
		vazio.add(label);

		principal.add(vazio, PRINCIPAL);
		principal.add(ConsultarAluno, JConsultaAlunoMenuAction.CONSULTA1);
		principal.add(CadastrarProfessor, JCadastroProfessorMenuAction.CADASTRA2);
		principal.add(CadastrarAluno, JCadastroAlunoMenuAction.CADASTRA1);
		principal.add(ConsultarProfessor, JConsultaProfessorMenuAction.CONSULTA2);
		principal.add(ConsultaAula, JConsultaAulaProfMenuAction.CONSULTA3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(new ImageIcon("ico.jpg").getImage());

		frame.getContentPane().add(principal);

		JMenuBar menubar = new JMenuBar();
		JMenu file = new JMenu("Arquivo");
		menubar.add(file);
		JMenu cadastro = new JMenu("Cadastrar");
		menubar.add(cadastro);
		JMenu consulta = new JMenu("Consultar");
		menubar.add(consulta);
		JMenu help = new JMenu("Ajuda");
		menubar.add(help);
		Action aboutAction = new JAboutMenuAction(frame);
		help.add(aboutAction);
		Action exitAction = new JSairMenuAction();
		file.add(exitAction);

		Action consultaAction = new JConsultaAlunoMenuAction(principal, cards);
		consulta.add(consultaAction);
		Action consultaAction2 = new JConsultaProfessorMenuAction(principal, cards);
		consulta.add(consultaAction2);
		Action ConsultaAction3 = new JConsultaAulaProfMenuAction(principal, cards);
		consulta.add(ConsultaAction3);
		Action cadastroAction = new JCadastroAlunoMenuAction(principal, cards);
		cadastro.add(cadastroAction);
		Action cadastroAction2 = new JCadastroProfessorMenuAction(principal, cards);
		cadastro.add(cadastroAction2);
		

		frame.setJMenuBar(menubar);

		frame.setMinimumSize(new Dimension(400, 200));

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
