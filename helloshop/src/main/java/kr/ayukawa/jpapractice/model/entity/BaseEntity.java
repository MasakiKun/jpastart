package kr.ayukawa.jpapractice.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@MappedSuperclass
public abstract class BaseEntity {
	@Getter @Setter
	private LocalDateTime createDate;

	@Getter @Setter
	private LocalDateTime lastModifiedDate;
}
