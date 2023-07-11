package com.felixpessoa.dlist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felixpessoa.dlist.entity.Game;
import com.felixpessoa.dlist.entity.dto.GameMinDTO;
import com.felixpessoa.dlist.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

}
