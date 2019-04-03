package kr.ayukawa.jpashop.domain.item;

import kr.ayukawa.jpashop.domain.Category;
import kr.ayukawa.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="DTYPE")
public abstract class Item {
	@Id
	@GeneratedValue
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private int price;

	@Getter @Setter
	private int stockQuantity;

	@ManyToMany(mappedBy="items")
	@Getter @Setter
	private List<Category> categories = new ArrayList<>();

	// business logic
	public void addStock(int quantity) {
		this.stockQuantity += quantity;
	}

	public void removeStock(int quantity) {
		int restStock = this.stockQuantity - quantity;
		if(restStock < 0)
			throw new NotEnoughStockException("need more stock");
		this.stockQuantity = restStock;
	}
}
