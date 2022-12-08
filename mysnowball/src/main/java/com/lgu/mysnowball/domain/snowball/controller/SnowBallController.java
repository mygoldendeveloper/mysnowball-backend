package com.lgu.mysnowball.domain.snowball.controller;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentResponse;
import com.lgu.mysnowball.domain.snowball.service.SnowBallService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snowball")
public class SnowBallController {

    private final SnowBallService snowBallService;

    @PostMapping
    public void createSnowBall() {
        //snowball 생성

    }

    @GetMapping
    public List<SnowBallContentResponse> getSnowBall(@RequestParam Long id) {

        return snowBallService.getSnowBallContents(id);
    }

}
