package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_item")
public class OrderItem {
	@Id
	@GeneratedValue
	@Column(name="order_item_id")
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private Long itemId;

	@Getter @Setter
	private Long orderId;

	@Column(name="order_price", nullable=false)
	@Getter @Setter
	private int orderPrice;

	@Column(name="count", nullable=false)
	@Getter @Setter
	private int count;
}
