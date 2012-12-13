package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Academia.ConsultaAula;
import Academia.ConsultaAulaDAO;
import Academia.ConsultarAluno;
import Academia.ConsultarAlunoDAO;

@SuppressWarnings("serial")
public class ConsultarAulaProfAction extends AbstractAction {

	private JTextField busca;
	private JTextArea dados;
	private JPanel principal;
	private CardLayout cards;

	public ConsultarAulaProfAction(JPanel principal, CardLayout cards, JTextField busca, JTextArea dados) {
		super("Buscar");
		this.setBusca(busca);
		this.dados=dados;
		this.principal=principal;
		this.cards=cards;
	}

	public ConsultarAulaProfAction() {
		super("Consultar Aula");
	}

	public void actionPerformed(ActionEvent e) {
		ConsultaAulaDAO cAluno = new ConsultaAulaDAO();
		List<ConsultaAula> cons = cAluno.findCli(busca.getText()); //TODO: impletemtar like
		if (cons == null) {
			System.out.println("Aula não encontrado!");
		} else {
			System.out.println(cons);
			// List<ConsultaCli> ops = cCli
			// .findCli("Lista de clientes encontrados...");
			String s = "CodAula\t\tCodProf\t\t                  Nome\n\n";
			for (ConsultaAula teste : cons) {
				//s += teste.getNome();
				s += String.format("%s\t\t%s\t\t                  %s\n", teste.getCodAula(),teste.getNomeprof(), teste.gettipo(), teste.getdata());
			}
			dados.setText(s);
		}
	}

	public void setBusca(JTextField busca) {
		this.busca = busca;
	}

}