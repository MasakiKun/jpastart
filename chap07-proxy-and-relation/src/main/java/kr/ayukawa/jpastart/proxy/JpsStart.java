package kr.ayukawa.jpastart.proxy;

import kr.ayukawa.jpastart.proxy.entity.Member;
import kr.ayukawa.jpastart.proxy.entity.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JpsStart {
	private static Logger logger = Logger.getLogger(JpsStart.class.getName());

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("proxy");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etx = em.getTransaction();

		// 기초 데이터 저장
		try {
			logger.log(Level.INFO, "기초 데이터 영속화 시작");

			etx.begin();

			Team team1 = new Team();
			team1.setId("team1");
			team1.setTeamName("팀 1");

			em.persist(team1);

			Member member1 = new Member();
			member1.setId("member1");
			member1.setName("회원1");
			member1.setTeam(team1);

			em.persist(member1);

			Member member2 = new Member();
			member2.setId("member2");
			member2.setName("회원2");
			member2.setTeam(team1);

			em.persist(member2);

			etx.commit();

			logger.log(Level.INFO, "영속화 끝");
		} catch(Exception e) {
			logger.log(Level.SEVERE, "영속화 중 오류 발생. 프로그램 종료");
			try { e.printStackTrace(); } catch (Exception ex) { e.printStackTrace(); }
			try { etx.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
			try { em.close(); } catch (Exception ex) { ex.printStackTrace(); }
			try { emf.close(); } catch (Exception ex) { e.printStackTrace(); }

			java.lang.System.exit(1);
		} finally {
			em.close();
		}

		// EntityManager를 close해서, 모든 영속성 객체를 비영속성화한다
		em = emf.createEntityManager();

		// 데이터를 조회해서, 즉시조회/간접조회시의 데이터 타입을 확인한다
		try {
			logger.info("영속 데이터 조회");

			logger.info("member1 조회 (즉시 로딩)");
			Member member1 = em.find(Member.class, "member1");
			logger.info("member1 type: " + member1.getClass().getName());
			logger.info("member1's name: " + member1.getName());
			logger.info("member1의 팀 데이터 가져옴");
			Team member1Team = member1.getTeam();
			logger.info("member1's team type: " + member1Team.getClass().toString());
			logger.info("member1's team name: " + member1Team.getTeamName());

			System.out.println();

			logger.info("member2 조회 (지연 로딩)");
			Member member2 = em.getReference(Member.class, "member2");
			logger.info("member2 type: " + member2.getClass().getName());
			logger.info("member2's name: " + member2.getName());
			logger.info("member2의 팀 데이터 가져옴");
			Team member2Team = member2.getTeam();
			logger.info("member2's team type: " + member2Team.getClass().getName());
			logger.info("member2's team name: " + member2Team.getTeamName());
		} catch(Exception e) {
			e.printStackTrace();
//			etx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
