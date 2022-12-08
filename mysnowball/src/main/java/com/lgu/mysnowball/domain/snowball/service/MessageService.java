package com.lgu.mysnowball.domain.snowball.service;

import com.lgu.mysnowball.domain.snowball.entity.SnowBall;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageService {


    final DefaultMessageService messageService;

    public MessageService() {
        this.messageService = NurigoApp.INSTANCE.initialize("NCSNTA1LHILLBK3V", "LV1E1NRCMY57GCJC0KCZNYETY20FKPOJ", "https://api.coolsms.co.kr");

    }

    /**
     * 단일 메시지 발송 예제
     */
    public void sendOne(String snowballMessage, String nickName, SnowBall snowBall, int order) {

        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01051162994");
        message.setTo(snowBall.getPhoneNumber().replaceAll("-", ""));
        message.setText(nickName + "님이 메시지를 보냈어요!\n-메시지 확인 \n https://mysnowball.me/snowball/" + snowBall.getId() + "?order=" + order + "\n-보답하기 \n https://gift.kakao.com");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        SingleMessageSentResponse response = this.messageService.sendOne(new SingleMessageSendingRequest(message));
        System.out.println(response);
    }
}
