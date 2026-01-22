package com.digis01.ISanchezPruebaCajero.JPA;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;
    
    @Column(name = "nombreusuario")
    private String nombreUsuario;
    
    @Column(name = "apellidoPatUsuario")
    private String apellidoPatUsuario;
    
    @Column(name = "apellidoMatUsuario")
    private String apellidoMatUsuario;
    
    @ManyToOne
    @JoinColumn(name = "idrol", nullable = false)
    public Rol Rol;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoPatUsuario() {
        return apellidoPatUsuario;
    }

    public void setApellidoPatUsuario(String apellidoPatUsuario) {
        this.apellidoPatUsuario = apellidoPatUsuario;
    }

    public String getApellidoMatUsuario() {
        return apellidoMatUsuario;
    }

    public void setApellidoMatUsuario(String apellidoMatUsuario) {
        this.apellidoMatUsuario = apellidoMatUsuario;
    }
    
    
}
