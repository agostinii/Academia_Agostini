package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class teste_jdbc {

		public static void main(String[] args) throws Exception{

		    Connection con = DriverManager.getConnection(
		                         "jdbc:postgresql://localhost:5432/Ginastica",
		                         "postgres",
		                         "pywb87gt");

		    Statement stmt = con.createStatement();
		    ResultSet rs = stmt.executeQuery("SELECT codaluno,nome,cpf FROM aluno");

		    while (rs.next()) {
		        int cod = rs.getInt("codaluno");
		        String nome = rs.getString("nome");
		        String cpf = rs.getString("cpf");
		        System.out.printf("Cod Aluno: %d\t", cod);
				System.out.printf("Nome: %s\t", nome);
				System.out.printf("Cpf: %s\n", cpf);
		    }
		}
}