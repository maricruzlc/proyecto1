package com.proyecto.controller;

import com.proyecto.domain.carrito;
import com.proyecto.service.CarritoService;
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
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var carritos = carritoService.getCarritos(false);
        model.addAttribute("carritos", carritos);
        model.addAttribute("totalCarritos", carritos.size());
        return "/carrito/listado";
    }
   
    @GetMapping("/nuevo")
   public String carritoNuevo(carrito carrito) {
       return "/carrito/modifica";
   }

   @Autowired
   private FirebaseStorageServiceImpl firebaseStorageService;
  
   @PostMapping("/guardar")
   public String carritoGuardar(carrito carrito,
           @RequestParam("imagenFile") MultipartFile imagenFile) {       
       if (!imagenFile.isEmpty()) {
           carritoService.save(carrito);
           carrito.setRutaImagen(
                   firebaseStorageService.cargaImagen(
                           imagenFile,
                           "carrito",
                           carrito.getIdCarrito()));
       }
       carritoService.save(carrito);
       return "redirect:/carrito/listado";
   }

   @GetMapping("/eliminar/{idCarrito}")
   public String carritoEliminar(carrito carrito) {
       carritoService.delete(carrito);
       return "redirect:/carrito/listado";
   }

   @GetMapping("/modifica/{idCarrito}")
   public String carritoModificar(carrito carrito, Model model) {
       carrito = carritoService.getCarrito(carrito);
       model.addAttribute("carrito", carrito);
       return "/carrito/modifica";
   }
    
    
}
