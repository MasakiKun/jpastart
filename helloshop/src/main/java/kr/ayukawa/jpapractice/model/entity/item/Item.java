package kr.ayukawa.jpapractice.model.entity.item;

import kr.ayukawa.jpapractice.model.entity.Category;
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
	@Column(name="item_id")
	@Getter @Setter
	private long id;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private int price;

	@Getter @Setter
	private int stockQuantity;

	@ManyToMany(mappedBy="items")
	@Getter @Setter
	private List<Category> categories = new ArrayList<>();
}
