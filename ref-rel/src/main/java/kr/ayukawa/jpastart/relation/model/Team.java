package kr.ayukawa.jpastart.relation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
public class Team {
	@Id
	@Column(name="team_id")
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String name;

	@OneToMany(mappedBy="team")
	@Getter @Setter
	private List<Member> members = new ArrayList<>();

	public Team() {}
	public Team(String id, String name) {
		this.id = id;
		this.name = name;
	}
}
