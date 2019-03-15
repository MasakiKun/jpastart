package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
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
