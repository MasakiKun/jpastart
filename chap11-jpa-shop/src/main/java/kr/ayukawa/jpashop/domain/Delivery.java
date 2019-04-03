package kr.ayukawa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
public class Delivery {
	@Id
	@GeneratedValue
	@Column(name="DELIVERY_ID")
	private Long id;

	@OneToOne(mappedBy="delivery")
	@Getter @Setter
	private Order order;

	@Embedded
	@Getter @Setter
	private Address address;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private DeliveryStatus status;

	public Delivery() {}

	public Delivery(Address address) {
		this.address = address;
		this.status = DeliveryStatus.READY;
	}
}
