package Academia;

public class CadastrarProfessor {
	private String nome;
	private String endereco;
	private String cpf;

	public CadastrarProfessor(String nome, String endereco, String cpf) {
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
		return String.format("Professor %s cadastrado com sucesso", nome);
	}

}