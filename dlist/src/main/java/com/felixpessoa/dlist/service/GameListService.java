package com.felixpessoa.dlist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixpessoa.dlist.entity.GameList;
import com.felixpessoa.dlist.entity.dto.GameListDTO;
import com.felixpessoa.dlist.repository.GameListRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream()
                .map(x -> new GameListDTO(x))
                .collect(Collectors.toList());
    }

}
