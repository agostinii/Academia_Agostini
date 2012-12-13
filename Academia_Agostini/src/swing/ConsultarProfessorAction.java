package swing;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Academia.ConsultarAluno;
//import Academia.ConsultarAluno;
//import Academia.ConsultarAlunoDAO;
import Academia.ConsultarProfessor;
import Academia.ConsultarProfessorDAO;

@SuppressWarnings("serial")
public class ConsultarProfessorAction extends AbstractAction {

	private JTextField busca;
	private JTextArea dados;
	private JPanel principal;
	private CardLayout cards;	
	
	public ConsultarProfessorAction(JPanel principal, CardLayout cards, JTextField busca, JTextArea dados) {
		super("Buscar");
		this.setBusca(busca);
		this.dados=dados;
		this.principal=principal;
		this.cards=cards;
	}

	public ConsultarProfessorAction() {
		super("Consultar Professores");
	}

	public void actionPerformed(ActionEvent e) {
		ConsultarProfessorDAO cProfessor = new ConsultarProfessorDAO();
		List<ConsultarProfessor> cons = cProfessor.findCli(busca.getText()); //TODO: impletemtar like
		if (cons == null) {
			System.out.println("Professor não encontrado!");
		} else {
			System.out.println(cons);
			// List<ConsultaCli> ops = cCli
			// .findCli("Lista de clientes encontrados...");
			String s = "Nome\t\tEndereço\t\t                  CPF\n\n";
			for (ConsultarProfessor teste : cons) {
				//s += teste.getNome();
				s += String.format("%s\t\t%s\t\t                  %s\n", teste.getNome(),teste.getEndereco(), teste.getCpf());
			}
			dados.setText(s);
		}
	}

	public void setBusca(JTextField busca) {
		this.busca = busca;
	}

}