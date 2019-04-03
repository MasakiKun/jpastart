package kr.ayukawa.jpashop.repository;

import kr.ayukawa.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
	@PersistenceContext
	EntityManager em;

	public void save(Member member) {
		em.persist(member);
	}

	public Member findOne(Long id) {
		return em.find(Member.class, id);
	}

	public List<Member> findAll() {
		return em.createQuery("select m from Member m where m.name=:name", Member.class)
				.getResultList();
	}

	public List<Member> findByNames(String name) {
		return em.createQuery("select m from Member m where m.name=:name", Member.class)
				.setParameter("name", name)
				.getResultList();
	}
}
