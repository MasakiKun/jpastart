package kr.ayukawa.jpapractice.model.entity;

import kr.ayukawa.jpapractice.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	@Getter @Setter
	private Long id;

	@Column(name="member_id")
	@Getter @Setter
	private Long memberId;

//	@Temporal(TemporalType.TIMESTAMP)
	@Getter @Setter
	private LocalDateTime orderDate;

	@Enumerated(EnumType.STRING)
	@Getter @Setter
	private OrderStatus status;
}
