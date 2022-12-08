package com.lgu.mysnowball.domain.snowball.dto;

import lombok.Getter;

@Getter
public class SnowBallCreateRequest {

    private Long id;

    private String nickName;

    private String accessToken;

    private String refreshToken;
}
