package com.felixpessoa.dlist.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.felixpessoa.dlist.entity.GameList;
import com.felixpessoa.dlist.entity.dto.GameListDTO;
import com.felixpessoa.dlist.projections.GameMinProjection;
import com.felixpessoa.dlist.repository.GameListRepository;
import com.felixpessoa.dlist.repository.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream()
                .map(x -> new GameListDTO(x))
                .collect(Collectors.toList());
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

            int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
            int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for(int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }

    }

}
