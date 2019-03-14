package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue
	@Column(name="member_id")
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private String city;

	@Getter @Setter
	private String street;

	@Getter @Setter
	private String zipcode;

	@OneToMany(mappedBy="member")
	@Getter @Setter
	private List<Order> orders = new ArrayList<>();
}
