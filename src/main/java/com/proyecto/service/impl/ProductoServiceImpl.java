package com.proyecto.service.impl;

import com.proyecto.service.impl.*;
import com.proyecto.dao.ProductoDao;
import com.proyecto.domain.producto;
import com.proyecto.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<producto> getProductos(boolean activos) {
        var lista = productoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
   @Override
   @Transactional(readOnly = true)
   public producto getProducto(producto producto) {
       return productoDao.findById(producto.getIdProducto()).orElse(null);
   }

   @Override
   @Transactional
   public void save(producto producto) {
       productoDao.save(producto);
   }

   @Override
   @Transactional
   public void delete(producto producto) {
       productoDao.delete(producto);
   }

}
