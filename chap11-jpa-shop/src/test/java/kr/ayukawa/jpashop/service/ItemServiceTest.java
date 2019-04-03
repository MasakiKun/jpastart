package kr.ayukawa.jpashop.service;

import kr.ayukawa.jpashop.domain.item.Book;
import kr.ayukawa.jpashop.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:appConfig.xml")
@Transactional
public class ItemServiceTest {
	@Autowired
	ItemService itemService;

	@Autowired
	ItemRepository itemRepository;

	@Test
	public void 상품추가() throws Exception {
		// Given
		Book book = new Book();
		book.setName("어린왕자");
		book.setAuthor("생텍쥐페리");

		// When
		itemService.saveItem(book);
		long id = book.getId();

		// Then
		assertEquals(book, itemService.findOne(id));
	}
}
