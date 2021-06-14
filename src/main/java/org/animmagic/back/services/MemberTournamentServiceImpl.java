package org.animmagic.back.services;

import java.util.Optional;

import org.animmagic.back.dto.MemberTournamentDTO;
import org.animmagic.back.entities.Member;
import org.animmagic.back.entities.MemberTournament;
import org.animmagic.back.entities.MemberTournamentPK;
import org.animmagic.back.entities.Tournament;
import org.animmagic.back.repositories.MemberRepository;
import org.animmagic.back.repositories.MemberTournamentRepository;
import org.animmagic.back.repositories.TournamentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberTournamentServiceImpl {
	
	@Autowired
	MemberTournamentRepository memberTournamentRepo;
	@Autowired
	MemberRepository memberRepo;
	@Autowired
	TournamentRepository tournamentRepo;
	
	private void copyPropertiesCascade(MemberTournament memberTournament) {
		
		Member member = memberRepo.getById(memberTournament.getId().getMember().getDci());
		memberTournament.setMember(member);
		Tournament tournament = tournamentRepo.getById(memberTournament.getId().getTournament().getIdTournament());
		memberTournament.setTournament(tournament);
		
	}
	
	public void createMemberTournament(MemberTournamentDTO memberTournamentDTO) {
		
		MemberTournament memberTournament = new MemberTournament();
		BeanUtils.copyProperties(memberTournamentDTO, memberTournament);
		copyPropertiesCascade(memberTournament);
		memberTournamentRepo.save(memberTournament);
		
	}
	
	public void updateMemberTournament(MemberTournamentDTO memberTournamentDTO) {
		
		Optional<MemberTournament> memberTournamentOptional = this.memberTournamentRepo.findById(memberTournamentDTO.getId());
		if (memberTournamentOptional.isPresent()) {
			MemberTournament memberTournament = memberTournamentOptional.get();
			BeanUtils.copyProperties(memberTournamentDTO, memberTournament);
			copyPropertiesCascade(memberTournament);
			memberTournamentRepo.save(memberTournament);
		}
	}

}
