package com.nttdata.controleestoque.estudoSpring.controller;

import com.nttdata.controleestoque.estudoSpring.model.UsuarioModel;
import com.nttdata.controleestoque.estudoSpring.repository.UsuarioRepository;
import com.nttdata.controleestoque.estudoSpring.validacoes.Perfis;
import com.nttdata.controleestoque.estudoSpring.validacoes.TratamentoExcecoes;
import com.nttdata.controleestoque.estudoSpring.validacoes.ValidaCpf;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Data
@RestController
@RequestMapping("/usuarios")
public class UsuarioController extends TratamentoExcecoes{

    @Autowired
    private UsuarioRepository usuarioRepository;

    TratamentoExcecoes tratamento = new TratamentoExcecoes();

    public TratamentoExcecoes getTratamento() {
        return tratamento;
    }

    public void setTratamento(TratamentoExcecoes tratamento) {
        this.tratamento = tratamento;
    }

    ValidaCpf cpf = new ValidaCpf();


    @GetMapping
    public List<UsuarioModel> listar(){
        return usuarioRepository.findAll();
    }


    @PostMapping
    public void salvar (@RequestBody UsuarioModel usuarioModel){
        usuarioRepository.save(usuarioModel);
    }

    @PutMapping
    public void alterar(@RequestBody UsuarioModel usuarioModel){
        usuarioRepository.save(usuarioModel);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> pesquisar(@PathVariable Long id){
        return usuarioRepository.findById(id);
    }

    public String atribuiPerfil(){
        Perfis perfil = new Perfis();

        if (perfil.getTipo_usuario().equals("adm")) {
            perfil.setTipo_usuario("Administrador");
        }else if (perfil.getTipo_usuario().equals("fr")) {
            perfil.setTipo_usuario("Fornecedor");
        }else if (perfil.getTipo_usuario().equals("cl")){
            perfil.setTipo_usuario("Cliente");
        }
        return  atribuiPerfil();
    }

}
