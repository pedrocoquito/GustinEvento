package br.evento.dao.impl;

import br.evento.dao.GenericsDao;
import br.evento.model.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class UsuarioDao extends GenericsDao<Usuario, String>{

    @Override
    public void save(Usuario obj) throws SQLException {
        try {
            conexao.getTransaction().begin();
            conexao.persist(obj);
            conexao.getTransaction().commit();
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void edit(Usuario obj) throws SQLException {
        try {
            conexao.getTransaction().begin();
            conexao.merge(obj);
            conexao.getTransaction().commit();
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public void delete(Usuario obj) throws SQLException {
        try {
            conexao.getTransaction().begin();
            conexao.remove(obj);
            conexao.getTransaction().commit();
        } catch (Exception e) {
            conexao.getTransaction().rollback();
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public List<Usuario> findAll() throws SQLException {
         try {
             Query q = conexao.createNamedQuery("Usuario.findAll");
             return q.getResultList();
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public Usuario findOne(String key) throws SQLException {
         try {
             Query q = conexao.createNamedQuery("Usuario.findByEmail");
             q.setParameter("email", key);
             return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch (NonUniqueResultException e) {
            throw new SQLException("Retornou mais de 1 registro");
        }catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    
    public Usuario findByLoginPassword(String login, String password) throws SQLException {
         try {
             Query q = conexao.createNamedQuery("Usuario.findByLoginPassword");
             q.setParameter("email", login);
             q.setParameter("senha", password);
             return (Usuario) q.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }catch (NonUniqueResultException e) {
            throw new SQLException("Retornou mais de 1 registro");
        }catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    @Override
    public long count() throws SQLException {
         try {
             Query q = conexao.createQuery("select count(u) from t_usuario u");
             return (long) q.getSingleResult();
        }catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }
    
}
