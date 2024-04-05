package br.com.berranteweb.modelo;


public class Fazenda {
    private Integer idFazenda;
    private Pecuarista pecuarista;
    private String nomeFazenda;
    private String endereco;
    private String cidade;
    private String estado;

    public Fazenda() {
    }

    public Fazenda(Integer idFazenda, Pecuarista pecuarista, String nomeFazenda, String endereco, String numero, String cidade, String estado) {
        this.idFazenda = idFazenda;
        this.pecuarista = pecuarista;
        this.nomeFazenda = nomeFazenda;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Integer getIdFazenda() {
        return idFazenda;
    }

    public void setIdFazenda(Integer idFazenda) {
        this.idFazenda = idFazenda;
    }

    public Pecuarista getPecuarista() {
        return pecuarista;
    }

    public void setPecuarista(Pecuarista pecuarista) {
        this.pecuarista = pecuarista;
    }

    public String getNomeFazenda() {
        return nomeFazenda;
    }

    public void setNomeFazenda(String nomeFazenda) {
        this.nomeFazenda = nomeFazenda;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }



    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
   
}
