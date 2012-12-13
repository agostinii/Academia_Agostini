package swing;

import java.awt.CardLayout;

import javax.swing.*;

@SuppressWarnings("serial")
public class JConsultarProfessorPanel extends JPanel {
	JTextArea dados;
	
	public JConsultarProfessorPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60);
		dados.setEditable(false);
		add(dados);
		add(new JLabel("Nome"));
		JTextField busca = new JTextField(8);
		add(busca);
		add(new JButton(new ConsultarProfessorAction(principal,cards,busca,dados)));
		add(new JButton(new JConsultarCancelAction(principal, cards)));
	}
	
	public JConsultarProfessorPanel() {
		// TODO Auto-generated constructor stub
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("  $Marombas$ - Consulta de professores  ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JConsultarProfessorPanel();
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
