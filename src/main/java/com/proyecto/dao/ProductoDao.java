/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.proyecto.dao;

import com.proyecto.dao.*;
import com.proyecto.domain.producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author maric
 */
public interface ProductoDao extends JpaRepository <producto, Long> {
    
}
