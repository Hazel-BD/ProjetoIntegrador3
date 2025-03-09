package com.meusite.ProjetoJavaWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Página inicial
    @GetMapping("/")
    public String home() {
        return "index";  // Redireciona para index.html
    }

    // Página de cadastro
    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";  // Redireciona para cadastro.html
    }

    // Página de login
    @GetMapping("/login")
    public String login() {
        return "login";  // Redireciona para login.html
    }

    // Página de listagem
    @GetMapping("/listagem")
    public String listagem() {
        return "listagem";  // Redireciona para listagem.html
    }
}
