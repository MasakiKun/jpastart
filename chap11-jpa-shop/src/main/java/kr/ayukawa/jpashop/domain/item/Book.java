package kr.ayukawa.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B)")
public class Book extends Item {
	@Getter @Setter
	private String author;

	@Getter @Setter
	private String isbn;
}
