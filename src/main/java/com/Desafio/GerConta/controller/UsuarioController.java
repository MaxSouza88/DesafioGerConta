package com.Desafio.GerConta.controller;

import com.Desafio.GerConta.model.ContasAPagarModel;
import com.Desafio.GerConta.model.UsuarioModel;
import com.Desafio.GerConta.repository.UsuarioRepository;
import com.Desafio.GerConta.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<UsuarioModel>> buscarTudo () {
        return ResponseEntity.ok(usuarioService.buscarNomes());
    }

    @GetMapping("/{id}")
    public Optional<UsuarioModel> buscaPorId ( Long id) {
        return usuarioRepository.findById(id);
    }

    @PostMapping
    public ResponseEntity<UsuarioModel> cadastraUsuario(@RequestBody UsuarioModel usuarioModel){
        UsuarioModel contas = usuarioService.cadastraUsuario(usuarioModel);
        return new ResponseEntity<>(contas, HttpStatus.CREATED);
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<UsuarioModel> alterarConta(@PathVariable Long id,@RequestBody UsuarioModel usuarioModel){
        if (!usuarioRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioService.alteraCadUsuario(usuarioModel));
    }

    @DeleteMapping(path = "/{id}")
    public void deletaConta(@PathVariable Long id){

        usuarioService.deletaUsuario(id);
    }


}
