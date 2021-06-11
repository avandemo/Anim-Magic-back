package org.animmagic.back.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.animmagic.back.dto.TournamentDTO;
import org.animmagic.back.entities.FormatType;
import org.animmagic.back.entities.Tournament;
import org.animmagic.back.repositories.FormatTypeRepository;
import org.animmagic.back.repositories.TournamentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentServiceImpl {
	
	@Autowired
	TournamentRepository tournamentRepo;
	@Autowired
	FormatTypeRepository formatTypeRepo;
	
	private TournamentDTO entityToDTO(Tournament tournament) {
		TournamentDTO tournamentDTO = new TournamentDTO();
		BeanUtils.copyProperties(tournament, tournamentDTO);
		return tournamentDTO;
	}
	
	public List<TournamentDTO> allTournaments() {
		return this.tournamentRepo.findAll().stream().map(tournament -> entityToDTO(tournament)).collect(Collectors.toList());
	}
	
	public TournamentDTO getTournament(Integer id) {
		Optional<Tournament> tournamentOptional = this.tournamentRepo.findById(id);
		if (tournamentOptional.isPresent()) {
			return entityToDTO(tournamentOptional.get());
		}
		return null;
	}
	
	public void createTournament(TournamentDTO tournamentDTO) {
		Tournament tournament = new Tournament();
		BeanUtils.copyProperties(tournamentDTO, tournament);
		FormatType formatType = formatTypeRepo.getById(tournamentDTO.getIdFormat());
		tournament.setFormatType(formatType);
		tournamentRepo.save(tournament);
	}

}
