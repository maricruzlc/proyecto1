package com.proyecto.service;

import com.proyecto.service.*;
import com.proyecto.domain.usuario;
import java.util.List;

public interface UsuarioService {
// Se obtiene un listado de usuarios en un List    

    public List<usuario> getUsuarios(boolean activos);

// Se obtiene un Usuario, a partir del id de un usuario
   public usuario getUsuario(usuario usuario);
  
   // Se inserta un nuevo usuario si el id del usuario esta vacío
   // Se actualiza un usuario si el id del usuario NO esta vacío
   public void save(usuario usuario);
  
   // Se elimina el usuario que tiene el id pasado por parámetro
   public void delete(usuario usuario);




}
