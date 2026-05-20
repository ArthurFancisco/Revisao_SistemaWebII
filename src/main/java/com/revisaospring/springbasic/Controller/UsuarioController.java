package com.revisaospring.springbasic.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/usuarioCTR")
public class UsuarioController {
    
    @Autowired
    private UsuarioService oUsuarioService;

    @GetMapping("/main")
    public String telaMain() {
        return "main";
    }
    
    @GetMapping("/formCadastrarUsuario") // Corrigi o erro de digitação "foorm" também
    public String cadastrarUsuario(Model oModel) {
        oModel.addAttribute("usuario", new Usuario());
        return "cadastrarUsuario";
    }

    @GetMapping("/login")
    public String telaLogin() {
        return "login";
    }
    
    @PostMapping("/salvarUsuario")
    public String salvarUsuario(@ModelAttribute Usuario oUsuario) {
        oUsuarioService.cadastrarUsuario(oUsuario);
        // Garanta que o redirect aponte para o caminho correto
        return "redirect:/usuarioCTR/formCadastrarUsuario";
    }

    @GetMapping("/listarUsuarios")
    public String listarUsuarios(Model oModel) {

        oModel.addAttribute("usuarios", oUsuarioService.listarTodosUsers());
        return "listarUsuarios";

    }

}
