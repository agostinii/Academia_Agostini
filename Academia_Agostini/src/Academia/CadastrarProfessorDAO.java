package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CadastrarProfessorDAO {
	private String insertProfessor = "insert into professor (nome,endereco,cpf) values(?,?,?)";
	private String procuraProfessor = "select * from professor where cpf = ?";

	public CadastrarProfessor procuraProfessor(String cpf) {
		if (cpf == null) {
			throw new IllegalArgumentException(
					"O número do CPF não pode ser null.");
		}

		CadastrarProfessor c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(procuraProfessor);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cpfbd = rs.getString("cpf");
				c = new CadastrarProfessor(nome,endereco,cpfbd);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return c;
	}

	public CadastrarProfessor insertProfessor(String nome,String endereco,String cpf) {
		if (nome == null) {
			throw new IllegalArgumentException("Nome nao pode ser nulo");
		}
		if (cpf == null) {
			throw new IllegalArgumentException("CPF nao pode ser nulo");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(insertProfessor);
			stmt.setString(1, nome);
			stmt.setString(2, endereco);
			stmt.setString(3, cpf);
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Professor");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		CadastrarProfessorDAO cli = new CadastrarProfessorDAO();
		cli.insertProfessor("Fuleco","Avenida","666");
	}

	

}