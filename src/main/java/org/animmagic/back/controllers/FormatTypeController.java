package org.animmagic.back.controllers;

import java.util.List;

import org.animmagic.back.dto.FormatTypeDTO;
import org.animmagic.back.services.FormatTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatTypeController {
	
	@Autowired
	FormatTypeServiceImpl formatTypeService;
	
	@GetMapping("/formatType")
	public ResponseEntity<List<FormatTypeDTO>> allFormatType() {
		List<FormatTypeDTO> formatTypes = this.formatTypeService.allFormatType();
		return ResponseEntity.status(HttpStatus.OK).body(formatTypes);
	}
	
	@PostMapping("/formatType")
	public ResponseEntity<Void> createFormatType(@RequestBody FormatTypeDTO formatType) {
		this.formatTypeService.createFormatType(formatType);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
