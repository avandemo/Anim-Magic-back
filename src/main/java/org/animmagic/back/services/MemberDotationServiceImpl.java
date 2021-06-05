package org.animmagic.back.services;

import java.util.Date;

import org.animmagic.back.dto.MemberDotationDTO;
import org.animmagic.back.entities.DotationType;
import org.animmagic.back.entities.Member;
import org.animmagic.back.entities.MemberDotation;
import org.animmagic.back.repositories.DotationTypeRepository;
import org.animmagic.back.repositories.MemberDotationRepository;
import org.animmagic.back.repositories.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberDotationServiceImpl {

	@Autowired
	MemberDotationRepository memberDotationRepo;
	@Autowired
	MemberRepository memberRepo;
	@Autowired
	DotationTypeRepository dotationTypeRepo;
	
	public void createMemberDotation(MemberDotationDTO memberDotationDTO) {
		MemberDotation memberDotation = new MemberDotation();
		BeanUtils.copyProperties(memberDotationDTO, memberDotation);
		memberDotation.setDate(new Date());
		DotationType dotationType = dotationTypeRepo.getById(memberDotationDTO.getIdDotation());
		memberDotation.setDotationType(dotationType);
		Member  member = memberRepo.getById(memberDotationDTO.getDci());
		member.setTotalPoints(member.getTotalPoints() - dotationType.getNbPoints());
		memberDotation.setMember(member);
		memberDotationRepo.save(memberDotation);
	}
	
}
