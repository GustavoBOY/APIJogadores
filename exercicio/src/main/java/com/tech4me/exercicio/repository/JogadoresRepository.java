package com.tech4me.exercicio.repository;

import com.tech4me.exercicio.model.Jogadores;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadoresRepository extends MongoRepository<Jogadores, String>{
    
}
