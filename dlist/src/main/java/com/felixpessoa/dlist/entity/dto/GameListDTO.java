package com.felixpessoa.dlist.entity.dto;

import com.felixpessoa.dlist.entity.GameList;

import lombok.Data;

@Data
public class GameListDTO {
    
    private Long id;
    private String name;

    public GameListDTO(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }
}
