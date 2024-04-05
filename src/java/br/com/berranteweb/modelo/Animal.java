package br.com.berranteweb.modelo;
    


import java.util.Date;

public class Animal {
    private Integer idAnimal;
    private Fazenda fazenda;
    private Integer brinco;
    private String raca;
    private String sexo;
    private Date dataNasc;
    private String tipo;
    private String status;

    public Animal() {
    }

    public Animal(Integer idAnimal, Fazenda fazenda, Integer brinco, String raca, String sexo, Date dataNasc, String tipo, String status) {
        this.idAnimal = idAnimal;
        this.fazenda = fazenda;
        this.brinco = brinco;
        this.raca = raca;
        this.sexo = sexo;
        this.dataNasc = dataNasc;
        this.tipo = tipo;
        this.status = status;
    }

    public Integer getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Integer idAnimal) {
        this.idAnimal = idAnimal;
    }

    public Fazenda getFazenda() {
        return fazenda;
    }

    public void setFazenda(Fazenda fazenda) {
        this.fazenda = fazenda;
    }

    public Integer getBrinco() {
        return brinco;
    }

    public void setBrinco(Integer brinco) {
        this.brinco = brinco;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   
    
    
    
    
    
}
