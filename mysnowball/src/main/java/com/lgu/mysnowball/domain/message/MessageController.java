package com.lgu.mysnowball.domain.message;

import com.lgu.mysnowball.kakao.KakaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kakao/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping()
    public void saveMessage(){

    }

    @GetMapping(value = "/frineds")
    public void login() {
        String access_Token = messageService.getFriends();
    }

}
