package com.lgu.mysnowball.domain.snowball.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/snowball")
public class SnowBallController {

    @PostMapping
    public void createSnowBall(){
        //snowball 생성

    }

    @GetMapping
    public void getSnowBall(){
        //snowball 가져오기
    }

}
