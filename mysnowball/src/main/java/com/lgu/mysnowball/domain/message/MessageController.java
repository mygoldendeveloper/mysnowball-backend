package com.lgu.mysnowball.domain.message;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kakao/message")
public class MessageController {

    @PostMapping()
    public void saveMessage(){

    }

}
