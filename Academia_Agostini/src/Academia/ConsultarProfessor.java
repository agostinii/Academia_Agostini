package Academia;

public class ConsultarProfessor {
	private int codprof;
	private String nome;
	private String endereco;
	private String cpf;

	public ConsultarProfessor(int codprof, String nome, String endereco, String cpf) {
		super();
		this.codprof = codprof;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public int getCodProf() {
		return codprof;
	}

	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public String getCpf() {
		return cpf;
	}
	
	@Override
	public String toString() {
		return String.format("Professor [CODIGO=%s, Nome=%s, Endereço=%s, CPF=%s]\n", codprof, nome, endereco, cpf);
	}

}