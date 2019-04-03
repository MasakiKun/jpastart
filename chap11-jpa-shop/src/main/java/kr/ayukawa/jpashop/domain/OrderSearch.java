package kr.ayukawa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

public class OrderSearch {
	@Getter @Setter
	private String memberName;

	@Getter @Setter
	private OrderStatus orderStatus;
}
