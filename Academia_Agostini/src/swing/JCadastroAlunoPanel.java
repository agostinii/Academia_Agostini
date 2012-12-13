package swing;

import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import swing.JCadastroCancelPanel;

@SuppressWarnings("serial")
public class JCadastroAlunoPanel extends JPanel {
	
	
	public JCadastroAlunoPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome"));
		JTextField nome = new JTextField(20);
		add(nome);
		add(new JLabel("Endereço"));
		JTextField endereco = new JTextField(20);
		add(endereco);
		add(new JLabel("CPF"));
		JTextField cpf = new JTextField(8);
		add(cpf);
		add(new JButton(new CadastrarAlunoAction(nome,endereco,cpf)));
		add(new JButton(new JCadastroCancelPanel(principal, cards)));
	}
	
	public JCadastroAlunoPanel() {
		// TODO Auto-generated constructor stub
	}

	private static void createAndShowGUI() {
		JFrame frame = new JFrame("  $Marombas$ - Cadastro de alunos  ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JCadastroAlunoPanel();
		frame.getContentPane().add(painel);

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