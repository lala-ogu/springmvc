package practice.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import practice.springmvc.repository.JdbcMemberRepository;
import practice.springmvc.repository.MemberRepository;
import practice.springmvc.repository.MemoryMemberRepository;
import practice.springmvc.repository.JdbcTemplateMemberRepository;
import practice.springmvc.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource){
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
        // return new MemoryMemberRepository();
        // return new JdbcMemberRepository();
    }
}
