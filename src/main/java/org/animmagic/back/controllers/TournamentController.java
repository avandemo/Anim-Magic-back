package org.animmagic.back.controllers;

import java.util.List;

import org.animmagic.back.dto.TournamentDTO;
import org.animmagic.back.services.TournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TournamentController {
	
	@Autowired
	TournamentServiceImpl tournamentService;
	
	@GetMapping("/tournaments")
	public ResponseEntity<List<TournamentDTO>> allTournaments() {
		List<TournamentDTO> listTournaments = tournamentService.allTournaments();
		return ResponseEntity.status(HttpStatus.OK).body(listTournaments);
	}
	
	@GetMapping("/tournaments/{idTournament}")
	public ResponseEntity<TournamentDTO> getTournament(@PathVariable("id_tournament") Integer idTournament) {
		TournamentDTO tournamentDTO = this.tournamentService.getTournament(idTournament);
		return ResponseEntity.status(HttpStatus.OK).body(tournamentDTO);
	}
	
	@PostMapping("/tournaments")
	public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentDTO tournament) {
		this.tournamentService.createTournament(tournament);
		return ResponseEntity.status(HttpStatus.CREATED).body(tournament);
	}

}
