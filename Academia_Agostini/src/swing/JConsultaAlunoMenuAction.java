package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JConsultaAlunoMenuAction  extends AbstractAction {
	public static final String CONSULTA1 = "CONSULTA1";

	private JPanel principal;
	private CardLayout cards;
	
	public JConsultaAlunoMenuAction(JPanel principal, CardLayout cards) {
		super("Consultar Alunos");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CONSULTA1);
	}
}