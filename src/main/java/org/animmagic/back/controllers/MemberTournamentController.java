package org.animmagic.back.controllers;

import org.animmagic.back.dto.MemberTournamentDTO;
import org.animmagic.back.services.MemberTournamentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberTournamentController {
	
	@Autowired
	MemberTournamentServiceImpl memberTournamentService;
	
	@PostMapping("/memberTournament")
	public ResponseEntity<Void> createMemberTournament(@RequestBody MemberTournamentDTO memberTournamentDTO) {
		this.memberTournamentService.createMemberTournament(memberTournamentDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/memberTournament")
	public ResponseEntity<Void> updateMemberTournament(@RequestBody MemberTournamentDTO memberTournamentDTO) {
		this.memberTournamentService.updateMemberTournament(memberTournamentDTO);
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
