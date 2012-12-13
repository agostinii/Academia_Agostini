package swing;

import javax.swing.*;

import swing.LoginAction;

@SuppressWarnings("serial")
public class JLoginPanel extends JPanel {
	
	
	public JLoginPanel() {
		add(new JLabel("Login"));
		JTextField login = new JTextField(8);
		add(login);
		add(new JLabel("Senha"));
		JTextField senha = new JTextField(8);
		add(senha);
		add(new JButton(new LoginAction(login, senha)));
		add(new JButton("Sair"));
	}
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("@Futebol - Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel painel = new JLoginPanel();
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
