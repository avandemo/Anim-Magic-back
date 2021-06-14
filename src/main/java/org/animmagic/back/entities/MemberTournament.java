package org.animmagic.back.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class MemberTournament {
	
	@EmbeddedId
	MemberTournamentPK id = new MemberTournamentPK();
	
	Integer Score;
	Integer Points;
	
	@ManyToOne()
	@JoinColumn(name = "id.dci")
	Member member;
	
	@ManyToOne()
	@JoinColumn(name = "id.id_tournament")
	Tournament tournament;

}
