package com.revisaospring.springbasic.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.revisaospring.springbasic.Entity.Usuario;
import com.revisaospring.springbasic.Repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository oUsuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    //É aqui que é gerado a criptografia da senha
    public void cadastrarUsuario(Usuario oUsuario) {

        //Realizando criptografia da senha
        oUsuario.setPassword(encoder.encode(oUsuario.getPassword()));

        //setando o valor padrão para a role de um usuário
        if(oUsuario.getRole() == null || oUsuario.getRole().isEmpty()){
            oUsuario.setRole("ROLE_USER");
        }

        oUsuarioRepository.save(oUsuario);  
    
    }

    public List<Usuario> listarTodosUsers() {
        return oUsuarioRepository.findAll();       
    }

}