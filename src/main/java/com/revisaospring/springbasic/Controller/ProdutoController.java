package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/produtoCTR")
public class ProdutoController {
    @Autowired
    private ProdutoService oProdutoService;
    @GetMapping("/listarprodutos")
    public String telaListarProduto(Model oModel) {
        oModel.addAttribute("produtos", oProdutoService.buscarTodos());
        return "listarProdutos";
    }
    

}
