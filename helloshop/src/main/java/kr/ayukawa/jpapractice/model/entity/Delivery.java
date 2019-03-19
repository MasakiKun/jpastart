package kr.ayukawa.jpapractice.model.entity;

import kr.ayukawa.jpapractice.enums.DeliveryStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name="delivery_id")
	@Getter @Setter
	private long id;

	@OneToOne(mappedBy="delivery", fetch=FetchType.LAZY)
	@Getter @Setter
	private Order order;

	@Getter @Setter
	private String city;

	@Getter @Setter
	private String street;

	@Getter @Setter
	private String zipcode;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private DeliveryStatus status;
}
