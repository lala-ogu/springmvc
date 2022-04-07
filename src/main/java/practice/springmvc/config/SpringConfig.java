package practice.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.springmvc.aop.TimeTraceAop;
import practice.springmvc.repository.*;
import practice.springmvc.service.MemberService;

@Configuration
public class SpringConfig {

//    private DataSource dataSource;
//
//    @Autowired
//    public SpringConfig(DataSource dataSource){
//        this.dataSource = dataSource;
//    }

//    @PersistenceContext
//    private EntityManager em;

    private  final  MemberRepository memberRepository;

    @Autowired  // 생성자가 하나라면 생략 가능
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

    @Bean
    public TimeTraceAop timeTraceAop() {
        return new TimeTraceAop();
    }

//    @Bean
//    public MemberRepository memberRepository() {
        // return new JdbcTemplateMemberRepository(dataSource);
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository();
        // return new JpaMemberRepository(em);
//    }
}
