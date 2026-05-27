package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Produto;
import com.revisaospring.springbasic.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller


@RequestMapping("/produtoCTR")
public class ProdutoController {
    @Autowired
    private ProdutoService oProdutoService; 

    @GetMapping("/listarProdutos")
    public String telaListarProduto(Model oModel) {
        oModel.addAttribute("produtos", oProdutoService.buscarTodos());
        return "listarProdutos";
    }

    @GetMapping("/formCadastrar")
    public String telaCadastrarProduto(Model oModel) {
        oModel.addAttribute("produto", new Produto());
        return "cadastrarProduto";
    }

   @PostMapping("/salvarProduto")
   public String cadastrarProduto(@ModelAttribute Produto oProduto) {
        oProdutoService.cadastraProduto(oProduto);
       return "redirect:/produtoCTR/listarProdutos";
   }
       
@GetMapping("formAlterar/{id}")
public String telaAlterarProduto(@PathVariable Long id, Model oModel){

    Produto oProduto = oProdutoService.buscarPorId(id).orElseThrow(
        () -> new IllegalArgumentException("Produto não encontrado"));

    oModel.addAttribute("produtoEditar", oProduto);
    return "editarProduto";
    }

    @PostMapping("/alterarProduto/{id}")
    public String alterarProduto(@PathVariable Long id, @ModelAttribute Produto oProduto){
        oProdutoService.alterarProduto(oProduto, id);
        return "redirect:/produtoCTR/listarProdutos";
    }
    

    @GetMapping("/deletarProduto/{id}")
    public String deletarproduto(@PathVariable long id) {

        oProdutoService.deletarProduto(id);
        return "redirect:/produtoCTR/listarProdutos";
    }
    

    }
    

