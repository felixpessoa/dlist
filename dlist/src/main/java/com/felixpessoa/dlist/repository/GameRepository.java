package com.felixpessoa.dlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felixpessoa.dlist.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
    
}
