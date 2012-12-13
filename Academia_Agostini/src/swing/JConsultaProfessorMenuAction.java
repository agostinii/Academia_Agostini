package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JConsultaProfessorMenuAction  extends AbstractAction {
	public static final String CONSULTA2 = "CONSULTA2";

	private JPanel principal;
	private CardLayout cards;
	
	public JConsultaProfessorMenuAction(JPanel principal, CardLayout cards) {
		super("Consultar Professores");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CONSULTA2);
	}
}