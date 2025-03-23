package com.meusite.ProjetoJavaWeb.controllers;

import com.meusite.ProjetoJavaWeb.model.Produto;
import com.meusite.ProjetoJavaWeb.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // ✅ LISTAR PRODUTOS
    @GetMapping("/listagem")
    public String listarProdutos(Model model) {
        List<Produto> produtos = produtoRepository.findAll();
        model.addAttribute("produtos", produtos);
        return "listagem"; // Deve existir um arquivo listagem.html no templates
    }

    // ✅ FORMULÁRIO PARA ADICIONAR PRODUTO
    @GetMapping("/adicionar")
    public String formularioAdicionar(Model model) {
        model.addAttribute("produto", new Produto());
        return "adicionar"; // Deve existir um adicionar.html no templates
    }

    // ✅ ADICIONAR PRODUTO
    @PostMapping("/adicionar")
    public String adicionarProduto(@ModelAttribute Produto produto) {
        produtoRepository.save(produto);
        return "redirect:/produtos/listagem"; // Redireciona para a listagem de produtos
    }

    // ✅ FORMULÁRIO PARA EDITAR PRODUTO
    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            model.addAttribute("produto", produtoOpt.get());
            return "editar"; // Deve existir um editar.html no templates
        } else {
            return "redirect:/produtos/listagem?erro=ProdutoNaoEncontrado";
        }
    }

    // ✅ ATUALIZAR PRODUTO
    @PostMapping("/atualizar/{id}")
    public String atualizarProduto(@PathVariable Long id, @ModelAttribute Produto produtoAtualizado) {
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setNome(produtoAtualizado.getNome());
            produto.setPreco(produtoAtualizado.getPreco());
            produtoRepository.save(produto);
            return "redirect:/produtos/listagem";
        } else {
            return "redirect:/produtos/listagem?erro=ProdutoNaoEncontrado";
        }
    }

    // ✅ DELETAR PRODUTO
    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable Long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return "redirect:/produtos/listagem";
        } else {
            return "redirect:/produtos/listagem?erro=ProdutoNaoEncontrado";
        }
    }
}
