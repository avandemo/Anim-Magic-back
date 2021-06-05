package org.animmagic.back.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class MemberDotation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	Date date;
	@ManyToOne()
	@JoinColumn(name = "dci")
	Member member;
	
	@ManyToOne()
	@JoinColumn(name = "id_dotation")
	DotationType dotationType;
	
}
