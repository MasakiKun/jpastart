package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="members")
public class Member extends BaseEntity {
	@Id
	@GeneratedValue
	@Column(name="member_id")
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
