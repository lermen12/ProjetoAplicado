package entidades;

public class Veiculo {
	private int id;
	private String modelo;
	private Integer anoDeFabricacao;
	private Double autonomia;

	public Veiculo(String modelo, Integer anoDeFabricacao, Double autonomia) {
		this.modelo = modelo;
		this.anoDeFabricacao = anoDeFabricacao;
		this.autonomia = autonomia;
	}

	@Override
	public String toString() {
		return getModelo();
	}

	public Veiculo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getAnoDeFabricacao() {
		return anoDeFabricacao;
	}

	public void setAnoDeFabricacao(Integer anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}

	public Double getAutonomia() {
		return autonomia;
	}

	public void setAutonomia(Double autonomia) {
		this.autonomia = autonomia;
	}

}
