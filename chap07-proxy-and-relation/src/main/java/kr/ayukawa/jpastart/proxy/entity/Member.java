package kr.ayukawa.jpastart.proxy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Member {
	@Id
	@Column(name="member_id")
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String name;

	@ManyToOne
	@Getter @Setter
	private Team team;

	@Override
	public String toString() {
		return String.format(
				"Member [id=%s, name=%s, team=%s",
				this.id,
				this.name,
				this.team.getTeamName()
		);
	}
}
