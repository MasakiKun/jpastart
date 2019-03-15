package kr.ayukawa.jpastart.relation2.entity.manytomany;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column(name="product_id")
	@Getter @Setter
	private String id;

	@Getter @Setter
	private String name;
}
