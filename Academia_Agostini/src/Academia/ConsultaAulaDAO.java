package Academia;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ConsultaAulaDAO {
	private String selectFindCli = "select * from aula,professor where tipo like ? and aula.codprof=professor.codprof";	
	
	public List <ConsultaAula> findCli(String busca) {
		List <ConsultaAula> res = new ArrayList <ConsultaAula>();
		if (busca == null) {
			throw new IllegalArgumentException("Campo inválido!");
		}

		ConsultaAula cons = null;

		try {
			Connection con = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/Ginastica", "postgres",
					"pywb87gt");

			PreparedStatement stmt = con.prepareStatement(selectFindCli);
			stmt.setString(1, busca);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int codaula = rs.getInt("codaula");
				String nomeprof = rs.getString("nome");
				String tipo = rs.getString("tipo");
				String data = rs.getString("data");
				cons = new ConsultaAula(codaula,nomeprof,tipo,data);
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
		ConsultaAulaDAO cCli = new ConsultaAulaDAO();
		List<ConsultaAula> cons = cCli.findCli("%ps%");
		if (cons == null) {
			System.out.println("Aula não encontrada!");
		} else {
			System.out.println(cons);
		}
	}
}
