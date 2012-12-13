package swing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JTextField;

import Academia.UsuarioLogin;
import Academia.UsuarioLoginDAO;

@SuppressWarnings("serial")
public class LoginAction extends AbstractAction {

	private JTextField login;
	private JTextField senha;

	public LoginAction(JTextField login, JTextField senha) {
		super("Logar");
		this.setLogin(login);
		this.setSenha(senha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		UsuarioLoginDAO user = new UsuarioLoginDAO();
		UsuarioLogin c = user.findLogin(login.getText(), senha.getText());
		if (c == null) {
			System.out.println("Usuario não autorizado!");
		} else {
			System.out.println(c);
		}
	}

	public void setLogin(JTextField login) {
		this.login = login;
	}

	public void setSenha(JTextField senha) {
		this.senha = senha;
	}
}
