package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.JInicialPanel;


@SuppressWarnings("serial")
public class JConsultarCancelAction extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JConsultarCancelAction(JPanel principal, CardLayout cards) {
		super("Voltar");
		this.principal = principal;
		this.cards = cards;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, JInicialPanel.PRINCIPAL);
		}

	}
}
