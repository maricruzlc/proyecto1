package com.proyecto.controller;

import com.proyecto.domain.usuario;
import com.proyecto.service.UsuarioService;
import com.proyecto.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var usuarios = usuarioService.getUsuarios(false);
        model.addAttribute("usuarios", usuarios);
        model.addAttribute("totalUsuarios", usuarios.size());
        return "/usuario/listado";
    }
   
    @GetMapping("/nuevo")
   public String usuarioNuevo(usuario usuario) {
       return "/usuario/modifica";
   }

   @Autowired
   private FirebaseStorageServiceImpl firebaseStorageService;
  
   @PostMapping("/guardar")
   public String usuarioGuardar(usuario usuario,
           @RequestParam("imagenFile") MultipartFile imagenFile) {       
       if (!imagenFile.isEmpty()) {
           usuarioService.save(usuario);
           usuario.setRutaImagen(
                   firebaseStorageService.cargaImagen(
                           imagenFile,
                           "usuario",
                           usuario.getId_Usuario()));
       }
       usuarioService.save(usuario);
       return "redirect:/usuario/listado";
   }

   @GetMapping("/eliminar/{id_Usuario}")
   public String usuarioEliminar(usuario usuario) {
       usuarioService.delete(usuario);
       return "redirect:/usuario/listado";
   }

   @GetMapping("/modifica/{id_Usuario}")
   public String usuarioModificar(usuario usuario, Model model) {
       usuario = usuarioService.getUsuario(usuario);
       model.addAttribute("usuario", usuario);
       return "/usuario/modifica";
   }
    
    
}
