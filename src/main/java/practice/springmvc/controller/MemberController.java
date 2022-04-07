package practice.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import practice.springmvc.controller.form.MemberForm;
import practice.springmvc.domain.Member;
import practice.springmvc.service.MemberService;

import java.util.List;

@Controller // 스프링 컨테이너에 의해 bean으로 관리됩니다.
public class MemberController {

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // private final MemberService = new MemberService();
    // bean으로 관리되도록 합니다.Mem
    private final MemberService memberService;
    // 생성자가 필요합니다.

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping(value = "/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return "redirect:/";
    }

    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findAllMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
