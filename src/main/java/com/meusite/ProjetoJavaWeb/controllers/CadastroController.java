package com.meusite.ProjetoJavaWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cadastro")
public class CadastroController {

    @GetMapping("/novo") // URL alterada para evitar conflito
    public String novoCadastro() {
        return "cadastroForm"; // Retorna a página cadastroForm.html
    }
}
