package com.felixpessoa.dlist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixpessoa.dlist.entity.Game;
import com.felixpessoa.dlist.entity.dto.GameDTO;
import com.felixpessoa.dlist.entity.dto.GameMinDTO;
import com.felixpessoa.dlist.repository.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameDTO findById(long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream()
                .map(x -> new GameMinDTO(x))
                .collect(Collectors.toList());
    }

}
