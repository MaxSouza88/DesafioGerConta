package com.Desafio.GerConta.service;

import com.Desafio.GerConta.model.UsuarioModel;
import com.Desafio.GerConta.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioModel> buscarNomes(){

        return usuarioRepository.findAll();
    }

    public Optional<UsuarioModel> buscarNomeId(Long id){

        return usuarioRepository.findById(id);
    }

    public UsuarioModel cadastraUsuario(UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public UsuarioModel alteraCadUsuario (UsuarioModel usuarioModel){

        return usuarioRepository.save(usuarioModel);
    }

    public void deletaUsuario(Long id){
        usuarioRepository.deleteById(id);
    }


}
