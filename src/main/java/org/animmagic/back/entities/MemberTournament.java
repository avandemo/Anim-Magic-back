package org.animmagic.back.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class MemberTournament {
	
	@EmbeddedId
	MemberTournamentPK id = new MemberTournamentPK();
	
	Integer Score;
	Integer Points;

}
