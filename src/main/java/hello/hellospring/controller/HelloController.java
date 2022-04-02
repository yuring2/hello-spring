package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model)
    {
        model.addAttribute("data","yuri!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model)
    {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name)
    {
        return "hello" + name;
    }


       @GetMapping("hello-api")
       @ResponseBody
       public Hello helloapi(@RequestParam("name")String name)
       {
           Hello hello = new Hello();
           hello.setName(name);
           return hello;    // 여기서는 문자가 아닌 클래스 hello의 객체를 넘김
       }



       static class Hello
       {
           private String name;

           public String getName() {
               return name;
           }

           public void setName(String name) {
               this.name = name;
           }

       }


}
