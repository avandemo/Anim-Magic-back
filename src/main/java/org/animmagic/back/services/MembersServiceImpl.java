package org.animmagic.back.services;

import java.util.ArrayList;
import java.util.List;

import org.animmagic.back.dto.MemberDTO;
import org.springframework.stereotype.Service;

@Service
public class MembersServiceImpl {

	public List<MemberDTO> allMembers() {
		List<MemberDTO> membersList = new ArrayList<>();
		MemberDTO member = new MemberDTO();
		member.setDci("5454545488");
		member.setFirstName("DUPOND");
		member.setName("toto");
		membersList.add(member);
		return membersList;
	}
	
	public MemberDTO getMember(String numDCI) {
		MemberDTO member = new MemberDTO();
		member.setDci(numDCI);
		member.setFirstName("DURAND");
		member.setName("Mohammed");
		return member;
	}
	
}
