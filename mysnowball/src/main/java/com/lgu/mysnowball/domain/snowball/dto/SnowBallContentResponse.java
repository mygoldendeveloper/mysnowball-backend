package com.lgu.mysnowball.domain.snowball.dto;

import java.util.List;
import lombok.Setter;

@Setter
public class SnowBallContentResponse {

    private Long id;

    private String name;

    private List<String> contentList;

}
