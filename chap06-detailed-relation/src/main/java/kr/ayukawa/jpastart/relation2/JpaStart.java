package kr.ayukawa.jpastart.relation2;

import kr.ayukawa.jpastart.relation2.entity.manytomany.Member;
import kr.ayukawa.jpastart.relation2.entity.manytomany.Order;
import kr.ayukawa.jpastart.relation2.entity.manytomany.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStart {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("relation2");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		try {
			etx.begin();

			// 회원
			Member member1 = new Member();
			member1.setId("member1");
			member1.setUsername("회원1");
			em.persist(member1);

			// 상품
			Product productA = new Product();
			productA.setId("productA");
			productA.setName("상품A");
			em.persist(productA);

			// 주문
			Order order = new Order();
			order.setMember(member1);
			order.setProduct(productA);
			order.setOrderAmount(2);
			em.persist(order);

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
