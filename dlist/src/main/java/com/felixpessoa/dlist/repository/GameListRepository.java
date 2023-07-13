package com.felixpessoa.dlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felixpessoa.dlist.entity.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    
}
