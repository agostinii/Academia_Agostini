package Academia;

public class CadastrarAluno {
	private String nome;
	private String endereco;
	private String cpf;

	public CadastrarAluno(String nome, String endereco, String cpf) {
		super();
		this.nome = nome;
		this.endereco = endereco; 
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getendereco() {
		return endereco;
	}
	
	public String getCpf() {
		return cpf;
	}	

	public String toString() {
		return String.format("Aluno %s cadastrado com sucesso", nome);
	}

}