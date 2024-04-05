package br.com.berranteweb.dao;

import java.util.List;


public interface GenericDAO {
    
    public Boolean cadastrar(Object object) throws Exception;
    
    public List<Object> listar() throws Exception;
    
    public Boolean excluir(Integer id) throws Exception;
    
    public Object carregar(Integer id) throws Exception;
    
    public Boolean alterar(Object object) throws Exception;
}
