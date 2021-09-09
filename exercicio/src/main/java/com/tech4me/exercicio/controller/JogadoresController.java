package com.tech4me.exercicio.controller;

import java.util.List;

import com.tech4me.exercicio.model.Jogadores;
import com.tech4me.exercicio.services.JogadoresServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/elenco")
public class JogadoresController {
    
    @Autowired
    JogadoresServiceImpl servicoJogadores;

    @GetMapping
    public List<Jogadores> obterTodos(){
       return servicoJogadores.obterTodos();
    }

    @GetMapping("/{id}")
    public Jogadores obterPorId(@PathVariable String id){
        /**
         * O @PathVariable pega o id que vem na url e transforma em uma variável ID do tipo String
         */
        return servicoJogadores.obterPorId(id);
    }

    @PostMapping
    public Jogadores adicionar(@RequestBody Jogadores jogadores){
        return servicoJogadores.adicionar(jogadores);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        servicoJogadores.deletar(id);
    }

    @PutMapping("/{id}")
    public Jogadores atualizar(
        @PathVariable String id, 
        @RequestBody Jogadores jogadores){
            
        return servicoJogadores.atualizar(id, jogadores);
    }

    /**
     * Tipos de escrita
     * 
     * PascalCase: AnaClaraDaSilva
     * camelCase:  anaClaraDaSilva
     * kibab-case: ana-clara
     * snake_case: ana_clara
     */
}
