package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long id;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private int price;

	@Getter @Setter
	private int stockQuantity;
}
