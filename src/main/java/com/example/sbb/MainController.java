package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

//손님이 왔을때 처리해주는 종업원 같은 역할 컨트롤러 .
@Controller
public class MainController {
    @GetMapping("/minus")
    @ResponseBody
    public int showMinus(int a, int b) {
        return a - b;
    }


    int c;

    @GetMapping("/increase")
    @ResponseBody
    public int showIncrease() {

        return c++;

    }

    @GetMapping("/Mbti/{name}")
    @ResponseBody
    public String showMbti(@PathVariable String name) {
        return switch (name) {
            case "오택주" -> {
                char j = 'J';
                yield "IST"+j;
            }
            case "홍길순", "임꺽정" -> "ENFP";
            case "반장" -> "ESTJ";
            default -> "모름";

        };
    }


}
