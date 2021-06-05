package org.animmagic.back.controllers;

import java.util.List;

import org.animmagic.back.dto.DotationTypeDTO;
import org.animmagic.back.services.DotationTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DotationTypeController {

	@Autowired
	DotationTypeServiceImpl dotationTypeService;
	
	@GetMapping("/dotationType")
	public ResponseEntity<List<DotationTypeDTO>> allDotationsType() {
		List<DotationTypeDTO> listDotationTypes = this.dotationTypeService.allDotationType();
		return ResponseEntity.status(HttpStatus.OK).body(listDotationTypes);
	}
	
	@PostMapping("/dotationType")
	public ResponseEntity<Void> createDotationType(@RequestBody DotationTypeDTO dotationType) {
		this.dotationTypeService.createDotationType(dotationType);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
}
