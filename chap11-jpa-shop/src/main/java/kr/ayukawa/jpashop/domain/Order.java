package kr.ayukawa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="ORDERS")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="ORDER_ID")
	@Getter @Setter
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="MEMBER_ID")
	@Getter
	private Member member;

	@OneToMany(mappedBy="order", cascade=CascadeType.ALL)
	@Getter @Setter
	private List<OrderItem> orderItems = new ArrayList<>();

	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="DELIVERY_ID")
	@Getter
	private Delivery delivery;

	@Getter @Setter
	private Date orderDate;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OrderStatus status;

	// factory
	public static Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
		Order order = new Order();
		order.setMember(member);
		order.setDelivery(delivery);
		for(OrderItem orderItem : orderItems) {
			order.addOrderItem(orderItem);
		}
		order.setStatus(OrderStatus.ORDER);
		order.setOrderDate(new Date());
		return order;
	}

	// business logics...
	public void cancel() {
		if(delivery.getStatus() == DeliveryStatus.COMP) {
			throw new RuntimeException("배송 완료된 상품은 취소할 수 없습니다.");
		}

		this.setStatus(OrderStatus.CANCEL);
		for(OrderItem orderItem : orderItems) {
			orderItem.cancel();
		}
	}

	public int getTotalPrice() {
		int totalPrice = 0;
		for(OrderItem orderItem : orderItems)
			totalPrice += orderItem.getTotalPrice();
		return totalPrice;
	}

	// relation methods...
	public void setMember(Member member) {
		this.member = member;
		member.getOrders().add(this);
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
		delivery.setOrder(this);
	}
}
