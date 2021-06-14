package org.animmagic.back.dto;

import org.animmagic.back.entities.MemberTournamentPK;

import lombok.Data;

@Data
public class MemberTournamentDTO {
	
	//String dci;
	//Integer idTournament;
	MemberTournamentPK id;
	Integer score;
	Integer points;

}
