package com.proyecto.service.impl;

import com.proyecto.service.impl.*;
import com.proyecto.dao.CarritoDao;
import com.proyecto.domain.carrito;
import com.proyecto.service.CarritoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoDao carritoDao;

    @Override
    @Transactional(readOnly = true)
    public List<carrito> getCarritos(boolean activos) {
        var lista = carritoDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
   @Override
   @Transactional(readOnly = true)
   public carrito getCarrito(carrito carrito) {
       return carritoDao.findById(carrito.getIdCarrito()).orElse(null);
   }

   @Override
   @Transactional
   public void save(carrito carrito) {
       carritoDao.save(carrito);
   }

   @Override
   @Transactional
   public void delete(carrito carrito) {
       carritoDao.delete(carrito);
   }

}
