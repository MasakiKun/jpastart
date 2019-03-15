package kr.ayukawa.jpapractice.model.entity.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A")
public class Album extends Item {
	@Getter @Setter
	private String artist;

	@Getter @Setter
	private String etc;
}
