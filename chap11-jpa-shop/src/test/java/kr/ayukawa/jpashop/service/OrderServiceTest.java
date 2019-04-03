package kr.ayukawa.jpashop.service;

import kr.ayukawa.jpashop.domain.Address;
import kr.ayukawa.jpashop.domain.Member;
import kr.ayukawa.jpashop.domain.Order;
import kr.ayukawa.jpashop.domain.OrderStatus;
import kr.ayukawa.jpashop.domain.item.Book;
import kr.ayukawa.jpashop.domain.item.Item;
import kr.ayukawa.jpashop.exception.NotEnoughStockException;
import kr.ayukawa.jpashop.repository.OrderRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.test.util.AssertionErrors.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:appConfig.xml")
@Transactional
public class OrderServiceTest {
	@PersistenceContext
	EntityManager em;

	@Autowired
	OrderService orderService;

	@Autowired
	OrderRepository orderRepository;

	@Test
	public void 상품주문() throws Exception {
		// Given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10);
		int orderCount = 2;

		// When
		Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

		// Then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals("상품 주문시 상태는 ORDER", OrderStatus.ORDER, getOrder.getStatus());
		assertEquals("주문한 상품 종류 수가 정확해야 한다", 1, getOrder.getOrderItems().size());
		assertEquals("주문 가격은 가격 * 수량", 10000 * 2, getOrder.getTotalPrice());
		assertEquals("주문 수량만큼 재고는 줄어들어야 한다", 8, item.getStockQuantity());
	}

	@Test
	public void 상품주문_재고수량초과() throws Exception {
		// Given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10);
		int orderCount = 11;

		// When / Then
		Assertions.assertThrows(NotEnoughStockException.class, () -> {
			orderService.order(member.getId(), item.getId(), orderCount);
		});
	}

	@Test
	public void 주문취소() throws Exception {
		// Given
		Member member = createMember();
		Item item = createBook("시골 JPA", 10000, 10);
		int orderCount = 2;

		Long orderId = orderService.order(member.getId(), item.getId(), orderCount);

		// When
		orderService.cancelOrder(orderId);

		// Then
		Order getOrder = orderRepository.findOne(orderId);

		assertEquals("주문 취소시 상태는 CANCEL", OrderStatus.CANCEL, getOrder.getStatus());
		assertEquals("주문 취소된 상품은 그만큼 재고 증가", 10, item.getStockQuantity());
	}

	private Book createBook(String name, int price, int stockQuantity) {
		Book book = new Book();
		book.setName(name);
		book.setStockQuantity(stockQuantity);
		book.setPrice(price);
		em.persist(book);
		return book;
	}

	private Member createMember() {
		Member member = new Member();
		member.setName("회원1");
		member.setAddress(new Address("서울", "강가", "123-123"));
		em.persist(member);
		return member;
	}
}
