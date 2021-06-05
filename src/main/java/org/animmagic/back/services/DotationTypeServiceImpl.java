package org.animmagic.back.services;

import java.util.List;
import java.util.stream.Collectors;

import org.animmagic.back.dto.DotationTypeDTO;
import org.animmagic.back.entities.DotationType;
import org.animmagic.back.repositories.DotationTypeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DotationTypeServiceImpl {
	
	@Autowired
	DotationTypeRepository dotationTypeRepo;
	
	private DotationTypeDTO entityToDTO(DotationType dotationType) {
		DotationTypeDTO dotationTypeDto = new DotationTypeDTO();
		BeanUtils.copyProperties(dotationType, dotationTypeDto);
		return dotationTypeDto;
	}
	
	public List<DotationTypeDTO> allDotationType() {
		return this.dotationTypeRepo.findAll().stream().map(dotationType -> entityToDTO(dotationType)).collect(Collectors.toList());
	}
	
	public void createDotationType(DotationTypeDTO dotationTypeDTO) {
		DotationType dotationType = new DotationType();
		BeanUtils.copyProperties(dotationTypeDTO, dotationType);
		dotationTypeRepo.save(dotationType);
	}

}
