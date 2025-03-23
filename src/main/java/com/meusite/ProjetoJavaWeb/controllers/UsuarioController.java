/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.meusite.ProjetoJavaWeb.controllers;

import com.meusite.ProjetoJavaWeb.model.Usuario;
import com.meusite.ProjetoJavaWeb.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.meusite.ProjetoJavaWeb.model.Usuario;
import com.meusite.ProjetoJavaWeb.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastro")
    public String exibirFormularioCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(@ModelAttribute Usuario usuario, Model model) {
        Object existente = usuarioService.buscarPorEmail(usuario.getEmail());
        if (existente != null) {
            model.addAttribute("erro", "E-mail já cadastrado!");
            return "cadastro";
        }
        usuarioService.salvarUsuario(usuario);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String exibirFormularioLogin() {
        return "login";
    }

    @PostMapping("/login")
        public String processarLogin(@RequestParam String email, @RequestParam String senha, Model model) {
            Usuario usuario = usuarioService.buscarPorEmail(email);
    if (usuario != null && usuario.getSenha().equals(senha)) {
        return "redirect:/listagem";
    }
    model.addAttribute("erro", "Credenciais inválidas!");
    return "login";
}   
}