package kr.ayukawa.jpashop.service;

import kr.ayukawa.jpashop.domain.Member;
import kr.ayukawa.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="classpath:appConfig.xml")
@Transactional
public class MemberServiceTest {
	@Autowired
	MemberService memberService;

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void 회원가입() throws Exception {
		// Given
		Member member = new Member();
		member.setName("kim");

		// When
		Long saveId = memberService.join(member);

		// Then
		assertEquals(member, memberRepository.findOne(saveId));
	}

	@Test
	public void 중복_회원_예외() throws Exception {
		// Given
		Member member1 = new Member();
		member1.setName("kim");

		Member member2 = new Member();
		member2.setName("kim");

		// When , Then
		Assertions.assertThrows(IllegalStateException.class, () -> {
			memberService.join(member1);
			memberService.join(member2);
		});
	}
}
