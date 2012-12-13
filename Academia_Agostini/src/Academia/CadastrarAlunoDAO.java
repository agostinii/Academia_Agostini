package Academia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CadastrarAlunoDAO {
	private String insertAluno = "insert into aluno (nome,endereco,cpf) values(?,?,?)";
	private String procuraAluno = "select * from aluno where cpf = ?";

	public CadastrarAluno procuraCliente(String cpf) {
		if (cpf == null) {
			throw new IllegalArgumentException(
					"O número da conta não pode ser null.");
		}

		CadastrarAluno c = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(procuraAluno);
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cpfbd = rs.getString("cpf");
				c = new CadastrarAluno(nome,endereco,cpfbd);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// FIXME: comunicar erro ao programa
		}
		// FIXME: fechar conexões

		return c;
	}

	public CadastrarAluno insertAluno(String nome,String endereco,String cpf) {
		if (nome == null) {
			throw new IllegalArgumentException("Nome nao pode ser nulo");
		}
		if (cpf == null) {
			throw new IllegalArgumentException("cpf nao pode ser nulo");
		}

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(insertAluno);
			stmt.setString(1, nome);
			stmt.setString(2, endereco);
			stmt.setString(3, cpf);
			int r = stmt.executeUpdate();
			if (r != 1) {
				throw new RuntimeException("Erro ao inserir Aluno");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {
		CadastrarAlunoDAO cli = new CadastrarAlunoDAO();
		cli.insertAluno("Fuleco","Avenida","666");
	}

}