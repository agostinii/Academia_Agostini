package Academia;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsultarAlunoDAO {
	private String selectFindCli = "select * from aluno where nome like ?";	
	
	public List <ConsultarAluno> findCli(String busca) {
		List <ConsultarAluno> res = new ArrayList <ConsultarAluno>();
		if (busca == null) {
			throw new IllegalArgumentException("Campo inválido!");
		}

		ConsultarAluno cons = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(selectFindCli);
			stmt.setString(1, busca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int codaluno = rs.getInt("codaluno");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cpf = rs.getString("cpf");
				cons = new ConsultarAluno(codaluno,nome,endereco,cpf);
				res.add(cons);
			}
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static void main(String[] args) {
		ConsultarAlunoDAO cCli = new ConsultarAlunoDAO();
		List<ConsultarAluno> cons = cCli.findCli("%ps%");
		if (cons == null) {
			System.out.println("Aluno não encontrado!");
		} else {
			System.out.println(cons);
		}
	}
}
