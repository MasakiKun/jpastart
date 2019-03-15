package kr.ayukawa.jpastart.relation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
public class Member {
	@Id
	@Column(name="member_id")
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String username;

	@ManyToOne
	@JoinColumn(name="team_id")
	@Getter @Setter
	private Team team;

	public Member() {}
	public Member(String id, String username) {
		this.id = id;
		this.username = username;
	}
}
