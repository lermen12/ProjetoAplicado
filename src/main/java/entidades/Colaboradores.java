package entidades;

public class Colaboradores {

	private int id;
	private String nome;
	private Boolean habilitado;
	private String email;

	public Colaboradores() {
	}

	public Colaboradores(String nome, Boolean habilitado, String email) {
		this.nome = nome;
		this.habilitado = habilitado;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getHabilitado() {
		return habilitado;
	}

	public void setHabilitado(Boolean habilitado) {
		this.habilitado = habilitado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return getNome();
	}
}
