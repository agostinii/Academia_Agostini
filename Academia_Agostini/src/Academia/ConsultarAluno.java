package Academia;

public class ConsultarAluno {
	private int codaluno;
	private String nome;
	private String endereco;
	private String cpf;

	public ConsultarAluno(int codaluno, String nome, String endereco, String cpf) {
		super();
		this.codaluno = codaluno;
		this.nome = nome;
		this.endereco = endereco;
		this.cpf = cpf;
	}

	public int getCodAluno() {
		return codaluno;
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
		return String.format("Aluno [CODIGO=%s, Nome=%s, Endereço=%s, CPF=%s]\n", codaluno, nome, endereco, cpf);
	}

}