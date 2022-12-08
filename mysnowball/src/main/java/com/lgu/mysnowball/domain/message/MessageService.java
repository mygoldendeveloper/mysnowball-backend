package com.lgu.mysnowball.domain.message;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String getFriends() {
        String access_Token = "wzlU6p-N2jAZMT6Ox6iU7pT0MQ3MFNsLvVJ5KGdlCj1zFwAAAYTw9U_U";
        String reqURL = "https://kapi.kakao.com/v1/api/talk/friends";
        String response = "";
        try {
            // url connection
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.setConnectTimeout(5000); // 연결 타임아웃 설정(5초)
            conn.setReadTimeout(5000); // 읽기 타임아웃 설정(5초)

            // header 세팅
            conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
            conn.setRequestProperty("Authorization", "Bearer "+ access_Token);

            System.out.println("getContentType():" + conn.getContentType()); // 응답 콘텐츠 유형 구하기
            System.out.println("getResponseCode():"    + conn.getResponseCode()); // 응답 코드 구하기
            System.out.println("getResponseMessage():" + conn.getResponseMessage()); // 응답 메시지 구하기

            Charset charset = Charset.forName("UTF-8");
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), charset));

            String inputLine;
            StringBuffer sb = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }
            br.close();

            response = sb.toString();



        } catch (IOException e) {
            e.printStackTrace();
        }

        return access_Token;
    }
}
