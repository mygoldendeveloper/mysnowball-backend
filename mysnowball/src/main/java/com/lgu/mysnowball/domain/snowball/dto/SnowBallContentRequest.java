package com.lgu.mysnowball.domain.snowball.dto;

import lombok.Getter;

@Getter
public class SnowBallContentRequest {

    private Long senderId;

    private Long receiverId;

    private String nickName;

    private String content;
}
