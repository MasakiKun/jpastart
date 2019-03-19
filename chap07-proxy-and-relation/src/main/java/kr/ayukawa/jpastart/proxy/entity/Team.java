package kr.ayukawa.jpastart.proxy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@ToString
public class Team {
	@Id
	@Column(name="team_id")
	@Getter @Setter
	private String id;

	@Column(name="name")
	@Getter @Setter
	private String teamName;
}
