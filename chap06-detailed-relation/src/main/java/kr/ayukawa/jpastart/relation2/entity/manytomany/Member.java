package kr.ayukawa.jpastart.relation2.entity.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
	@Id
	@Column(name="member_id")
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String username;

	@OneToMany(mappedBy="member")
	@Getter @Setter
	private List<Order> memberProducts = new ArrayList<>();
}
