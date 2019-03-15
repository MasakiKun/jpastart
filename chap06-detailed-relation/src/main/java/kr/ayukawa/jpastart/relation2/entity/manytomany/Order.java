package kr.ayukawa.jpastart.relation2.entity.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@GeneratedValue
	@Column(name="order_id")
	@Getter @Setter
	private long id;

	@ManyToOne
	@JoinColumn(name="member_id")
	@Getter @Setter
	private Member member;

	@ManyToOne
	@JoinColumn(name="product_id")
	@Getter @Setter
	private Product product;

	@Getter @Setter
	private int orderAmount;
}
