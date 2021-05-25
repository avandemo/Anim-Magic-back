package org.animmagic.back.controllers;

import java.util.List;

import org.animmagic.back.dto.MemberDTO;
import org.animmagic.back.services.MembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MembersController {

	@Autowired
	MembersServiceImpl membersService;
	
	@GetMapping("/members")
	public ResponseEntity<List<MemberDTO>> allMembers() {
		List<MemberDTO> listMembers = this.membersService.allMembers();
		return ResponseEntity.status(HttpStatus.OK).body(listMembers);
	}
	
	@GetMapping("/members/{numDCI}")
	public ResponseEntity<MemberDTO> getMember(@PathVariable("numDCI") String numDCI) {
		MemberDTO member = this.membersService.getMember(numDCI);
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
	
	@PostMapping("/members")
	public ResponseEntity<MemberDTO> createMember(@RequestBody MemberDTO member) {
		return ResponseEntity.status(HttpStatus.OK).body(member);
	}
}
