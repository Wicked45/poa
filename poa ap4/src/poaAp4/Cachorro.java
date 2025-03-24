package poaAp4;


import java.io.Serializable;

public class Cachorro implements Serializable {
	
	private static final long serialVersionUID = 1L; // Adicionando serialVersionUID
	private String nome;
	private int idade;
	private transient String raca; // Atributo que não será serializado
	
	public Cachorro(String nome, int idade, String raca) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.raca = raca;
	}
	
	@Override
	public String toString() {
		return "Cachorro [nome=" + nome + ", idade=" + idade + ", raça=" + raca + "]";
	}
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public int getIdade() { return idade; }
	public void setIdade(int idade) { this.idade = idade; }
	public String getRaca() { return raca; }
	public void setRaca(String raca) { this.raca = raca; }	
}