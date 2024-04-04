/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author maric
 */
public class LoginController {
   
@Controller
public class AuthController {

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        return "Iniciando sesión con usuario: " + username;
    }

    @PostMapping("/register")
    @ResponseBody
    public String register(@RequestParam String username, @RequestParam String password) {
        return "Registrando nuevo usuario: " + username;
    }
}

}
