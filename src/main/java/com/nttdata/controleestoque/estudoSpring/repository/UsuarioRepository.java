package com.nttdata.controleestoque.estudoSpring.repository;

import com.nttdata.controleestoque.estudoSpring.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Long> {

}
