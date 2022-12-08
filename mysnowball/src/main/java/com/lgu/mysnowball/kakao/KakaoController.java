package com.lgu.mysnowball.kakao;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/oauth")
public class KakaoController {

    @Autowired
    private KakaoService kakaoService;


    @RequestMapping(value = "/kakao")
    public void login(@RequestParam("code") String code) {
        String access_Token = kakaoService.getKakaoAccessToken(code);
        System.out.println("controller access_token : " + access_Token);

    }

    @RequestMapping(value = "/kakao/frined")
    public void getFrinds(@RequestParam("token") String token) {
        kakaoService.isFrind(token, "qwe");
    }

    @RequestMapping(value = "/kakao/agree")
    public void addAgree() {
        kakaoService.addAgree();
    }

    @RequestMapping(value = "/kakao/message")
    public void sendMessage(@RequestParam("token") String token){
        kakaoService.sendMessage(token, "");
    }
}