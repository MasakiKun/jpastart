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

	@ManyToOne
	@JoinColumn(name="item_id")
	@Getter @Setter
	private Item item;

	@ManyToOne
	@JoinColumn(name="order_id")
	@Getter
	private Order order;

	@Column(name="order_price", nullable=false)
	@Getter @Setter
	private int orderPrice;

	@Column(name="count", nullable=false)
	@Getter @Setter
	private int count;

	public void setOrder(Order order) {
		if(this.order != null)
			this.order.getOrderItems().remove(this);

		if(order != null) {
			this.order = order;
			this.order.getOrderItems().add(this);
		}
	}
}
