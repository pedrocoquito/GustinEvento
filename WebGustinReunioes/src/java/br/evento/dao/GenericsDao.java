package br.evento.dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class GenericsDao<C, K> {
    
    protected EntityManager conexao;
    private EntityManagerFactory emf;

    public GenericsDao() {
        emf = Persistence.createEntityManagerFactory("WebGustinReunioesPU");
        conexao = emf.createEntityManager();
    }

    public EntityManager getConexao() {
        return conexao;
    }
    
    public void close(){
        conexao.close();
        emf.close();
    }
    
    public abstract void save(C obj) throws SQLException;
    public abstract void edit(C obj) throws SQLException;
    public abstract void delete(C obj) throws SQLException;
    
    public abstract List<C> findAll()throws SQLException;
    public abstract C findOne(K key)throws SQLException;
    public abstract long count()throws SQLException;
    
}
