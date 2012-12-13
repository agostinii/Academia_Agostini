package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JConsultaAulaProfMenuAction  extends AbstractAction {
	public static final String CONSULTA3 = "CONSULTA3";

	private JPanel principal;
	private CardLayout cards;
	
	public JConsultaAulaProfMenuAction(JPanel principal, CardLayout cards) {
		super("Consultar Aula");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CONSULTA3);
	}
}