package org.animmagic.back.controllers;

import org.animmagic.back.dto.MemberDotationDTO;
import org.animmagic.back.services.MemberDotationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberDotationController {

	@Autowired
	MemberDotationServiceImpl memberDotationService;
	
	@PostMapping("/memberDotations")
	public ResponseEntity<Void> createMemberDotation(@RequestBody MemberDotationDTO memberDotationDTO) {
		this.memberDotationService.createMemberDotation(memberDotationDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
