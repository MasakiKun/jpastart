package kr.ayukawa.jpastart.relation2;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStart {
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("relation2");

	public static void main(String[] args) {

	}
}
