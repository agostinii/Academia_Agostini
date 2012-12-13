package Academia;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsultarProfessorDAO {
	private String selectFindCli = "select * from professor where nome like ?";	
	
	public List <ConsultarProfessor> findCli(String busca) {
		List <ConsultarProfessor> res = new ArrayList <ConsultarProfessor>();
		if (busca == null) {
			throw new IllegalArgumentException("Campo inválido!");
		}

		ConsultarProfessor cons = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(selectFindCli);
			stmt.setString(1, busca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int codprof = rs.getInt("codprof");
				String nome = rs.getString("nome");
				String endereco = rs.getString("endereco");
				String cpf = rs.getString("cpf");
				cons = new ConsultarProfessor(codprof,nome,endereco,cpf);
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
		ConsultarProfessorDAO cCli = new ConsultarProfessorDAO();
		List<ConsultarProfessor> cons = cCli.findCli("%ps%");
		if (cons == null) {
			System.out.println("Professor não encontrado!");
		} else {
			System.out.println(cons);
		}
	}
}
