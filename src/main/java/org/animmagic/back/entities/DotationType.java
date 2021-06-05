package org.animmagic.back.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class DotationType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idDotation;
	String label;
	Integer nbPoints;
	@OneToMany(mappedBy = "dotationType") 
	List<MemberDotation> memberDotations;
}
