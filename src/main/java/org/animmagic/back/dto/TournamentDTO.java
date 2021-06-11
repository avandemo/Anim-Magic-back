package org.animmagic.back.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TournamentDTO {
	
	Integer idTournament;
	Integer idFormat;
	String label;
	Date date;

}
