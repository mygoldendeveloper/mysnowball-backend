package com.lgu.mysnowball.domain.snowball.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class SnowBallResponse {

    private Long id;

    private String nickName;

}
