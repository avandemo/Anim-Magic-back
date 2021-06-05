package org.animmagic.back.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.animmagic.back.dto.MemberDTO;
import org.animmagic.back.entities.Member;
import org.animmagic.back.repositories.MemberRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl {

	@Autowired
	MemberRepository memberRepo;

	private MemberDTO entityToDTO(Member member) {
		MemberDTO memberDTO = new MemberDTO();
		BeanUtils.copyProperties(member, memberDTO); // Remplace les lignes ci-dessous (mêmes noms et types d'attributs)
		/*memberDTO.setDci(member.getDci());
		memberDTO.setFirstName(member.getFirstName());
		memberDTO.setName(member.getName());*/
		return memberDTO;
	}
	
	public List<MemberDTO> allMembers() {
		/*List<MemberDTO> membersListDto = new ArrayList<>();
		List<Member> listMembersFromRepo = this.memberRepo.findAll();
		for (Member member : listMembersFromRepo) {
			membersListDto.add(entityToDTO(member));
		}
		return membersListDto;*/
		
		return this.memberRepo.findAll().stream().map(member -> entityToDTO(member)).collect(Collectors.toList());
		//return this.memberRepo.findAll().stream().map(this :: entityToDTO).collect(Collectors.toList());
	}

	public MemberDTO getMember(String numDCI) {
		Optional<Member> memberOptional = this.memberRepo.findById(numDCI);
		if (memberOptional.isPresent()) {
			return entityToDTO(memberOptional.get());
		}
		return null;
	}

	public void createMember(MemberDTO memberDTO) {
		Member member = new Member();
		BeanUtils.copyProperties(memberDTO, member);
		memberRepo.save(member);
	}
	
	public void updateMember(MemberDTO memberDTO) {
		Optional<Member> memberOptional = this.memberRepo.findById(memberDTO.getDci());
		if (memberOptional.isPresent()) {
			Member member = memberOptional.get();
			BeanUtils.copyProperties(memberDTO, member);
			memberRepo.save(member);
		}
	}

}
