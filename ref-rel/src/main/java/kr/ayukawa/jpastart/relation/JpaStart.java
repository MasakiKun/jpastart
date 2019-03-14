package kr.ayukawa.jpastart.relation;

import kr.ayukawa.jpastart.relation.model.Member;
import kr.ayukawa.jpastart.relation.model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaStart {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("relation");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		try {
			etx.begin();

			Member member = em.find(Member.class, "member2");
			// 무한루프 발생!!!
			//    Member.toString() 에서 team 필드의 Team.toString() 을 호출하고,
			//    Team.toString() 에서 members 필드의 List<Member>.toString()을 호출하고,
			//    List<Member>.toString() 에서 Member.toString() 을 호출하고,
			//    Member.toString() 에서 team 필드의 Team.toString() 을 호출하고
			//    ......
			System.out.println(member);

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
