package swing;

import java.awt.event.ActionEvent;

import javax.swing.*;

@SuppressWarnings("serial")
public class JAboutMenuAction extends AbstractAction {

	private JFrame frame;
	public JAboutMenuAction(JFrame frame) {
		super("Sobre");
		this.frame = frame;
		putValue(SHORT_DESCRIPTION, "Sobre a aplicação.");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Mostrar tela com About...");
		JOptionPane.showMessageDialog(frame, "Software desenvolvido por Rafael Agostini Vieira\n\nLinguagem de programação II", "Sobre...", JOptionPane.INFORMATION_MESSAGE);	
	}
}
