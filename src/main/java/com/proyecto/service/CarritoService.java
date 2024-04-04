package com.proyecto.service;

import com.proyecto.service.*;
import com.proyecto.domain.carrito;
import java.util.List;

public interface CarritoService {
// Se obtiene un listado de carritos en un List    

    public List<carrito> getCarritos(boolean activos);

// Se obtiene un Carrito, a partir del id de un carrito
   public carrito getCarrito(carrito carrito);
  
   // Se inserta un nuevo carrito si el id del carrito esta vacío
   // Se actualiza un carrito si el id del carrito NO esta vacío
   public void save(carrito carrito);
  
   // Se elimina el carrito que tiene el id pasado por parámetro
   public void delete(carrito carrito);




}
