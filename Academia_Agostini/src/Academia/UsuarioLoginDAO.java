package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioLoginDAO {
	private String selectFindLogin = "select * from login where usuario = ? and senha = ?";

	public UsuarioLogin findLogin(String usuario, String senha) {
		if (usuario == null || senha == null) {
			throw new IllegalArgumentException("Senha e/ ou Usu�rio inv�lidos");
		}

		UsuarioLogin c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(selectFindLogin);
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				int codusuario = rs.getInt("codlogin");
				c = new UsuarioLogin(codusuario, usuario, senha);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return c;
	}

	public static void main(String[] args) {
		UsuarioLoginDAO user = new UsuarioLoginDAO();
		UsuarioLogin c = user.findLogin("admin", "admin");
		if (c == null) {
			System.out.println("Usuario n�o autorizado!");
		} else {
			System.out.println(c);
		}
	}

}
