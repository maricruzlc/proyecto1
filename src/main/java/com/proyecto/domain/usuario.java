package com.proyecto.domain;

import com.proyecto.domain.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")

public class usuario implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la usuario.

    @Id //id usuario es la llave de la tabla usuario.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD
    @Column(name = "id_usuario") //decir cual es el nombre en la base de datos. Se hace la asociación
    private long id_Usuario;
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String correo;
    private int telefono;
    private String rutaImagen;
    private boolean activo;
    

    
    public usuario() {
    }

    public usuario(String descripcion, boolean activo) {
        this.username = username;
        this.activo = activo;
    }    
}
