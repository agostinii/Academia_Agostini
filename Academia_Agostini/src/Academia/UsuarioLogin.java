package Academia;

public class UsuarioLogin {
	private int codusuario;
	private String usuario;
	private String senha;

	public UsuarioLogin(int codusuario, String usuario, String senha) {
		super();
		this.codusuario = codusuario;
		this.usuario = usuario;
		this.senha = senha;
	}

	public int getCodUsuario() {
		return codusuario;
	}

	public String getUsuario() {
		return usuario;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return String.format("Usuario [id=%s, Usuario=%s]", codusuario, usuario);
	}

}