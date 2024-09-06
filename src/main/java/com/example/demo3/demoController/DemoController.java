package com.example.demo3.demoController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangjinyue
 * @date 2024/09/06 11:40
 * Copyright
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello(){
        return "测试jenkins自动化部署";
    }


}
