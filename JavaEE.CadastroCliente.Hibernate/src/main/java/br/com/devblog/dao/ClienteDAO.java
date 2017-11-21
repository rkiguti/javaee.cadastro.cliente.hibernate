/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.devblog.dao;

import br.com.devblog.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kiguti
 */
public class ClienteDAO {
    
    @SuppressWarnings("unchecked")
    public List<Cliente> listar() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroJPA");
        EntityManager manager = factory.createEntityManager();
        
        List<Cliente> clientes;
        clientes = manager
            .createQuery("select c from Cliente as c")
            .getResultList();
            
        manager.close();
        factory.close();
        
        return clientes;
    }
    
    public Cliente obter(int id) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroJPA");
        EntityManager manager = factory.createEntityManager();
        
        Cliente cliente = manager.find(Cliente.class, id);
            
        manager.close();
        factory.close();
        
        return cliente;
    }
    
    public void incluir(Cliente c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroJPA");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();    
        manager.persist(c);
        manager.getTransaction().commit();
            
        manager.close();
        factory.close();
    }
    
    public void alterar(Cliente c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroJPA");
        EntityManager manager = factory.createEntityManager();
        
        manager.getTransaction().begin();    
        manager.merge(c);
        manager.getTransaction().commit();
            
        manager.close();
        factory.close();
    }
    
    public void excluir(Cliente c) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cadastroJPA");
        EntityManager manager = factory.createEntityManager();
        
        Cliente clienteBase = manager.find(Cliente.class, c.getId());
        
        manager.getTransaction().begin();    
        manager.remove(clienteBase);
        manager.getTransaction().commit();
            
        manager.close();
        factory.close();
    }
    
}
