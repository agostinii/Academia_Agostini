package swing;

import java.awt.CardLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class JCadastroProfessorPanel extends JPanel {
	
	
	public JCadastroProfessorPanel(JPanel principal, CardLayout cards) {
		add(new JLabel("Nome"));
		JTextField nome = new JTextField(20);
		add(nome);
		add(new JLabel("Endereço"));
		JTextField endereco = new JTextField(20);
		add(endereco);
		add(new JLabel("CPF"));
		JTextField cpf = new JTextField(8);
		add(cpf);
		add(new JButton(new CadastrarProfessorAction(nome,endereco,cpf)));
		add(new JButton(new JCadastroCancelPanel(principal, cards)));
	}
	
	public JCadastroProfessorPanel() {
		// TODO Auto-generated constructor stub
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("  $Marombas$ - Cadastro de professores  ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JCadastroProfessorPanel();
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