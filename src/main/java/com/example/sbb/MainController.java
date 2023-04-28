package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//손님이 왔을때 처리해주는 종업원 같은 역할 컨트롤러 .
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String index(){
        return "안녕하세요 sbb에 오신것을 환영합니다";
    }
}
