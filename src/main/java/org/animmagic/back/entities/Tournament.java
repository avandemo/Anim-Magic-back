package org.animmagic.back.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idTournament;
	String label;
	Date date;
	
	@ManyToOne()
	@JoinColumn(name = "id_format")
	FormatType formatType;
	
	@OneToMany(mappedBy = "id.tournament")
	List<MemberTournament> memberTournament;

}
