package com.proyecto.service.impl;

import com.proyecto.service.impl.*;
import com.proyecto.dao.UsuarioDao;
import com.proyecto.domain.usuario;
import com.proyecto.service.UsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<usuario> getUsuarios(boolean activos) {
        var lista = usuarioDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
   @Override
   @Transactional(readOnly = true)
   public usuario getUsuario(usuario usuario) {
       return usuarioDao.findById(usuario.getId_Usuario()).orElse(null);
   }

   @Override
   @Transactional
   public void save(usuario usuario) {
       usuarioDao.save(usuario);
   }

   @Override
   @Transactional
   public void delete(usuario usuario) {
       usuarioDao.delete(usuario);
   }

}
