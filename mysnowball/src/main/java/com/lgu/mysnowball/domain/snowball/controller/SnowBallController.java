package com.lgu.mysnowball.domain.snowball.controller;

import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentRequest;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallContentResponse;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallCreateRequest;
import com.lgu.mysnowball.domain.snowball.dto.SnowBallResponse;
import com.lgu.mysnowball.domain.snowball.service.SnowBallService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/snowball")
public class SnowBallController {

    private final SnowBallService snowBallService;

    @PostMapping
    public SnowBallResponse createSnowBall(@RequestBody SnowBallCreateRequest snowBallCreateRequest) {

        return this.snowBallService.createSnowball(snowBallCreateRequest);

    }

    @GetMapping("/content")
    public List<SnowBallContentResponse> getSnowBallContent(@RequestParam Long id) {

        return this.snowBallService.getSnowBallContents(id);
    }

    @PostMapping("/content")
    public SnowBallContentResponse createSnowBallContent(@RequestBody SnowBallContentRequest snowBallContentRequest, HttpServletRequest request) {

        return this.snowBallService.createSnowBallContent(snowBallContentRequest, request.getHeader("Authorization"));
    }

}
