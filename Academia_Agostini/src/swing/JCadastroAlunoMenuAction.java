package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class JCadastroAlunoMenuAction  extends AbstractAction {
	public static final String CADASTRA1 = "CADASTRA1";

	private JPanel principal;
	private CardLayout cards;
	
	public JCadastroAlunoMenuAction(JPanel principal, CardLayout cards) {
		super("Cadastrar Alunos");
		this.principal = principal;
		this.cards = cards;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		cards.show(principal, CADASTRA1);
	}
}