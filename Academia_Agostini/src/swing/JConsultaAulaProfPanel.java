package swing;

import java.awt.CardLayout;

import javax.swing.*;

import swing.JConsultarCancelAction;

@SuppressWarnings("serial")
public class JConsultaAulaProfPanel extends JPanel {
	JTextArea dados;
	
	public JConsultaAulaProfPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60);
		dados.setEditable(false);
		add(dados);
		add(new JLabel("Nome"));
		JTextField busca = new JTextField(8);
		add(busca);
		add(new JButton(new ConsultarAulaProfAction(principal,cards,busca,dados)));
		add(new JButton(new JConsultarCancelAction(principal, cards)));
	}
	
	public JConsultaAulaProfPanel() {
		// TODO Auto-generated constructor stub
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("  $Marombas$ - Consulta de Aula  ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JConsultaAulaProfPanel();
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
