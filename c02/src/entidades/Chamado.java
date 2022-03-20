package entidades;

import java.util.Date;

public class Chamado {

  private int id;
  private Date data;
  private String cliente;
  private String endereco;
  private Double distancia;
  private Colaboradores colaboradores;
  private Veiculo veiculo;


  public Chamado(Date data, String cliente, String endereco, Double distancia, Colaboradores colaboradores, Veiculo veiculo) {
    this.data = data;
    this.cliente = cliente;
    this.endereco = endereco;
    this.distancia = distancia;
    this.colaboradores = colaboradores;
    this.veiculo = veiculo;
  }

  public Chamado() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public String getEndereco() {
    return endereco;
  }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }

  public Double getDistancia() {
    return distancia;
  }

  public void setDistancia(Double distancia) {
    this.distancia = distancia;
  }

  public Colaboradores getColaboradores() {
    return colaboradores;
  }

  public void setColaboradores(Colaboradores colaboradores) {
    this.colaboradores = colaboradores;
  }

  public Veiculo getVeiculo() {
    return veiculo;
  }

  public void setVeiculo(Veiculo veiculo) {
    this.veiculo = veiculo;
  }


  public double valorTotal(){
    double Calcular = distancia/veiculo.getAutonomia() *0.82 * 0.75 * 3.7;
    return Calcular;
  }
}
