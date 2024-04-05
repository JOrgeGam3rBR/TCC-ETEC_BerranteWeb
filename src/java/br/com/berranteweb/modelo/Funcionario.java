package br.com.berranteweb.modelo;


public class Funcionario extends Pessoa{
    private Integer idFuncionario;
    private Fazenda fazenda;
    private String trabalho;
    private Double salario;
    
    public Funcionario() {
    }

    public Funcionario(Integer idFuncionario, Fazenda fazenda, String trabalho, Double salario, Integer id, String nome, String nomeUsuario, String cpf, String cidade, String estado, String cep, String email, String senha) {
        super(id, nome, nomeUsuario, cpf, cidade, estado, cep, email, senha);
        this.idFuncionario = idFuncionario;
        this.fazenda = fazenda;
        this.trabalho = trabalho;
        this.salario = salario;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public String getTrabalho() {
        return trabalho;
    }

    public void setTrabalho(String trabalho) {
        this.trabalho = trabalho;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    
    
    
}
