package com.proyecto.domain;

import com.proyecto.domain.*;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria")

public class categoria implements Serializable { //serializacion porque se va almacenar ciertos datos en el disco

    private static final long serialVersionUID = 1L; //para poder hacer el ciclo de la sumatoria de la categoria.

    @Id //id categoria es la llave de la tabla categoria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Los valores generados que estrategia usan, identico a la BD
    @Column(name = "id_categoria") //decir cual es el nombre en la base de datos. Se hace la asociación
    private long idCategoria;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;
    
    
/*
   @OnetoMany
   @JoinColumn(name="id_categoria", updatable=false)
    List<producto> productos;
 
    private List<producto> productos;
    */
    
    public categoria() {
    }

    public categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }    
}
