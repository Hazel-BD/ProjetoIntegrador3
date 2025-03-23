package com.meusite.ProjetoJavaWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private List<String> usuarios = new ArrayList<>(); // Lista temporária de usuários

    @GetMapping
    public String index() {
        return "index";
    }

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String processaCadastro(@RequestParam String nome, @RequestParam String email) {
        usuarios.add(nome + " - " + email); // Adiciona à lista de usuários
        System.out.println("Cadastrado: " + nome + " | " + email);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processaLogin(@RequestParam String email, @RequestParam String senha) {
        System.out.println("Login com: " + email);
        return "redirect:/listagem";
    }

    @GetMapping("/listagem")
    public String listagem(org.springframework.ui.Model model) {
        model.addAttribute("usuarios", usuarios); // Envia a lista para o HTML
        return "listagem";
    }

    @PostMapping("/adicionar")
    public String adicionarUsuario(@RequestParam String nome, @RequestParam String email) {
        usuarios.add(nome + " - " + email);
        return "redirect:/listagem";
    }

    @PostMapping("/excluir")
    public String excluirUsuario(@RequestParam int index) {
        if (index >= 0 && index < usuarios.size()) {
            usuarios.remove(index);
        }
        return "redirect:/listagem";
    }
}