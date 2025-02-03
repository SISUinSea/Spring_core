package hello.core.member;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.Appconfig;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        Appconfig appconfig = new Appconfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join() {
        // given
        Member member = new Member(1l, "member 1", Grade.VIP);
        memberService.join(member);

        // when
        Member findMember = memberService.findMember(member.getId());

        // then
        Assertions.assertThat(findMember).isEqualTo(member);
    }


}