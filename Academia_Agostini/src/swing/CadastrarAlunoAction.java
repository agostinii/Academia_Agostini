package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Academia.CadastrarAlunoDAO;

@SuppressWarnings("serial")
public class CadastrarAlunoAction extends AbstractAction {

	private JTextField nome;
	private JTextField endereco;
	private JTextField cpf;
	private JFrame frame;	

	public CadastrarAlunoAction(JTextField nome,JTextField endereco,JTextField cpf) {
		super("Salvar");
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setCpf(cpf);
	}

	public CadastrarAlunoAction() {
		super("Cadastrar Alunos");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		CadastrarAlunoDAO cli = new CadastrarAlunoDAO();
		cli.insertAluno(nome.getText(),endereco.getText(),cpf.getText());
		JOptionPane.showMessageDialog(frame, "Aluno cadastrado com sucesso", "Sobre...", JOptionPane.INFORMATION_MESSAGE);
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