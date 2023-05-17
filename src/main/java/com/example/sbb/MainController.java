package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//손님이 왔을때 처리해주는 종업원 같은 역할 컨트롤러 .
@Controller
public class MainController {
   @GetMapping("/")
    public String root (){
       return "redirect:/question/list";
   }

}
