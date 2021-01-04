package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    /* MVC와 템플릿엔진 방식 */
    @GetMapping("hello") //웹어플리케이션 url에 GET방식으로 /hello  라고 들어오면 이 메소드를 호출해줌
    public String hello(Model model) { //mvc모델에서의 그 model임
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    /* API 방식 */
    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    /* API 방식 - json형태로 반환 */
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello { /* static 붙여주면 HelloController.Hello instance1 = new HelloController.Hello();
                            와 같이 외부클래스의 인스턴스를 따로 생성하지 않고도 내부클래스의 인스턴스를 생성가능*/
        private String name; //private으로 인해 외부에서 바로 못꺼냄. getter,setter통해 접근함.(프로퍼티 접근방식? 이라고부름)

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}
