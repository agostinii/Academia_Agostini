package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Academia.CadastrarProfessorDAO;

@SuppressWarnings("serial")
public class CadastrarProfessorAction extends AbstractAction {

	private JTextField nome;
	private JTextField endereco;
	private JTextField cpf;
	private JFrame frame;

	public CadastrarProfessorAction(JTextField nome,JTextField endereco,JTextField cpf) {
		super("Salvar");
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}

	public CadastrarProfessorAction() {
		super("Cadastrar Professor");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		CadastrarProfessorDAO cli = new CadastrarProfessorDAO();
		cli.insertProfessor(nome.getText(),endereco.getText(),cpf.getText());
		JOptionPane.showMessageDialog(frame, "Professor cadastrado com sucesso", "Sobre...", JOptionPane.INFORMATION_MESSAGE);
	}
	

	public void setNome(JTextField nome) {
		this.nome = nome;
	}

	public void setEndereco(JTextField endereco) {
		this.endereco = endereco;
	}
	
	public void setCpf(JTextField cpf) {
		this.cpf = cpf;
	}
}