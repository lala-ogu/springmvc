package practice.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //컨트롤러 역할을 부여하는 어노테이션
public class SpringController {
    
    @GetMapping("hello")    // "../hello"의 경로로 Get방식으로 들어오는 경우 해당 메소드를 실행
    public String hello(Model model){   // mvc의 model을 뜻합니다.
        model.addAttribute("data", "hello!!");
        // 첫번째 파라미터는 attribute의 이름, 두번째는 attribute의 값입니다.
        // 템플릿엔진 문법에 의해 data라는 attribute는 값으로 치환됩니다.
        return "hello";
        // 템플릿엔진의 hello.html을 보여줍니다.
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        // @requestparam = 파라미터로 값을 넘길 때 사용합니다.        
        // 파라미터값으로 ?name=ddd 로 넘겼다면 메소드의 name 파라미터가 ddd로 값이 정해집니다.
        // string 값 name의 값은 ddd가 됩니다.
        model.addAttribute("name", name);
        // 모델의 name attribute의 값을 ddd로 설정합니다.
        return "hello-template";
    }


    @GetMapping("hello-string")
    @ResponseBody
    // reponsbody : http의 body에 직접 return 값을 넣는다는 의미입니다.
    public String helloString(@RequestParam(value = "name", required = false) String name){
        // required : 파라미터 입력이 필수인지 설정합니다.
        return "hello" + name;
        // 해당하는 페이지를 리턴하는 것이 아닌 데이터 그자체를 리턴합니다.
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
        // 객체를 JSON 방식으로 리턴하게 합니다.
    }

    static class Hello{
        // 내부클래스
        private String name;
        // 라이브러리등 에서 외부에서 사용할 때 게터세터를 이용하여 접근하도록 합니다.

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        
    }
}
