package com.tech4me.exercicio.services;

import java.util.List;

import com.tech4me.exercicio.model.Jogadores;

public interface JogadoresService {
    
    List<Jogadores> obterTodos();
    
    Jogadores obterPorId(String idJogadores);
    
    Jogadores adicionar(Jogadores Jogadores);
    
    Jogadores atualizar(String idJogadores, Jogadores Jogadores);
    
    void deletar(String idJogadores);
}
