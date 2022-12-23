package com.nttdata.controleestoque.estudoSpring.security;

import com.nttdata.controleestoque.estudoSpring.model.UsuarioModel;
import com.nttdata.controleestoque.estudoSpring.repository.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UsuarioRepository usuarioRepository;

    PasswordEncoder passwordEncoder;


    public UserService (UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public UsuarioModel salvar(UsuarioModel usuarioModel){
        String encodedPassword = this.passwordEncoder.encode(usuarioModel.getSenha());
        usuarioModel.setSenha(encodedPassword);
        return this.usuarioRepository.save(usuarioModel);
    }

}
