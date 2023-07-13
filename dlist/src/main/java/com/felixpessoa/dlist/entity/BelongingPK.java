package com.felixpessoa.dlist.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BelongingPK implements Serializable {
    
	@ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

	@ManyToOne
    @JoinColumn(name = "list_id")
    private GameList list;

   
}
