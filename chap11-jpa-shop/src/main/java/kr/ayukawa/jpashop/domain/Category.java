package kr.ayukawa.jpashop.domain;

import kr.ayukawa.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String name;

	@ManyToMany
	@JoinTable(
		name="CATEGORY_ITEM",
		joinColumns=@JoinColumn(name="CATEGORY_ID"),
		inverseJoinColumns=@JoinColumn(name="ITEM_ID")
	)
	@Getter @Setter
	private List<Item> items = new ArrayList<>();

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PARENT_ID")
	@Getter @Setter
	private Category parent;

	@OneToMany(mappedBy="parent")
	private List<Category> child = new ArrayList<>();

	// relation methos
	public void addChildCategory(Category child) {
		this.child.add(child);
		child.setParent(this);
	}
}
