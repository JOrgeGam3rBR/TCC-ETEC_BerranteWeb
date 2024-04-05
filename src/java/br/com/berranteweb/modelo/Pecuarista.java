package br.com.berranteweb.modelo;

public class Pecuarista extends Pessoa {
    private Integer idPecuarista;
    

    public Pecuarista() {
    }

    public Pecuarista(Integer idPecuarista, Integer id, String nome, String nomeUsuario, String cpf, String cidade, String estado, String cep, String email, String senha) {
        super(id, nome, nomeUsuario, cpf, cidade, estado, cep, email, senha);
        this.idPecuarista = idPecuarista;
    }

    public Integer getIdPecuarista() {
        return idPecuarista;
    }

    public void setIdPecuarista(Integer idPecuarista) {
        this.idPecuarista = idPecuarista;
    }


    
}
