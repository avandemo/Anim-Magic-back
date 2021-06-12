package org.animmagic.back.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javassist.SerialVersionUID;
import lombok.Data;

@Data
@Embeddable
public class MemberTournamentPK implements Serializable {
	
	private static final long SerialVersionUID = -438241814928979208L;
	
	@ManyToOne()
	@JoinColumn(name = "id_tournament")
	Tournament tournament;
	
	@ManyToOne()
	@JoinColumn(name = "dci")
	Member member;

}
