package Academia;

public class ConsultaAula {
	private int codaula;
	private String nomeprof;
	private String tipo;
	private String data;

	public ConsultaAula(int codaula, String nomeprof, String tipo, String data) {
		super();
		this.codaula = codaula;
		this.nomeprof = nomeprof;
		this.tipo = tipo;
		this.data = data;
	}

	public int getCodAula() {
		return codaula;
	}

	public String getNomeprof() {
		return nomeprof;
	}
	
	public String gettipo() {
		return tipo;
	}

	public String getdata() {
		return data;
	}
	
	@Override
	public String toString() {
		return String.format("Aula [CODIGO=%s, Nome=%s, Endereço=%s, CPF=%s]\n", codaula, nomeprof, tipo, data);
	}

}