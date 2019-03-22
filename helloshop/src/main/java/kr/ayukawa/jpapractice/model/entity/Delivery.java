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

	@Embedded
	@Getter @Setter
	private Address address;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private DeliveryStatus status;
}
