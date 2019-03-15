package kr.ayukawa.jpapractice.model.entity;

import kr.ayukawa.jpapractice.model.entity.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(name="category_id")
	@Getter @Setter
	private long id;

	@Getter @Setter
	private String name;

	@ManyToMany
	@JoinTable(name="category_item",
		joinColumns=@JoinColumn(name="category_id"),
		inverseJoinColumns=@JoinColumn(name="item_id")
	)
	@Getter @Setter
	private List<Item> items = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name="parent_id")
	@Getter @Setter
	private Category parent;

	@OneToMany(mappedBy="parent")
	@Getter @Setter
	private List<Category> childs = new ArrayList<>();

	public void addChildCategory(Category child) {
		this.childs.add(child);
		child.setParent(this);
	}

	public void addItem(Item item) {
		items.add(item);
	}
}
