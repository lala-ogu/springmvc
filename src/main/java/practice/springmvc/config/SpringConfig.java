package practice.springmvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.springmvc.repository.MemberRepository;
import practice.springmvc.repository.MemoryMemberRepository;
import practice.springmvc.service.MemberService;

@Configuration
public class SpringConfig {

//    @Bean
//    public MemberService memberService(){
//        return new MemberService(memberRepository());
//    }
//
//    @Bean
//    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
//    }
}
