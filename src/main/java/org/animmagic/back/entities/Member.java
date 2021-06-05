package org.animmagic.back.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Member {
	
	@Id
	String dci;
	String name;
	String firstName;
	String email;
	String login;
	@Column(name = "total_Points")
	Integer totalPoints;
	@OneToMany(mappedBy = "member")
	List<MemberDotation> dotations;

}
