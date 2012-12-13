package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCadastroProfessorMenuAction  extends AbstractAction {
	public static final String CADASTRA2 = "CADASTRA2";

	private JPanel principal;
	private CardLayout cards;
	
	public JCadastroProfessorMenuAction(JPanel principal, CardLayout cards) {
		super("Cadastrar Professores");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CADASTRA2);
	}
}