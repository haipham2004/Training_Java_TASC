package com.example.Demo_Spring_Framework.RestController_Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Demo_Controller {

    @ResponseBody
    @GetMapping("hien-thi")
    private String HienThi(){
        return "Hảo Phạm YKA";
    }
}
