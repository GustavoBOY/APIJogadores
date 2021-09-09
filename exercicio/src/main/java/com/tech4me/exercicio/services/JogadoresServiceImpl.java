package com.tech4me.exercicio.services;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.tech4me.exercicio.model.Jogadores;
import com.tech4me.exercicio.repository.JogadoresRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadoresServiceImpl implements JogadoresService {
    
    @Autowired
    JogadoresRepository repositorioJogadores;

    @Override
    public List<Jogadores> obterTodos() {
        // Pega todos os Jogadoress do banco.
        return repositorioJogadores.findAll();
    }

    @Override
    public Jogadores obterPorId(String idJogadores) {
        Optional<Jogadores> jogadores = repositorioJogadores.findById(idJogadores);
       
        if(jogadores.isEmpty()){
            throw new InputMismatchException("Jogador não encontrado com o ID: " + idJogadores);
        }

        return jogadores.get();
    }

    @Override
    public Jogadores adicionar(Jogadores jogadores) {
       // Remover o id para garantir que vou adicionar.
       jogadores.setId(null);

       // Metodo save serve para adicionar
       return repositorioJogadores.save(jogadores);
    }

    @Override
    public void deletar(String idJogadores) {
        Optional<Jogadores> jogadores = repositorioJogadores.findById(idJogadores);

        if(jogadores.isEmpty()){
            throw new InputMismatchException("Não é possível deletar o Jogadores com o ID: " + idJogadores + " - Jogadores não encontrado");
        }

        repositorioJogadores.deleteById(idJogadores);
    }

    @Override
    public Jogadores atualizar(String idJogadores, Jogadores jogadores) {
        // Passando o id do Jogadores para o proprio Jogadores.
        // Eles vem separado na requisição  do tipo PUT 
        jogadores.setId(idJogadores);
        
        // Metodo save serve para atualizar
        return repositorioJogadores.save(jogadores);

        /**
         * O metodo save adiciona caso o id seja null, caso tenha id, ele atualiza.
        */
    }


}
