/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author bONGANI
 */
@Entity(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue
    private int id;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "contacto",unique = true)
    private String contacto;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", contacto=" + contacto + '}';
    }
    
    
}
