/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Modelo.Cliente;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import util.Arquivo;

/**
 *
 * @author bONGANI
 */
public class ClienteDAO {
    public boolean gravar(Cliente cliente){
        SessionFactory sf = Arquivo.getSessionFactory();
        Session sec = sf.openSession();
        Transaction tx = sec.beginTransaction();
        
        try {
            sec.save(cliente);
            tx.commit();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally{
            sec.close();
        }
    }
    public boolean atualizar(Cliente cliente){
        SessionFactory sf = Arquivo.getSessionFactory();
        Session sec = sf.openSession();
        Transaction tx = sec.beginTransaction();
        
        try {
            sec.merge(cliente);
            tx.commit();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally{
            sec.close();
        }
    }
    public boolean remover(Cliente cliente){
        SessionFactory sf = Arquivo.getSessionFactory();
        Session sec = sf.openSession();
        Transaction tx = sec.beginTransaction();
        
        try {
            sec.delete(cliente);
            tx.commit();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return false;
        } finally{
            sec.close();
        }
    }
    public void consultar(String chave){
        SessionFactory sf = Arquivo.getSessionFactory();
        Session sec = sf.openSession();
        
        Criteria c = sec.createCriteria(Cliente.class);
        c.add(Restrictions.like("nome", chave, MatchMode.ANYWHERE));
        
        List<Cliente> list = c.list();
        if(list.size()>0){
            for(Cliente cli : list){
                System.out.println(cli);
            }
        } else{
            JOptionPane.showMessageDialog(null,"Nao encontrado!");
        }
    }
}
