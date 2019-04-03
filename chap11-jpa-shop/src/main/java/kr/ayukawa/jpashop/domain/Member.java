package kr.ayukawa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member {
	@Id
	@GeneratedValue
	@Column(name="MEMBER_ID")
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String name;

	@Embedded
	@Getter @Setter
	private Address address;

	@OneToMany(mappedBy="member")
	@Getter @Setter
	private List<Order> orders = new ArrayList<>();
}
