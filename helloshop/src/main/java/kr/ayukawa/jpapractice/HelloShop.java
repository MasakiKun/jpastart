package kr.ayukawa.jpapractice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class HelloShop {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloshop");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		try {
			etx.begin();
			etx.commit();
		} catch(Exception e) {
			e.printStackTrace();
			etx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
