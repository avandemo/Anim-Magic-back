package org.animmagic.back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.animmagic.back.dto.FormatTypeDTO;
import org.animmagic.back.entities.FormatType;
import org.animmagic.back.repositories.FormatTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormatTypeServiceImpl {
	
	@Autowired
	FormatTypeRepository formatTypeRepo;
	
	private FormatTypeDTO entityTypeToDTO(FormatType formatType) {
		FormatTypeDTO formatTypeDto = new FormatTypeDTO();
		BeanUtils.copyProperties(formatType, formatTypeDto);
		return formatTypeDto;
	}
	
	public List<FormatTypeDTO> allFormatType() {
		return this.formatTypeRepo.findAll().stream().map(formatType -> entityTypeToDTO(formatType)).collect(Collectors.toList());
	}
	
	public void createFormatType(FormatTypeDTO formatTypeDTO) {
		FormatType formatType = new FormatType();
		BeanUtils.copyProperties(formatTypeDTO, formatType);
		formatTypeRepo.save(formatType);
	}

}
