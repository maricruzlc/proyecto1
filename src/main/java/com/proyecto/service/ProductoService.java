package com.proyecto.service;

import com.proyecto.service.*;
import com.proyecto.domain.producto;
import java.util.List;

public interface ProductoService {
// Se obtiene un listado de productos en un List    

    public List<producto> getProductos(boolean activos);

// Se obtiene un Producto, a partir del id de un producto
   public producto getProducto(producto producto);
  
   // Se inserta un nuevo producto si el id del producto esta vacío
   // Se actualiza un producto si el id del producto NO esta vacío
   public void save(producto producto);
  
   // Se elimina el producto que tiene el id pasado por parámetro
   public void delete(producto producto);




}
