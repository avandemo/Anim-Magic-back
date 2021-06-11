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
public class FormatType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idFormat;
	String label;
	
	@OneToMany(mappedBy = "formatType")
	List<Tournament> tournaments;
}
