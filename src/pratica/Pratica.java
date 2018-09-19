/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pratica;

import Controle.ClienteDAO;
import Modelo.Cliente;
import javax.swing.JOptionPane;

/**
 *
 * @author bONGANI
 */
public class Pratica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente cliente = new Cliente();
        cliente.setNome("Helio");
        cliente.setContacto("007");
        
        ClienteDAO dao = new ClienteDAO();
//        dao.consultar("");
        if(dao.gravar(cliente)) JOptionPane.showMessageDialog(null,"Awesome!!");
    }
    
}
