package kr.ayukawa.jpapractice.model.entity;

import kr.ayukawa.jpapractice.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	@Getter @Setter
	private Long id;

	@ManyToOne
	@JoinColumn(name="member_id")
	@Getter
	private Member member;

	@OneToMany(mappedBy="order")
	@Getter @Setter
	private List<OrderItem> orderItems = new ArrayList<>();

//	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OrderStatus status;

	public void setMember(Member member) {
		if(this.member != null)
			this.member.getOrders().remove(this);

		if(member != null) {
			this.member = member;
			this.member.getOrders().add(this);
		}
	}

	public void addOrderItem(OrderItem orderItem) {
		orderItems.add(orderItem);
		orderItem.setOrder(this);
	}
}
